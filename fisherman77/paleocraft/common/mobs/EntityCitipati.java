package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityCitipati extends EntityAnimal
{
	
 public EntityCitipati(World world) 
 {
	 super(world);
  
  this.setSize(1.0F, 1.0F);
  
  this.getNavigator().setAvoidsWater(true);
  
  this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityChicken.class, 1.0D, false));
  this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
  this.tasks.addTask(2, new EntityAIWander(this, 0.5D));
  this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, 0, true));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityBaryonyx.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntitySpino.class, 8.0F, 0.8D, 0.8D));
 // this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityDromaeosaurus.class, 8.0F, 0.6D, 0.6D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMegalodon.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityTylo.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityQuetzalcoatlus.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityCryo.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(0, new EntityAISwimming(this));
 }
 
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5); // moveSpeed
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.5); // maxHealth
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
	playSound("Paleocraft:mob.citipati.citiliving", getSoundVolume(), getSoundPitch());
	return null;
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
@Override
protected String getHurtSound()
{
	playSound("Paleocraft:mob.citipati.citihurt", getSoundVolume(), getSoundPitch());
	return null;
}

/**
 * Returns the sound this mob makes on death.
 */
@Override
protected String getDeathSound()
{
	playSound("Paleocraft:mob.other.smallherbdeath", getSoundVolume(), getSoundPitch());
	return null;
}

protected boolean canDespawn()
{
return false;
}

@Override
public EntityAgeable createChild(EntityAgeable entityageable) {
	// TODO Auto-generated method stub
	return null;
}

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
}
