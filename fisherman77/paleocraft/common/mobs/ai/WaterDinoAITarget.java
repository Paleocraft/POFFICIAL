package fisherman77.paleocraft.common.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
//import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
//import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import org.apache.commons.lang3.StringUtils;

public abstract class WaterDinoAITarget extends EntityAIBase
{
    /** The entity that this task belongs to */
    protected EntityCreature taskOwner;

    /**
     * If true, EntityAI targets must be able to be seen (cannot be blocked by walls) to be suitable targets.
     */
    protected boolean shouldCheckSight;
    private boolean field_75303_a;
    private int field_75301_b;
    private int field_75302_c;
    private int field_75298_g;

    public WaterDinoAITarget(EntityCreature par1EntityCreature, boolean par2)
    {
        this(par1EntityCreature, par2, false);
    }

    public WaterDinoAITarget(EntityCreature par1EntityCreature, boolean par2, boolean par3)
    {
        this.taskOwner = par1EntityCreature;
        this.shouldCheckSight = par2;
        this.field_75303_a = par3;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        EntityLivingBase entitylivingbase = this.taskOwner.getAttackTarget();

        if (entitylivingbase == null)
        {
            return false;
        }
        else if (!entitylivingbase.isEntityAlive())
        {
            return false;
        }
        else
        {
            double d0 = this.func_111175_f();

            if (this.taskOwner.getDistanceSqToEntity(entitylivingbase) > d0 * d0)
            {
                return false;
            }
            else if (entitylivingbase.isInWater() == false)
            {
                return false;
            }
            else
            {
                if (this.shouldCheckSight)
                {
                    if (this.taskOwner.getEntitySenses().canSee(entitylivingbase))
                    {
                        this.field_75298_g = 0;
                    }
                    else if (++this.field_75298_g > 60)
                    {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    protected double func_111175_f()
    {
        IAttributeInstance attributeinstance = this.taskOwner.getEntityAttribute(SharedMonsterAttributes.followRange);
        return attributeinstance == null ? 16.0D : attributeinstance.getAttributeValue();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.field_75301_b = 0;
        this.field_75302_c = 0;
        this.field_75298_g = 0;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.taskOwner.setAttackTarget((EntityLivingBase)null);
    }

    /**
     * A method used to see if an entity is a suitable target through a number of checks.
     */
    protected boolean isSuitableTarget(EntityLivingBase par1EntityLivingBase, boolean par2)
    {
        if (par1EntityLivingBase == null)
        {
            return false;
        }
        if (par1EntityLivingBase.isInWater() == false)
        {
            return false;
        }
        else if (par1EntityLivingBase == this.taskOwner)
        {
            return false;
        }
        else if (!par1EntityLivingBase.isEntityAlive())
        {
            return false;
        }
        else if (!this.taskOwner.canAttackClass(par1EntityLivingBase.getClass()))
        {
            return false;
        }
        else
        {
            if (this.taskOwner instanceof IEntityOwnable && StringUtils.isNotEmpty(((IEntityOwnable)this.taskOwner).func_152113_b()))
            {
                if (par1EntityLivingBase instanceof IEntityOwnable && ((IEntityOwnable)this.taskOwner).func_152113_b().equals(((IEntityOwnable)par1EntityLivingBase).func_152113_b()))
                {
                    return false;
                }

                if (par1EntityLivingBase == ((IEntityOwnable)this.taskOwner).getOwner())
                {
                    return false;
                }
            }
            else if (par1EntityLivingBase instanceof EntityPlayer && !par2 && ((EntityPlayer)par1EntityLivingBase).capabilities.disableDamage)
            {
                return false;
            }

            if (!this.taskOwner.isWithinHomeDistance(MathHelper.floor_double(par1EntityLivingBase.posX), MathHelper.floor_double(par1EntityLivingBase.posY), MathHelper.floor_double(par1EntityLivingBase.posZ)))
            {
                return false;
            }
            else if (this.shouldCheckSight && !this.taskOwner.getEntitySenses().canSee(par1EntityLivingBase))
            {
                return false;
            }
            else
            {
                if (this.field_75303_a)
                {
                    if (--this.field_75302_c <= 0)
                    {
                        this.field_75301_b = 0;
                    }

                    if (this.field_75301_b == 0)
                    {
                        this.field_75301_b = this.func_75295_a(par1EntityLivingBase) ? 1 : 2;
                    }

                    if (this.field_75301_b == 2)
                    {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    private boolean func_75295_a(EntityLivingBase par1EntityLivingBase)
    {
        this.field_75302_c = 10 + this.taskOwner.getRNG().nextInt(5);
        PathEntity pathentity = this.taskOwner.getNavigator().getPathToEntityLiving(par1EntityLivingBase);

        if (pathentity == null)
        {
            return false;
        }
        else
        {
            PathPoint pathpoint = pathentity.getFinalPathPoint();

            if (pathpoint == null)
            {
                return false;
            }
            else
            {
                int i = pathpoint.xCoord - MathHelper.floor_double(par1EntityLivingBase.posX);
                int j = pathpoint.zCoord - MathHelper.floor_double(par1EntityLivingBase.posZ);
                return (double)(i * i + j * j) <= 2.25D;
            }
        }
    }
}
