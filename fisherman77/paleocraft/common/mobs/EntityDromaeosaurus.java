package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockCloth;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityDromaeosaurus extends EntityAnimal
{
	
 public EntityDromaeosaurus(World par1World) 
 {
  super(par1World);
  this.texture = "/Paleocraft/Mobs/Dromie/Dromaeosaurus.png";
  this.moveSpeed = 0.5F;
  
  this.setSize(1.0F, 1.0F);
  
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityChicken.class, this.moveSpeed, false));
  this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
  this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityChicken.class, 16.0F, 0, true));
  
 }
 
 protected boolean isAIEnabled()
 {
     return true;
 }

 /**
  * Setting Damage
  */
 public int func_82193_c(Entity par1Entity) {
	 return 2;
	 }
 
 /**
  * Max Health
  */
 public int getMaxHealth() 
 {
  return 8;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }


protected void func_82164_bB()
{
    this.setCurrentItemOrArmor(0, new ItemStack(Item.swordStone));
}

/**
 * ATTACKING OTHER MOBS - OVERRIDING ENTITYANIMAL
 */
protected void attackEntity(Entity par1Entity, float par2)
{
    if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
    {
        this.attackTime = 20;
        this.attackEntityAsMob(par1Entity);
    }
}

public int getAttackStrength(Entity par1Entity)
{
	 return 3;
}

public boolean attackEntityAsMob(Entity par1Entity)
{
    int i = this.getAttackStrength(par1Entity);

    if (this.isPotionActive(Potion.damageBoost))
    {
        i += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
    }

    if (this.isPotionActive(Potion.weakness))
    {
        i -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
    }

    int j = 0;

    if (par1Entity instanceof EntityLiving)
    {
        i += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)par1Entity);
        j += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)par1Entity);
    }

    boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);

    if (flag)
    {
        if (j > 0)
        {
            par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F));
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
        }

        int k = EnchantmentHelper.getFireAspectModifier(this);

        if (k > 0)
        {
            par1Entity.setFire(k * 4);
        }

        if (par1Entity instanceof EntityLiving)
        {
            EnchantmentThorns.func_92096_a(this, (EntityLiving)par1Entity, this.rand);
        }
    }

    return flag;
}

@Override
public EntityAgeable createChild(EntityAgeable entityageable) {
	// TODO Auto-generated method stub
	return null;
}
}