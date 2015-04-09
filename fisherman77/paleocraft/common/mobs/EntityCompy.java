package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityCompy extends EntityTameable
{

 public EntityCompy(World par1World) 
 {
  super(par1World);
  
  this.setSize(0.5F, 0.5F);
  
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
  this.tasks.addTask(4, new EntityAIWander(this, 0.4));
  this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
  this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
 // this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityChicken.class, 1.0, false));
  //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityChicken.class, 0, true));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityBaryonyx.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntitySpino.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityDromaeosaurus.class, 8.0F, 0.6D, 0.6D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMegalodon.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityTylo.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityQuetzalcoatlus.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityCryo.class, 8.0F, 0.8D, 0.8D));
 
 }
 
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();

	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4); // moveSpeed
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2); // maxHealth
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
	playSound("Paleocraft:mob.compy.Compy", getSoundVolume(), getSoundPitch());
	return null;
}

 /**
  * Returns the sound this mob makes when it is hurt.
  */
 @Override
 protected String getHurtSound()
 {
 	playSound("Paleocraft:mob.compy.CompyHurt", getSoundVolume(), getSoundPitch());
 	return null;
 }
 /**
  * Returns the sound this mob makes on death.
  */
 @Override
 protected String getDeathSound()
 {
 	playSound("Paleocraft:mob.compy.CompyDeath", getSoundVolume(), getSoundPitch());
 	return null;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

//compy has a sword o_O
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
