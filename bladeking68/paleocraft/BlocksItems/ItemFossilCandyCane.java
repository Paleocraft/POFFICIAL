package bladeking68.paleocraft.BlocksItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
public class ItemFossilCandyCane extends ItemFood
{
	@SideOnly(Side.CLIENT)
	protected IIcon itemIcon;
   
	
	
	private Object iconIndex;

       public ItemFossilCandyCane()
       {
    	  
    	   super(2, 2.0F, false);
    	   this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);    
            
       }
      
   
    
   

     /*  @Override
       @SideOnly(Side.CLIENT)
       public void registerIcons(IIconRegister iconRegister)
       {
       itemIcon = iconRegister.registerIcon("paleocraft:" + "Fossil");
       }*/
   	@SideOnly(Side.CLIENT)
    public void registerItemIcons(IIconRegister p_149651_1_)
    {
    itemIcon = p_149651_1_.registerIcon("Paleocraft" + ":" + this.getUnlocalizedName().substring(5));
    
}


   	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    return itemIcon;
    }


}
