//derived from Wuppy's Koi mod

package fisherman77.paleocraft.common.mobs.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class WaterDinoAIFishSwimming extends EntityAIBase
{
    private EntityLiving entity;

    public WaterDinoAIFishSwimming(EntityLiving par1EntityLiving)
    {
        entity = par1EntityLiving;
        setMutexBits(4);
        par1EntityLiving.getNavigator().setCanSwim(true);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return entity.isInWater() || entity.handleLavaMovement();
    }
    
    public void updateTask()
    {
        if (entity.getRNG().nextFloat() < 0.5F)
        {
            entity.getJumpHelper().setJumping();
        }
    }
}