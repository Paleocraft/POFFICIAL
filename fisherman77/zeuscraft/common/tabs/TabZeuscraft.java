package fisherman77.zeuscraft.common.tabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import fisherman77.zeuscraft.common.Zeuscraft;


public class TabZeuscraft extends CreativeTabs {
public TabZeuscraft(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return Zeuscraft.Thunderbolt.itemID; //For this we'll use the ruby
}
public String getTranslatedTabLabel()
{
return "Zeuscraft"; //The name of the tab ingame
}
}