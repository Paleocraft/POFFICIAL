package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityTroodon extends EntityAnimal
{
	
 public EntityTroodon(World par1World) 
 {
  super(par1World);
  
  this.setSize(1.0F, 1.0F);
  
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAIFleeSun(this, 1.0));
  this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
  this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityChicken.class, 1.0, false));
  this.tasks.addTask(4, new EntityAIWander(this, 0.4));
  this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
  this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityChicken.class, 0, true));
 }
 
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.4); // moveSpeed
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(8); // maxHealth
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
    return "paleocraft:trooliving";
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
protected String getHurtSound()
{
    return "paleocraft:troohurt";
}

/**
 * Returns the sound this mob makes on death.
 */
protected String getDeathSound()
{
    return "paleocraft:smallcarndeath";
}


@Override
public EntityAgeable createChild(EntityAgeable var1) {
	// TODO Auto-generated method stub
	return null;
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
	int i = 2; //attackStrength
    return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
}

protected void dropFewItems(boolean par1, int par2)
{
  this.dropItem(Item.feather.itemID, 2);
}

}
