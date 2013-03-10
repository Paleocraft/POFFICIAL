package bladeking68.paleocraft.dimension;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import fisherman77.zeuscraft.common.Zeuscraft;


public class PaleocraftBlocksCreativeTab extends CreativeTabs {
public PaleocraftBlocksCreativeTab(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return Item.bone.itemID; //For this we'll use the ruby
}
public String getTranslatedTabLabel()
{
return "Paleocraft"; //The name of the tab ingame
}
}