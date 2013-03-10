package fisherman77.zeuscraft.common.items;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import fisherman77.zeuscraft.common.Zeuscraft;
import net.minecraft.creativetab.CreativeTabs;

public class ItemPegasusSaddle extends Item {
public ItemPegasusSaddle(int par1) {
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/Zeuscraft/ZeuscraftItems.png"); //Sets the item texture file
		setItemName("PegasusSaddle"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(Zeuscraft.tabZeuscraft); //Tells the game what creative mode tab it goes in
		setIconIndex(1);
}
}