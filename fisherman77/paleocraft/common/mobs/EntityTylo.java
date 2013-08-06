package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityTylo extends EntityWaterMob
{
  
	 public float squidPitch;
	    public float prevSquidPitch;
	    public float squidYaw;
	    public float prevSquidYaw;
	    public float field_70867_h;
	    public float field_70868_i;

	    /** angle of the tentacles in radians */
	    public float tentacleAngle;

	    /** the last calculated angle of the tentacles in radians */
	    public float prevTentacleAngle;
	    private float randomMotionSpeed;
	    private float field_70864_bA;
	    private float field_70871_bB;
	    private float randomMotionVecX;
	    private float randomMotionVecY;
	    private float randomMotionVecZ;


public EntityTylo(World par1World) 
 {
  super(par1World);	
  
  this.setSize(1.0F, 1.0F);
  
  this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.6F, false));
  //this.tasks.addTask(1, new EntityAIWander(this, 0.4F));
  this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.getNavigator().setCanSwim(true);
 }

@Override
protected void func_110147_ax() {
    super.func_110147_ax();
    
    func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4); // moveSpeed
    func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(9); // maxHealth
} 
 
//ATTACKING OTHER MOBS - OVERRIDING ENTITYWATERMOB
/**
* Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
*/
protected void attackEntity(Entity par1Entity, float par2)
{
   if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
   {
       this.attackTime = 20;
       this.attackEntityAsMob(par1Entity);
   }
}

public boolean attackEntityAsMob(Entity par1Entity)
{
	int i = 2; //attackStrength
   return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
}

/**
 * Checks if the entity's current position is a valid location to spawn this entity.
 */
public boolean getCanSpawnHere()
{
    return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere();
}

/**
 * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
 * true)
 */
public boolean isInWater()
{
    return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
}
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

protected boolean isAIEnabled()
{
    return true;
}

/**
 * Returns the sound this mob makes while it's alive.
 */
protected String getLivingSound()
{
    return "paleocraft:tyloliving1";
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
protected String getHurtSound()
{
    return "paleocraft:tylohurt";
}

/**
 * Returns the sound this mob makes on death.
 */
protected String getDeathSound()
{
    return "paleocraft:largecarndeath";
}

protected boolean canDespawn()
{
return false;
}}
