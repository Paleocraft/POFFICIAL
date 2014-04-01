package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityDromaeosaurus extends EntityTameable
{
	
 public EntityDromaeosaurus(World par1World) 
 {
  super(par1World);
  
  this.setSize(1.0F, 1.0F);
  
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
  this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityChicken.class, 0.9, false));
  this.tasks.addTask(3, new EntityAIFollowOwner(this, 0.9, 10.0F, 2.0F));
  this.tasks.addTask(4, new EntityAIWander(this, 0.4));
  this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
  this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
  this.targetTasks.addTask(3, new EntityAIOwnerHurtTarget(this));
  this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityChicken.class, 0, true));
  this.setTamed(false);
 }
 
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4); // moveSpeed
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(9); // maxHealth
	}
 
 /**
  * (abstract) Protected helper method to write subclass entity data to NBT.
  */
 public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
 {
     super.writeEntityToNBT(par1NBTTagCompound);
     par1NBTTagCompound.setBoolean("Angry", this.isAngry());
 }

 /**
  * (abstract) Protected helper method to read subclass entity data from NBT.
  */
 public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
 {
     super.readEntityFromNBT(par1NBTTagCompound);
     this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
 }
 
 protected boolean isAIEnabled()
 {
     return true;
 }
 
 /**
  * Returns the sound this mob makes while it's alive.
  */
 protected String getLivingSound()
 {
     return "paleocraft:dromieliving";
 }

 /**
  * Returns the sound this mob makes when it is hurt.
  */
 protected String getHurtSound()
 {
     return "paleocraft:dromiehurt";
 }

 /**
  * Returns the sound this mob makes on death.
  */
 protected String getDeathSound()
 {
     return "paleocraft:smallcarndeath";
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }


/*protected void func_82164_bB()
{
    this.setCurrentItemOrArmor(0, new ItemStack(Item.swordStone));
}*/

//ATTACKING OTHER MOBS - OVERRIDING ENTITYANIMAL
/**
 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
 */
protected void attackEntity(Entity par1Entity, float par2)
{
    if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
    {
        this.attackTime = 20;
        this.attackEntityAsMob(par1Entity);
    }
}

public boolean attackEntityAsMob(Entity par1Entity)
{
	int i = 10; //attackStrength
    return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
}

@Override
public EntityAgeable createChild(EntityAgeable entityageable) {
	// TODO Auto-generated method stub
	return null;
}

/**
 * TAMABILITY
 */
/**
 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
 */
public boolean interact(EntityPlayer par1EntityPlayer)
{
	ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
	
	if (itemstack != null && itemstack == Items.beef)
    {
		if(!this.isAngry())
		{
			if(this.isTamed() == false){
				if (!par1EntityPlayer.capabilities.isCreativeMode)
				{
					--itemstack.stackSize;
				}
	
				if (itemstack.stackSize <= 0)
				{
					par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
				}
				
				if (!this.worldObj.isRemote)
				{
	                this.setTamed(true);
	                this.setPathToEntity((PathEntity)null);
	                this.setAttackTarget((EntityLiving)null);
	                this.setHealth(20);
	                this.setOwner(par1EntityPlayer.username);
	                this.playTameEffect(true);
	                this.worldObj.setEntityState(this, (byte)7);
	                par1EntityPlayer.addChatMessage("[Paleocraft] You have tamed this dromaeosaurus!");
				}
			}
			else if(this.isTamed() == true){
				par1EntityPlayer.addChatMessage("[Paleocraft] This Dromaeosaurus is already tamed.");
			}
	    }
		else if(this.isAngry())
		{
				par1EntityPlayer.addChatMessage("[Paleocraft] Trying to tame an angry Dromie? Really?");
		}
    }
	else
	{
		par1EntityPlayer.addChatMessage("[Paleocraft] You need raw meat to tame a Dromaeosaurus.");
	}
	
	return true;
}

/**
 * Sets the active target the Task system uses for tracking
 */
public void setAttackTarget(EntityLivingBase par1EntityLivingBase)
{
    super.setAttackTarget(par1EntityLivingBase);

    if (par1EntityLivingBase == null)
    {
        this.setAngry(false);
    }
    else if (!this.isTamed())
    {
        this.setAngry(true);
    }
}

/**
 * Determines whether this wolf is angry or not.
 */
public boolean isAngry()
{
    return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
}

/**
 * Sets whether this wolf is angry or not.
 */
public void setAngry(boolean par1)
{
    byte b0 = this.dataWatcher.getWatchableObjectByte(16);

    if (par1)
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
    }
    else
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
    }
}

}
