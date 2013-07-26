package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
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
	
	private double moveSpeed;
	private int maxHealth;
	private int attackStrength;
  
 public EntityTylo(World par1World) 
 {
  super(par1World);	

	//STATS
	  //-------------------
	  this.moveSpeed = 0.4D;
	  this.maxHealth = 9;
	  this.attackStrength = 2;
	  //-------------------
  
  this.setSize(1.0F, 1.0F);
  
  //this.getNavigator().setAvoidsWater(true);
  
  this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
  this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.getNavigator().setCanSwim(true);}
  

 
/**
  * Returns the amount of damage a mob should deal.
  */
 public int getAttackStrength(Entity par1Entity)
 {
	 return 2;
 }
 
 public int getMaxHealth() 
 {
  return 9;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
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
    return "paleocraft.Tylo.Tylo1";
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
protected String getHurtSound()
{
    return "paleocraft.Tylo.TyloHurt";
}

/**
 * Returns the sound this mob makes on death.
 */
protected String getDeathSound()
{
    return "paleocraft.Tylo.LargeCarnDeath";
}

protected boolean canDespawn()
{
return false;
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
    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
    int i = 0;

    if (par1Entity instanceof EntityLivingBase)
    {
        f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)par1Entity);
        i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)par1Entity);
    }

    boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);

    if (flag)
    {
        if (i > 0)
        {
            par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
        }

        int j = EnchantmentHelper.getFireAspectModifier(this);

        if (j > 0)
        {
            par1Entity.setFire(j * 4);
        }

        if (par1Entity instanceof EntityLivingBase)
        {
            EnchantmentThorns.func_92096_a(this, (EntityLivingBase)par1Entity, this.rand);
        }
    }

    return flag;
}
}
