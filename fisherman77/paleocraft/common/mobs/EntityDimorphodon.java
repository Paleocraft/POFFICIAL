package fisherman77.paleocraft.common.mobs;

import java.util.logging.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.handlers.GameLogger;

import fisherman77.paleocraft.common.mobs.ai.FlyingMobAI;
import fisherman77.paleocraft.common.mobs.ai.PaleocraftFlyingLandAI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityDimorphodon extends EntityFlying
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
   
    private int sheepTimer;
    public EntityDimorphodon(World par1World)
    {
        super(par1World);
       this.tasks.addTask(3, new PaleocraftFlyingLandAI (this));
        this.setSize(0.4F, 0.4F);
        this.setIsBatHanging(true);
        this.getNavigator().setAvoidsWater(true);
   //     this.tasks.addTask(0, new FlyingMobAI(this));
    }
    
   

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4); // moveSpeed
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2); // maxHealth
	}
    
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
     * Called when the entity is attacked.
     */
    @SideOnly(Side.CLIENT)
    public boolean func_110182_bF()
    {
        return this.dataWatcher.getWatchableObjectByte(16) != 0;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }
   

   
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

    protected boolean isAIEnabled()
	{
	    return true;
	}
	
	protected boolean canDespawn()
	{
	return false;
	}
	
	public void updateAITasks()
    {
super.updateAITasks();
      
int blockX = (int) (posX - 0.5);
int blockZ = (int) (posZ - 0.5);
//return posY - worldObj.getHeightValue(blockX, blockZ);

double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;

        if (d3 < 1.0D || d3 > 3600.0D)
        {
            this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.courseChangeCooldown-- <= 0)
        {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d3 = (double)MathHelper.sqrt_double(d3);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3))
            {
                this.motionX += d0 / d3 * 0.1D;
                this.motionY += d1 / d3 * 0.1D;
                this.motionZ += d2 / d3 * 0.1D;
            }
            else
            {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }

        double d4 = 64.0D;
    }

    /**
     * True if the ghast has an unobstructed line of travel to the waypoint.
     */
    private boolean isCourseTraversable(double par1, double par3, double par5, double par7)
    {
        double d4 = (this.waypointX - this.posX) / par7;
        double d5 = (this.waypointY - this.posY) / par7;
        double d6 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();

        for (int i = 1; (double)i < par7; ++i)
        {
            axisalignedbb.offset(d4, d5, d6);

            if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty())
            {
                return false;
            }
        }

        return true;
    }
  
    public double getAltitude() {
        int blockX = (int) (posX - 0.5);
        int blockZ = (int) (posZ - 0.5);
        return posY - worldObj.getHeightValue(blockX, blockZ);
    }


}
