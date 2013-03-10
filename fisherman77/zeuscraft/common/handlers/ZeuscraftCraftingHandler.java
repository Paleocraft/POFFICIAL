package fisherman77.zeuscraft.common.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import fisherman77.zeuscraft.common.Zeuscraft;

public class ZeuscraftCraftingHandler implements ICraftingHandler
{

@Override
public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
{
if (item.itemID == Zeuscraft.Thunderbolt.itemID)
{
player.addStat(Zeuscraft.Thunderstruck, 1);
}
}

@Override
public void onSmelting(EntityPlayer player, ItemStack item)
{

}

}