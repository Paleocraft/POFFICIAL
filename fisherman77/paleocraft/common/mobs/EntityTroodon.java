package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.world.World;


public class EntityTroodon extends EntityAnimal
{
	
 public EntityTroodon(World par1World) 
 {
  super(par1World);
  this.texture = "/Paleocraft/Mobs/Troo/Troodon.png";	
  this.moveSpeed = 0.5F;
  
  this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, 5.0F, 0, true));
  this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));

 }
 
 /**
  * Setting Damage
  */
 public int func_82193_c(Entity par1Entity) {
	 return 1;
	 }
 
 public int getMaxHealth() 
 {
  return 8;
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
    return "paleocraft.troo.living";
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
protected String getHurtSound()
{
    return "paleocraft.troo.hurt";
}

/**
 * Returns the sound this mob makes on death.
 */
protected String getDeathSound()
{
    return "paleocraft.troo.smallcarndeath";
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


}