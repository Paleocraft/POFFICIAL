package fisherman77.paleocraft.common.mobs;

import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.Timer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.handlers.GameLogger;
import fisherman77.paleocraft.common.mobs.ai.DinoAIEatLeaves;
import fisherman77.paleocraft.common.mobs.ai.EntityLandingMob;
import fisherman77.paleocraft.common.mobs.ai.EntityPaleocraftMob;
import fisherman77.paleocraft.common.mobs.ai.PaleocraftFlyingLandAI;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;


public class EntityMasso extends EntityPaleocraftMob
{
	
	 private int randomTickDivider;
	 Toolkit toolkit;
	//  TimerTask tasknew = new TimerScheduleFixedRateDelay();
	 public double waypointX;
	 Timer timer = new Timer();
	/* private DinoAIEatLeaves aiEatLeaves = new DinoAIEatLeaves(this);*/
	 private int sheepTimer;
	 public EntityMasso(World par1World) 
	
	 {
  super(par1World);
  
  this.setSize(1.0F, 1.0F);
 //this.tasks.addTask(3, new PaleocraftFlyingLandAI (this));
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
  this.tasks.addTask(4, new EntityAIWander(this, 0.4));
  this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  //this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
  this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
  //this.tasks.addTask(5, this.aiEatLeaves);
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityBaryonyx.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntitySpino.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityDromaeosaurus.class, 8.0F, 0.6D, 0.6D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMegalodon.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityTylo.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityQuetzalcoatlus.class, 8.0F, 0.8D, 0.8D));
  this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityCryo.class, 8.0F, 0.8D, 0.8D));
 }
 
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4); // moveSpeed
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5); // maxHealth
	}
 
 /**
  * (abstract) Protected helper method to write subclass entity data to NBT.
  */
 
 /**
  * (abstract) Protected helper method to read subclass entity data from NBT.
  */
 
 
 protected boolean isAIEnabled()
 {
     return true;
 }
 
 /**
  * Returns the sound this mob makes while it's alive.
  */
 @Override
	protected String getLivingSound()
{
	playSound("Paleocraft:mob.masso.Masso", getSoundVolume(), getSoundPitch());
	return null;
}

 /**
  * Returns the sound this mob makes when it is hurt.
  */
 @Override
	protected String getHurtSound()
{
	playSound("Paleocraft:mob.masso.MassoHurt", getSoundVolume(), getSoundPitch());
	return null;
}

 /**
  * Returns the sound this mob makes on death.
  */
 @Override
	protected String getDeathSound()
{
	playSound("Paleocraft:mob.other.MedHerbDeath", getSoundVolume(), getSoundPitch());
	return null;
}



/*protected void func_82164_bB()
{
    this.setCurrentItemOrArmor(0, new ItemStack(Item.swordStone));
}*/

//ATTACKING OTHER MOBS - OVERRIDING ENTITYANIMAL
/**
 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
 */




/**
 * Sets the active target the Task system uses for tracking
 */


/**
 * Determines whether this wolf is angry or not.
 */

/**
 * Sets whether this wolf is angry or not.
 */

/*public void onLivingUpdate()
{
    if (this.worldObj.isRemote)
    {
        this.sheepTimer = Math.max(0, this.sheepTimer - 1);
    }

    super.onLivingUpdate();
}*/

//protected void updateAITick()

  
	/*public void updateAITick()
	  {
	super.updateAITick();
	if (this.worldObj.isRemote)
	System.out.println("code for EntityMasso updateAITick is running.");
	{
		
		 this.sheepTimer = Math.max(0, this.sheepTimer - 1);
		setDead();
		  
        EntityDimorphodonL entitydimorphodonl = new EntityDimorphodonL(worldObj);
        entitydimorphodonl.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        entitydimorphodonl.setHealth(this.getHealth());
        entitydimorphodonl.renderYawOffset = renderYawOffset;
        worldObj.spawnEntityInWorld(entitydimorphodonl);
     //   this.playSound("mob.other.takeoff", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
        GameLogger.writeToFile(Level.INFO, "Loading Dimorph Land Model.");
       
        System.out.println("code activated for entitymasso (line 89)");
      //  this.posY = (double)MathHelper.floor_double(this.posY) + 1.0D - (double)this.height;
    }
	  //super.onLivingUpdate();
	super.updateAITick();
	  
	  } */

/*@Override
public EntityAgeable createChild(EntityAgeable p_90011_1_) {
	// TODO Auto-generated method stub
	return null;
}
*/
 protected void dropFewItems(boolean par1, int par2)
	{
	  this.dropItem(Items.leather, 1);
	}

}


