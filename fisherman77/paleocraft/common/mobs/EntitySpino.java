package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;


public class EntitySpino extends EntityMob
{

public EntitySpino(World par1World) 
 {
  super(par1World);
  
  this.setSize(this.width * 3.0F, this.height * 3.0F);
  
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.6D, false));
  this.tasks.addTask(3, new EntityAIWander(this, 0.4));
  this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true)); 
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
  }

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.4); // moveSpeed
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(75); // maxHealth
	    getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(20); //attackStrength
	}
 
	 /**
	  * Returns the sound this mob makes while it's alive.
	  */
	 protected String getLivingSound()
	 {
	     return "paleocraft:spinoliving";
	 }
	
	 /**
	  * Returns the sound this mob makes when it is hurt.
	  */
	 protected String getHurtSound()
	 {
	     return "paleocraft:spinomad";
	 }
	
	 /**
	  * Returns the sound this mob makes on death.
	  */
	 protected String getDeathSound()
	 {
	     return "paleocraft:spinohurt";
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