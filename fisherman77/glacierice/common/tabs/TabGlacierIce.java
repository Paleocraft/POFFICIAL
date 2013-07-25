package fisherman77.glacierice.common.tabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import fisherman77.glacierice.common.GlacierIce;


public class TabGlacierIce extends CreativeTabs
{
public TabGlacierIce(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return GlacierIce.BlueGlacierIce.blockID; //For this we'll use the ruby
}
public String getTranslatedTabLabel()
{
return "Glacier Ice"; //The name of the tab ingame
}
}