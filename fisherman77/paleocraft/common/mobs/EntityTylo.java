package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import fisherman77.paleocraft.common.mobs.ai.WaterDinoAIFishSwimming;
import fisherman77.paleocraft.common.mobs.ai.WaterDinoAIWander;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
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


public class EntityTylo extends EntityWaterMob
{


public EntityTylo(World par1World)  
 {
  super(par1World);	
  
  this.setSize(2.5F, 2.5F);
  
  this.getNavigator().setAvoidsWater(false);
  
  //this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false));
  this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntitySquid.class, 1.0F, false));
  this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityBoat.class, 1.0F, false));
  //this.tasks.addTask(1, new WaterDinoAIWander(this, 0.2F));
  this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true)); 
  this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
  this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityBoat.class, 0, true));
  this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySquid.class, 0, true));
  this.tasks.addTask(1, new WaterDinoAIFishSwimming(this));
  this.tasks.addTask(1, new WaterDinoAIWander(this, 0.4F));
  this.getNavigator().setCanSwim(true);
 }

@Override
protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0); // moveSpeed
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40); // maxHealth
} 
 
//ATTACKING OTHER MOBS - OVERRIDING ENTITYWATERMOB
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
	int i = 20; //attackStrength
   return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
}

/**
 * Checks if the entity's current position is a valid location to spawn this entity.
 */
public boolean getCanSpawnHere()
{
    return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere();
}

/**
 * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
 * true)
 */
public boolean isInWater()
{
    return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
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
	 playSound("Paleocraft:mob.tylo.tyloliving", getSoundVolume(), getSoundPitch());
		return null;
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
protected String getHurtSound()
{
	 playSound("Paleocraft:mob.tylo.TyloHurt", getSoundVolume(), getSoundPitch());
		return null;
}

/**
 * Returns the sound this mob makes on death.
 */
protected String getDeathSound()
{
	 playSound("Paleocraft:mob.other.largecarndeath", getSoundVolume(), getSoundPitch());
		return null;
}

protected boolean canDespawn()
{
return false;
}

/**
 * Gets called every tick from main Entity class
 */
public void onEntityUpdate()
{
    int i = this.getAir();
    super.onEntityUpdate();

    if (this.isEntityAlive() && !this.isInWater())
    {
        --i;
        this.setAir(i);

        if (this.getAir() == -20)
        {
            this.setAir(0);
            this.attackEntityFrom(DamageSource.drown, 15.0F);
        }
    }
    else
    {
        this.setAir(300);
    }
}

}
