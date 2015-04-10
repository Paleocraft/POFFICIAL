package fisherman77.paleocraft.common.mobs.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class WaterDinoAISwimming extends EntityAIBase
{
    private EntityLiving theEntity;
    
    protected EntityLiving entity;
    protected boolean usuallySurface;
    protected final float FLOAT_SPEED;
    protected final float SINK_SPEED;
    protected final float FAST_FLOAT_SPEED;
    protected final float FAST_SINK_SPEED;
    protected final float FOLLOW_RANGE;
    protected boolean fastFlag;

    public WaterDinoAISwimming(EntityLiving par1EntityLiving, boolean var2, float var3, float var4)
    {
        this.theEntity = par1EntityLiving;
        this.setMutexBits(7);
        par1EntityLiving.getNavigator().setCanSwim(true);
        
        this.usuallySurface = true;
        this.FOLLOW_RANGE = 1.5F;
        this.usuallySurface = var2;
        this.FLOAT_SPEED = var3 > 1.0F ? 1.0F : var3;
        this.SINK_SPEED = -var4;
        this.FAST_FLOAT_SPEED = this.FLOAT_SPEED * 50.0F;
        this.FAST_SINK_SPEED = -this.FAST_FLOAT_SPEED;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.theEntity.isInWater() || this.theEntity.handleLavaMovement();
        //IDK -- maybe we'll have a lava dino someday.
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.theEntity.getNavigator().noPath())
        {
            this.theEntity.motionY = (double)this.FLOAT_SPEED;
        }
    }
}
