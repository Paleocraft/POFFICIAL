package fisherman77.paleocraft.common.mobs.ai;

/* this is Paleocraft's own Swimming AI. This code was made by Bladeking68. If this code is found stolen the mod with it will
 * be reported. DO NOT STEAL THIS CODE! ASK BLADEKING68 OR THE OWNER OF PALEOCRAFT (DAN_WALLACE) TO USE IT.
 */



/*
 * @Author Bladeking68
 */



import java.util.Random;
import net.minecraft.entity.*;
import fisherman77.paleocraft.common.mobs.EntityDimorphodon;
import fisherman77.paleocraft.common.mobs.EntityDimorphodonL;
import fisherman77.paleocraft.common.mobs.EntityMasso;
import fisherman77.paleocraft.common.mobs.EntitySpino;
import fisherman77.paleocraft.common.mobs.EntitySpinoSwimming;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;

public class EntityAISpinoSwimLand extends EntityAIBase {
	private World world;
	private boolean entityswimland = false;
private EntitySpinoSwimming entity;
float renderYawOffset;
private float rotationYaw;
float rotationPitch;

public EntityAISpinoSwimLand(EntitySpinoSwimming entity) {
this.entity = entity;
this.setMutexBits(1);
world = entity.worldObj;
}
      
 
    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	
    	
    //	int  number = (int) ((Math.random()*100));
    	
    	if (this.entity.onGround)
    	
    		//if (this.entity.worldObj.rand.nextInt(8192) == 0) 
    	{
        	entity.setDead();
        	 EntitySpino entityspino = new EntitySpino(world);
        
        	 double posX = this.entity.posX;
        	 double posY = this.entity.posY;
        	 double posZ = this.entity.posZ;
        
        
			entityspino.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
           
			entityspino.renderYawOffset = renderYawOffset;
          world.spawnEntityInWorld(entityspino);
            }
		return entityswimland = true;
    }


private float getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
public boolean continueExecuting()
{
	
	
	if (this.entity.isInWater())
   {
   }
   return entityswimland = false;
   }
}
