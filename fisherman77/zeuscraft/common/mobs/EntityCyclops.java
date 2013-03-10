package fisherman77.zeuscraft.common.mobs;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.world.World;


public class EntityCyclops extends EntityMob
{
 public EntityCyclops(World par1World) 
 {
  super(par1World);
  this.texture = "/Zeuscraft/Mobs/Cyclops/Cyclops.png";
  this.moveSpeed = 0.25F;
  this.yOffset *= 5.0F;
  this.setSize(this.width * 5.0F, this.height * 5.0F);
 }


public int getAttackStrength(Entity par1Entity)
    {
     return 10;
    }

 
 public int getMaxHealth() 
 {
  return 20;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
}