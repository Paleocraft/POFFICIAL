package fisherman77.zeuscraft.common.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.*;
import fisherman77.zeuscraft.common.Zeuscraft;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;

public class ItemTrident extends Item {
public ItemTrident(int par1) {
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/Zeuscraft/ZeuscraftItems.png"); //Sets the item texture file
		setItemName("Trident"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(Zeuscraft.tabZeuscraft); //Tells the game what creative mode tab it goes in
		setIconIndex(3);
}

/**
 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
 */
public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
{
    if (par7 == 0)
    {
        --par5;
    }

    if (par7 == 1)
    {
        ++par5;
    }

    if (par7 == 2)
    {
        --par6;
    }

    if (par7 == 3)
    {
        ++par6;
    }

    if (par7 == 4)
    {
        --par4;
    }

    if (par7 == 5)
    {
        ++par4;
    }

    if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
    {
        return false;
    }
    else
    {
        int var11 = par3World.getBlockId(par4, par5, par6);

        if (var11 == 0)
        {
            par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            par3World.setBlockWithNotify(par4, par5, par6, Block.waterStill.blockID);
        }

        par1ItemStack.damageItem(1, par2EntityPlayer);
        return true;
    }
}

public EnumRarity getRarity(ItemStack par1ItemStack)
{
    return par1ItemStack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
}

}