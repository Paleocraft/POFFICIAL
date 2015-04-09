package fisherman77.paleocraft.common.mobs.ai;


import java.util.Random;
import net.minecraft.entity.*;
import fisherman77.paleocraft.common.mobs.EntityDimorphodon;
import fisherman77.paleocraft.common.mobs.EntityDimorphodonL;
import fisherman77.paleocraft.common.mobs.EntityMasso;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;

public class FlyingMobAI extends EntityAIBase {

	Random rand = this.rand;
	 public int courseChangeCooldown = this.entity.courseChangeCooldown;
	private World world;
	private boolean entityflying = false;
private EntityDimorphodon entity;
float renderYawOffset;
private float rotationYaw;
float rotationPitch;
double posX = this.entity.posX;
double posY = this.entity.posY;
double posZ = this.entity.posZ;
double waypointX = this.entity.waypointX;
double waypointY = this.entity.waypointY;
double waypointZ = this.entity.waypointZ;
double motionX = this.entity.motionX;
double motionY = this.entity.motionY;
double motionZ = this.entity.motionZ;
private Object boundingBox;
public FlyingMobAI(EntityDimorphodon entity) {
this.entity = entity;
this.setMutexBits(1);
world = entity.worldObj;


}
      
 
    /**
     * Returns whether the EntityAIBase should begin execution.
     */
public boolean shouldExecute()
{
    if (this.entity.getAge() >= 100)
    {
        return false;
    }
    else if (this.entity.getRNG().nextInt(120) != 0)
    {
        return false;
    }
    else
    {

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
	return entityflying;
    }

private boolean isCourseTraversable(double par1, double par3, double par5, double par7)
{
    double d4 = (this.waypointX - this.posX) / par7;
    double d5 = (this.waypointY - this.posY) / par7;
    double d6 = (this.waypointZ - this.posZ) / par7;
    AxisAlignedBB axisalignedbb = ((AxisAlignedBB) this.boundingBox).copy();

    for (int i = 1; (double)i < par7; ++i)
    {
        axisalignedbb.offset(d4, d5, d6);

       
    }

    return true;
}

/**
 * Returns whether an in-progress EntityAIBase should continue executing
 */
public boolean continueExecuting()
{
    return !this.entity.getNavigator().noPath();
}

/**
 * Execute a one shot task or start executing a continuous task
 */
public void startExecuting()
{
    this.entity.getNavigator().tryMoveToXYZ(this.posX, this.posY, this.posZ, motionX);
}
}
    /**
     * Execute a one shot task or start executing a continuous task
     */
