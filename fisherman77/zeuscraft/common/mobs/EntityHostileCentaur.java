package fisherman77.zeuscraft.common.mobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntityHostileCentaur extends EntityMob implements IRangedAttackMob
{
    private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this, 0.25F, 60, 10.0F);
    private EntityAIAttackOnCollide field_85038_e = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);

    public EntityHostileCentaur(World par1World)
    {
        super(par1World);
        this.texture = "/Zeuscraft/Mobs/HostileCentaur/centaurblackbad.png";
        this.moveSpeed = 0.5F;
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));

        if (par1World != null && !par1World.isRemote)
        {
            this.func_85036_m();
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(13, new Byte((byte)0));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    public int getMaxHealth()
    {
        return 20;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     
    protected String getLivingSound()
    {
        return "mob.skeleton.say";
    }*/

    /**
     * Returns the sound this mob makes when it is hurt.
     
    protected String getHurtSound()
    {
        return "mob.skeleton.hurt";
    }*/

    /**
     * Returns the sound this mob makes on death.
     
    protected String getDeathSound()
    {
        return "mob.skeleton.death";
    }*/

    /**
     * Plays step sound at given x, y, z for the entity
     
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.skeleton.step", 0.15F, 1.0F);
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        if (super.attackEntityAsMob(par1Entity))
        {

            return true;
        }
        else
        {
            return false;
        }
    }*/

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    /**
     * Called when the mob's health reaches 0.
     
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);

        if (par1DamageSource.getSourceOfDamage() instanceof EntityArrow && par1DamageSource.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer var2 = (EntityPlayer)par1DamageSource.getEntity();
            double var3 = var2.posX - this.posX;
            double var5 = var2.posZ - this.posZ;

            if (var3 * var3 + var5 * var5 >= 2500.0D)
            {
                var2.triggerAchievement(AchievementList.snipeSkeleton);
            }
        }
    }*/

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.arrow.itemID;
    }

    /**
     * Initialize this creature.
     */
    public void initCreature()
    {
        if (this.worldObj.provider instanceof WorldProviderHell && this.getRNG().nextInt(5) > 0)
        {
            this.tasks.addTask(4, this.field_85038_e);
            this.setCurrentItemOrArmor(0, new ItemStack(Item.swordStone));
        }
        else
        {
            this.tasks.addTask(4, this.field_85037_d);
            this.func_82164_bB();
            this.func_82162_bC();
        }
    }

    public void func_85036_m()
    {
        this.tasks.func_85156_a(this.field_85038_e);
        this.tasks.func_85156_a(this.field_85037_d);
        ItemStack var1 = this.getHeldItem();

        if (var1 != null && var1.itemID == Item.bow.itemID)
        {
            this.tasks.addTask(4, this.field_85037_d);
        }
        else
        {
            this.tasks.addTask(4, this.field_85038_e);
        }
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLiving par1EntityLiving)
    {
        EntityArrow var2 = new EntityArrow(this.worldObj, this, par1EntityLiving, 1.6F, 12.0F);
        int var3 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
        int var4 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());

        if (var3 > 0)
        {
            var2.setDamage(var2.getDamage() + (double)var3 * 0.5D + 0.5D);
        }

        if (var4 > 0)
        {
            var2.setKnockbackStrength(var4);
        }

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var2);
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack)
    {
        super.setCurrentItemOrArmor(par1, par2ItemStack);

        if (!this.worldObj.isRemote && par1 == 0)
        {
            this.func_85036_m();
        }
    }
}
