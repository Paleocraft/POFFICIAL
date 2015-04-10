package bladeking68.paleocraft.BlocksItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class PaleocraftBlocksCreativeTab extends CreativeTabs {
	
	public PaleocraftBlocksCreativeTab(String tabLabel)
	{
		super(tabLabel);
	}



@Override
@SideOnly(Side.CLIENT)
public Item getTabIconItem()
{
return Paleocraft.fossil;
}
}
