package bladeking68.paleocraft.BlocksItems;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
public class ItemFossil extends Item
{
	@SideOnly(Side.CLIENT)
	protected IIcon itemIcon;
   
	
	
	private Object iconIndex;

       public ItemFossil()
       {
    	   this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);    
            
       }
      
   
       public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
       {
           if (p_77648_7_ == 0)
           {
               --p_77648_5_;
           }

           if (p_77648_7_ == 1)
           {
               ++p_77648_5_;
           }

           if (p_77648_7_ == 2)
           {
               --p_77648_6_;
           }

           if (p_77648_7_ == 3)
           {
               ++p_77648_6_;
           }

           if (p_77648_7_ == 4)
           {
               --p_77648_4_;
           }

           if (p_77648_7_ == 5)
           {
               ++p_77648_4_;
           }

           if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
           {
               return false;
           }
           else
           {
               if (p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_))
               {
                   p_77648_3_.playSoundEffect((double)p_77648_4_ + 0.5D, (double)p_77648_5_ + 0.5D, (double)p_77648_6_ + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                   p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, Paleocraft.portaltrigger);
                 //  ((EntityPlayer) par1EntityPlayer).addChatComponentMessage(new ChatComponentTranslation("tile.beta.item", new Object[0]));         
               }

               p_77648_1_.damageItem(1, p_77648_2_);
               return true;
           //    ((EntityPlayer) par1EntityPlayer).addChatComponentMessage(new ChatComponentTranslation("tile.tamed.dromie", new Object[0]));         
           
           }
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
   	@Override
   	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
   	{
   	par3List.add("Activates Paleocraft Portal");
   	}

}
