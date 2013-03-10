package fisherman77.paleocraft.common.mobs;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockCloth;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityDromaeosaurus extends EntityTameable
{
	private float field_70926_e;
    private float field_70924_f;
    
	static Random randGen = new Random();
	int skintexture = randGen.nextInt(4) + 1;
	
 public EntityDromaeosaurus(World par1World) 
 {
  super(par1World);
  this.texture = "/Paleocraft/Mobs/Dromie/Dromaeosaurus.png";
  this.moveSpeed = 0.5F;
  
  this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, 5.0F, 0, true));
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
 * --------------
 * Baby Dromaeosauruss
 * --------------
 */
public EntityDromaeosaurus spawnBabyAnimal(EntityAgeable par1EntityAgeable)
{
    return new EntityDromaeosaurus(this.worldObj);
}

/*
 * ============
 * Tamability (imported from EntityWolf)
 * ============
 */

/**
 * Sets the active target the Task system uses for tracking
 */
public void setAttackTarget(EntityLiving par1EntityLiving)
{
    super.setAttackTarget(par1EntityLiving);

    if (par1EntityLiving instanceof EntityPlayer)
    {
        this.setAngry(true);
    }
}

/**
 * main AI tick function, replaces updateEntityActionState
 */
protected void updateAITick()
{
    this.dataWatcher.updateObject(18, Integer.valueOf(this.getHealth()));
}

protected void entityInit()
{
    super.entityInit();
    this.dataWatcher.addObject(18, new Integer(this.getHealth()));
    this.dataWatcher.addObject(19, new Byte((byte)0));
    this.dataWatcher.addObject(20, new Byte((byte)BlockCloth.getBlockFromDye(1)));
}

@SideOnly(Side.CLIENT)

/**
 * Returns the texture's file path as a String.
 
public String getTexture()
{
    return this.isTamed() ? "/mob/Dromaeosaurus_tame.png" : (this.isAngry() ? "/mob/Dromaeosaurus_angry.png" : super.getTexture());
}*/

/**
 * (abstract) Protected helper method to write subclass entity data to NBT.
 */
public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
{
    super.writeEntityToNBT(par1NBTTagCompound);
    par1NBTTagCompound.setBoolean("Angry", this.isAngry());
}

/**
 * (abstract) Protected helper method to read subclass entity data from NBT.
 */
public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
{
    super.readEntityFromNBT(par1NBTTagCompound);
    this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
}

/**
 * Determines if an entity can be despawned, used on idle far away entities
 */
protected boolean canDespawn()
{
    return false;
}

/**
 * Returns the sound this mob makes while it's alive.
 */
protected String getLivingSound()
{
    return "paleocraft.dromie.living";
}

/**
 * Returns the sound this mob makes when it is hurt.
 */
protected String getHurtSound()
{
    return "paleocraft.dromie.hurt";
}

/**
 * Returns the sound this mob makes on death.
 */
protected String getDeathSound()
{
    return "paleocraft.dromie.smallcarndeath";
}

/**
 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
 * use this to react to sunlight and start to burn.
 */
public void onLivingUpdate()
{
    super.onLivingUpdate();
}

/**
 * Called to update the entity's position/logic.
 */
public void onUpdate()
{
    super.onUpdate();
    this.field_70924_f = this.field_70926_e;

    if (this.func_70922_bv())
    {
        this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
    }
    else
    {
        this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
    }

    if (this.func_70922_bv())
    {
        this.numTicksToChaseTarget = 10;
    }

}

/**
 * Called when the entity is attacked.
 */
public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
{
    if (this.isEntityInvulnerable())
    {
        return false;
    }
    else
    {
        Entity var3 = par1DamageSource.getEntity();

        if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow))
        {
            par2 = (par2 + 1) / 2;
        }

        return super.attackEntityFrom(par1DamageSource, par2);
    }
}

public boolean attackEntityAsMob(Entity par1Entity)
{
    int var2 = this.isTamed() ? 4 : 2;
    return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
}

/**
 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
 */
public boolean interact(EntityPlayer par1EntityPlayer)
{
    ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

    if (this.isTamed())
    {
        if (var2 != null)
        {
            if (Item.itemsList[var2.itemID] instanceof ItemFood)
            {
                ItemFood var3 = (ItemFood)Item.itemsList[var2.itemID];

                if (var3.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectInt(18) < 20)
                {
                    if (!par1EntityPlayer.capabilities.isCreativeMode)
                    {
                        --var2.stackSize;
                    }

                    this.heal(var3.getHealAmount());

                    if (var2.stackSize <= 0)
                    {
                        par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
            }
            /*
             * else if (var2.itemID == Item.dyePowder.shiftedIndex)
             
            {
                int var4 = BlockCloth.getBlockFromDye(var2.getItemDamage());

                if (var4 != this.getCollarColor())
                {
                    this.setCollarColor(var4);

                    if (!par1EntityPlayer.capabilities.isCreativeMode && --var2.stackSize <= 0)
                    {
                        par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
            }*/
        }

        if (par1EntityPlayer.username.equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote && !this.isBreedingItem(var2))
        {
            this.isJumping = false;
            this.setPathToEntity((PathEntity)null);
        }
    }
    else if (var2 != null && var2.itemID == Item.beefRaw.itemID && !this.isAngry())
    {
        if (!par1EntityPlayer.capabilities.isCreativeMode)
        {
            --var2.stackSize;
        }

        if (var2.stackSize <= 0)
        {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
        }

        if (!this.worldObj.isRemote)
        {
            if (this.rand.nextInt(3) == 0)
            {
                this.setTamed(true);
                this.setPathToEntity((PathEntity)null);
                this.setAttackTarget((EntityLiving)null);
                this.setEntityHealth(20);
                this.setOwner(par1EntityPlayer.username);
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte)7);
            }
            else
            {
                this.playTameEffect(false);
                this.worldObj.setEntityState(this, (byte)6);
            }
        }

        return true;
    }

    return super.interact(par1EntityPlayer);
}

/**
 * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
 * the animal type)
 */
public boolean isBreedingItem(ItemStack par1ItemStack)
{
    return par1ItemStack == null ? false : (!(Item.itemsList[par1ItemStack.itemID] instanceof ItemFood) ? false : ((ItemFood)Item.itemsList[par1ItemStack.itemID]).isWolfsFavoriteMeat());
}

/**
 * Will return how many at most can spawn in a chunk at once.
 */
public int getMaxSpawnedInChunk()
{
    return 8;
}

/**
 * Determines whether this Dromaeosaurus is angry or not.
 */
public boolean isAngry()
{
    return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
}

/**
 * Sets whether this Dromaeosaurus is angry or not.
 */
public void setAngry(boolean par1)
{
    byte var2 = this.dataWatcher.getWatchableObjectByte(16);

    if (par1)
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 2)));
    }
    else
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -3)));
    }
}

/**
 * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
 

public void func_70918_i(boolean par1)
{
    byte var2 = this.dataWatcher.getWatchableObjectByte(19);

    if (par1)
    {
        this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
    }
    else
    {
        this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
    }
}*/


public boolean func_70922_bv()
{
    return this.dataWatcher.getWatchableObjectByte(19) == 1;
}




@Override
public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
	return this.spawnBabyAnimal(par1EntityAgeable);
	}
}