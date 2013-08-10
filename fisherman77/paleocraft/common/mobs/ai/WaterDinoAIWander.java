package fisherman77.paleocraft.common.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class WaterDinoAIWander extends EntityAIBase
{
    private EntityCreature theEntity;
    
    private double targetX;
    private double targetZ;
    private final float FLOAT_SPEED;

    public WaterDinoAIWander(EntityCreature par1EntityCreature, float var3)
    {
        this.theEntity = par1EntityCreature;
        
        this.FLOAT_SPEED = var3;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if (this.theEntity.getRNG().nextInt(30) != 0)
        {
            return false;
        }
        else
        {
            Vec3 var1 = RandomPositionGenerator.findRandomTarget(this.theEntity, 10, 7);

            if (var1 == null)
            {
                return false;
            }
            else
            {
                this.targetX = var1.xCoord;
                this.targetZ = var1.zCoord;
                return true;
            }
        }
    }
    
    /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
        public boolean continueExecuting()
        {
            return !this.theEntity.getNavigator().noPath();
        }

        /**
    * Execute a one shot task or start executing a continuous task
    */
        public void startExecuting() {}
        
}
