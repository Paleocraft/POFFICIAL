package fisherman77.paleocraft.common.mobs;

import java.util.Random;

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


public class EntityCitipati extends EntityAnimal
{
	
 public EntityCitipati(World par1World) 
 {
  super(par1World);
  this.texture = "/Paleocraft/Mobs/Citi/Citipati.png";	
  this.moveSpeed = 0.5F;
  
  this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, 5.0F, 0, true));
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
public EntityAgeable createChild(EntityAgeable var1) {
	// TODO Auto-generated method stub
	return null;
}


}