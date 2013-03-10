package fisherman77.zeuscraft.common.mobs;

import java.util.Random;

import fisherman77.zeuscraft.common.Zeuscraft;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;


public class EntityWiseCentaur extends EntityCentaur
{
	boolean hasRetrievedMeat = false;
	
 public EntityWiseCentaur(World par1World) 
 {
  super(par1World);
  this.texture = "/Paleocraft/Mobs/CentaurWise/centaurwhite.png";	
  this.moveSpeed = 0.3F;
  
  this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
 }

 
 public int getMaxHealth() 
 {
  return 12;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

protected boolean isAIEnabled()
{
    return true;
}

/*
 * Returns the sound this mob makes while it's alive.
 *
protected String getLivingSound()
{
    return "paleocraft.citi.living";
}

/**
 * Returns the sound this mob makes when it is hurt.
 *
protected String getHurtSound()
{
    return "paleocraft.citi.hurt";
}

/**
 * Returns the sound this mob makes on death.
 *
protected String getDeathSound()
{
    return "paleocraft.citi.smallherbdeath";
}


@Override
public EntityAgeable createChild(EntityAgeable var1) {
	// TODO Auto-generated method stub
	return null;
}

/**
 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
 */
public boolean interact(EntityPlayer par1EntityPlayer)
	{
    ItemStack heldItem = par1EntityPlayer.inventory.getCurrentItem();
    
    	if(hasRetrievedMeat == false && !(heldItem.itemID == Zeuscraft.ThunderPearl.itemID))
    	{
    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("[Wise Centaur] I see much potential in you. Bring me the head of the minotaur to prove your worthiness.");
    	}
    	else if(hasRetrievedMeat == false && heldItem.itemID == Zeuscraft.ThunderPearl.itemID)
		{
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("[Wise Centaur] You do have much potential! Please, take this as a gift, and use it to fight for the good.");
		}
		else if(hasRetrievedMeat == true)
		{
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("[Wise Centaur] Keep fighting for good.");
		}
		
		
		return true;
	}
}