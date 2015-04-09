package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockColored;
import net.minecraft.command.ICommandSender;
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
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityDromaeosaurus extends EntityTameable 
{
	
	    private float field_70926_e;
	    private float field_70924_f;
	    /** true is the wolf is wet else false */
	    private boolean isShaking;
	    private boolean field_70928_h;
 public EntityDromaeosaurus(World par1World) 
 {
  super(par1World);
  
  this.setSize(1.0F, 1.0F);
  
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
  this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityChicken.class, 0.9, false));
  this.tasks.addTask(3, new EntityAIFollowOwner(this, 0.9, 10.0F, 2.0F));
  this.tasks.addTask(4, new EntityAIWander(this, 0.5));
  this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
  this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
  this.targetTasks.addTask(3, new EntityAIOwnerHurtTarget(this));
  this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityChicken.class, 0, true));
  this.tasks.addTask(2, this.aiSit);
  this.setTamed(false);
 
 }
 
 
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5); // moveSpeed
	//    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(9); // maxHealth
	      if (this.isTamed())
	        {
	            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
	        }
	        else
	        {
	            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.5D);
	        }
	
	
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
 @Override
	protected String getLivingSound()
{
	playSound("Paleocraft:mob.dromie.dromieliving", getSoundVolume(), getSoundPitch());
	return null;
}
 /**
  * Returns the sound this mob makes when it is hurt.
  */
 @Override
	protected String getHurtSound()
{
	playSound("Paleocraft:mob.dromie.dromiehurt", getSoundVolume(), getSoundPitch());
	return null;
}

 /**
  * Returns the sound this mob makes on death.
  */
 @Override
	protected String getDeathSound()
{
	playSound("Paleocraft:mob.other.smallcarndeath", getSoundVolume(), getSoundPitch());
	return null;
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




public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
{
    if (this.isEntityInvulnerable())
    {
        return false;
    }
    else
    {
        Entity entity = p_70097_1_.getEntity();
        this.aiSit.setSitting(false);

        if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
        {
            p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
        }

        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }
}

public boolean attackEntityAsMob(Entity p_70652_1_)
{
	int i = this.isTamed() ? 4 : 2;
    return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
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
 * @param par1EntityPlayer 
 * @param p_70085_1_ 
 */

/*public boolean interact(EntityPlayer p_70085_1_)
{
    ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

    if (this.isTamed())
    {
        if (itemstack != null)
        {
            if (itemstack.getItem() instanceof ItemFood)
            {
                ItemFood itemfood = (ItemFood)itemstack.getItem();

                if (itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F)
                {
                    if (!p_70085_1_.capabilities.isCreativeMode)
                    {
                        --itemstack.stackSize;
                    }

                    this.heal((float)itemfood.func_150905_g(itemstack));

                    if (itemstack.stackSize <= 0)
                    {
                        p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
            }
            
            
        }

        if (this.func_152114_e(p_70085_1_) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
        {
            
            this.isJumping = false;
            this.setPathToEntity((PathEntity)null);
            this.setTarget((Entity)null);
            this.setAttackTarget((EntityLivingBase)null);
        }
    }
    else if (itemstack != null && itemstack.getItem() == Items.beef && !this.isAngry())
    {
        if (!p_70085_1_.capabilities.isCreativeMode)
        {
            --itemstack.stackSize;
        }

        if (itemstack.stackSize <= 0)
        {
            p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
        }

     

        return true;
    }

    return super.interact(p_70085_1_);
}*/
            
        
protected void attackEntity(Entity par1Entity, float par2)
{
    if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
    {
        this.attackTime = 20;
        this.attackEntityAsMob(par1Entity);
    }
}


public boolean interact(EntityPlayer par1EntityPlayer)

{
	ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
	
if	(itemstack != null && itemstack.getItem() == Items.beef)
	 
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
	                this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
	                this.playTameEffect(true);
	                this.worldObj.setEntityState(this, (byte)7);
	                ((EntityPlayer) par1EntityPlayer).addChatComponentMessage(new ChatComponentTranslation("tile.taming.dromie", new Object[0]));
	               this.aiSit.setSitting(true);
	             
	                
	                return true;
				
				}
			}
			else if(this.isTamed() == true){
				//par1EntityPlayer.addChatMessage("[Paleocraft] This Dromaeosaurus is already tamed.");
				((EntityPlayer) par1EntityPlayer).addChatComponentMessage(new ChatComponentTranslation("tile.tamed.dromie", new Object[0]));
				// this.aiSit.setSitting(true);
			}
			
	}
		else if(this.isAngry())
		{
				//par1EntityPlayer.addChatMessage("[Paleocraft] Trying to tame an angry Dromie? Really?");
			((EntityPlayer) par1EntityPlayer).addChatComponentMessage(new ChatComponentTranslation("tile.ATaming.dromie", new Object[0]));
			 this.playTameEffect(false);
		
		}
    }
	else if(this.isTamed() == false)
	{
		//par1EntityPlayer.addChatMessage("[Paleocraft] You need raw meat to tame a Dromaeosaurus.");
		((EntityPlayer) par1EntityPlayer).addChatComponentMessage(new ChatComponentTranslation("tile.Wrong.dromie", new Object[0]));
		 this.worldObj.setEntityState(this, (byte)7);
		 this.playTameEffect(false);
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
public void setAngry(boolean p_70916_1_)
{
    byte b0 = this.dataWatcher.getWatchableObjectByte(16);

    if (p_70916_1_)
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
    }
    else
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
    }
}


protected void dropFewItems(boolean par1, int par2)
{
  this.dropItem(Items.feather, 3);
}
}
