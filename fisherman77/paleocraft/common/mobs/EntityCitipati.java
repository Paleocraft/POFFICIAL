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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityCitipati extends EntityAnimal
{
	
 public EntityCitipati(World par1World) 
 {
  super(par1World);
  this.texture = "/Paleocraft/Mobs/Citi/Citipati.png";	
  this.moveSpeed = 0.5F;
  
  this.setSize(1.0F, 1.0F);
  
  this.getNavigator().setAvoidsWater(true);
  
  this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityChicken.class, this.moveSpeed, false));
  this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, 16.0F, 0, true));
 }

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
    return "paleocraft.citi.living";
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
protected String getHurtSound()
{
    return "paleocraft.citi.hurt";
}

/**
 * Returns the sound this mob makes on death.
 */
protected String getDeathSound()
{
    return "paleocraft.citi.smallherbdeath";
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

/**
 * ATTACKING OTHER MOBS - OVERRIDING ENTITYANIMAL
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
    int i = this.getAttackStrength(par1Entity);

    if (this.isPotionActive(Potion.damageBoost))
    {
        i += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
    }

    if (this.isPotionActive(Potion.weakness))
    {
        i -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
    }

    int j = 0;

    if (par1Entity instanceof EntityLiving)
    {
        i += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)par1Entity);
        j += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)par1Entity);
    }

    boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);

    if (flag)
    {
        if (j > 0)
        {
            par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F));
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
        }

        int k = EnchantmentHelper.getFireAspectModifier(this);

        if (k > 0)
        {
            par1Entity.setFire(k * 4);
        }

        if (par1Entity instanceof EntityLiving)
        {
            EnchantmentThorns.func_92096_a(this, (EntityLiving)par1Entity, this.rand);
        }
    }

    return flag;
}
}