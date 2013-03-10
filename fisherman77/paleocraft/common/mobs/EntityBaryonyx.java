package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;
import net.minecraft.world.World;


public class EntityBaryonyx extends EntityMob
{
	
 public EntityBaryonyx(World par1World) 
 {
  super(par1World);
  this.texture = "/Paleocraft/Mobs/Bary/Bary.png";	
  this.moveSpeed = 0.5F;
  
  this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 5.0F, 0, true));
 }

 /**
  * Returns the sound this mob makes while it's alive.
  */
 protected String getLivingSound()
 {
     return "paleocraft.bary.living";
 }

 /**
  * Returns the sound this mob makes when it is hurt.
  */
 protected String getHurtSound()
 {
     return "paleocraft.bary.hurt";
 }

 /**
  * Returns the sound this mob makes on death.
  */
 protected String getDeathSound()
 {
     return "paleocraft.bary.hurt";
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