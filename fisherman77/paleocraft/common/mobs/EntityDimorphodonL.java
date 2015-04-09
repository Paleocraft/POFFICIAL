package fisherman77.paleocraft.common.mobs;



import java.io.Console;
import java.util.Random;
import java.util.logging.Level;

import cpw.mods.fml.common.registry.EntityRegistry;
import fisherman77.paleocraft.common.handlers.GameLogger;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityDimorphodonL extends EntityAmbientCreature
{
	  private ChunkCoordinates spawnPosition;
public EntityDimorphodonL(World par1World) 
 {
  super(par1World);
  this.setSize(0.4F, 0.4F);
 
 
  this.setIsBatHanging(true);
  //this.setIsBatHanging(true);
  
  // this.setSize(this.width * 2.5F, this.height * 2.5F);
  
 
  this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
 
 }

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	  //  getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2);
	   // getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7);
	}
	 protected void entityInit()
	    {
	        super.entityInit();
	        this.dataWatcher.addObject(16, new Byte((byte)0));
	    }
	 /**
	  * Returns the sound this mob makes while it's alive.
	  */
	@Override
   	protected String getLivingSound()
   {
   	playSound("Paleocraft:mob.dimorph.dimorphliving", getSoundVolume(), getSoundPitch());
   	return null;
   }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
   	protected String getHurtSound()
   {
   	playSound("Paleocraft:mob.dimorph.dimorphhurt", getSoundVolume(), getSoundPitch());
   	return null;
   }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
   	protected String getDeathSound()
   {
   	playSound("Paleocraft:mob.other.smallcarndeath", getSoundVolume(), getSoundPitch());
   	return null;
   }
	
	
	
	
	protected boolean canDespawn()
	{
	return false;
	}
	
	  public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	    {
	        if (this.isEntityInvulnerable())
	        {
	            return false;
	        }
	        else
	        {
	            if (!this.worldObj.isRemote && this.getIsBatHanging())
	            {
	                this.setIsBatHanging(false);
	            }

	            return super.attackEntityFrom(p_70097_1_, p_70097_2_);
	        }
	    }
	  public boolean canBePushed()
	    {
	        return false;
	    }

	    protected void collideWithEntity(Entity p_82167_1_) {}

	    protected void collideWithNearbyEntities() {}

	  
	    public boolean getIsBatHanging()
	    {
	        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	    }

	    public void setIsBatHanging(boolean p_82236_1_)
	    {
	        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

	        if (p_82236_1_)
	        {
	            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
	        }
	        else
	        {
	            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
	        }
	    }

	    /**
	     * Returns true if the newer Entity AI code should be run
	     */
	    protected boolean isAIEnabled()
	    {
	        return true;
	    }

	    /**
	     * Called to update the entity's position/logic.
	     */
	   /* public void onUpdate()
	    {
	        super.onUpdate();

	        if (this.getIsBatHanging())
	        {
	            this.motionX = this.motionY = this.motionZ = 0.0D;
	            this.posY = (double)MathHelper.floor_double(this.posY) + 1.0D - (double)this.height;
	        }
	        else
	        {
	            this.motionY *= 0.6000000238418579D;
	        }
	    }*/
	    protected void updateAITasks()
	    {
	        super.updateAITasks();
	        
	    

	                if (this.worldObj.getClosestPlayerToEntity(this, 4.0D) != null)
	                {
	                	 setDead();
		    	            EntityDimorphodon entitydimorphodon = new EntityDimorphodon(worldObj);
		    	            entitydimorphodon.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
		    	            entitydimorphodon.setHealth(this.getHealth());
		    	            entitydimorphodon.renderYawOffset = renderYawOffset;
		    	            worldObj.spawnEntityInWorld(entitydimorphodon);
		    	            this.playSound("Paleocraft:mob.other.takeoff", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
		    	            GameLogger.writeToFile(Level.INFO, "Loading Dimorph Land Model.");
	                	
	                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	                   
	                }
	            }
	        
	    

	    /**
	     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	     * prevent them from trampling crops
	     */
	    protected boolean canTriggerWalking()
	    {
	        return false;
	    }

	    /**
	     * Called when the mob is falling. Calculates and applies fall damage.
	     */
	    protected void fall(float p_70069_1_) {}

	    /**
	     * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
	     * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
	     */
	    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {}

	    /**
	     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
	     */
	    public boolean doesEntityNotTriggerPressurePlate()
	    {
	        return true;
	    }
	    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
	    {
	        super.readEntityFromNBT(p_70037_1_);
	        this.dataWatcher.updateObject(16, Byte.valueOf(p_70037_1_.getByte("BatFlags")));
	    }

	    /**
	     * (abstract) Protected helper method to write subclass entity data to NBT.
	     */
	    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
	    {
	        super.writeEntityToNBT(p_70014_1_);
	        p_70014_1_.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
	    }
	    


	   


}
