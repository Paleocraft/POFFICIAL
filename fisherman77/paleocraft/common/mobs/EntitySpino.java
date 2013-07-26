package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;
import net.minecraft.world.World;


public class EntitySpino extends EntityMob
{

	private double moveSpeed;
	private int maxHealth;
	private int attackStrength;
	
 public EntitySpino(World par1World) 
 {
  super(par1World);

	//STATS
	  //-------------------
	  this.moveSpeed = 0.3D;
	  this.maxHealth = 8;
	  this.attackStrength = 2;
	  //-------------------
  
  this.setSize(6F, 6F);
  
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
  this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false)); 
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
  
 }

 /**
  * Returns the sound this mob makes while it's alive.
  */
 protected String getLivingSound()
 {
     return "paleocraft:spinoliving1";
 }

 /**
  * Returns the sound this mob makes when it is hurt.
  */
 protected String getHurtSound()
 {
     return "paleocraft:spinohurt";
 }

 /**
  * Returns the sound this mob makes on death.
  */
 protected String getDeathSound()
 {
     return "paleocraft:LargeCarnDeath";
 }
 
 public int getMaxHealth() 
 {
  return 40;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

protected boolean isAIEnabled()
{
    return true;
}

protected boolean canDespawn()
{
return false;
}

protected void dropFewItems(boolean par1, int par2)
{
  this.dropItem(Item.fishRaw.itemID, 3);
}
}
