package bladeking68.paleocraft.dimension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;
public class ItemFossil extends Item
{
       private Object iconIndex;

       public ItemFossil(int id)
       {
             super(id);
             this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
       }
      
   
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
               int i1 = par3World.getBlockId(par4, par5, par6);

               if (i1 == 0)
               {
                   par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                   par3World.setBlock(par4, par5, par6, fisherman77.paleocraft.common.Paleocraft.portalTrigger.blockID);
               }

               par1ItemStack.damageItem(1, par2EntityPlayer);
               return true;
                }}

//@SideOnly(Side.CLIENT)
//public void updateIcons(IconRegister par1IconRegister)
//{
// this.iconIndex = par1IconRegister.registerIcon(PaleocraftDimension.PaleocraftDimension + "Paleocraft Dimension" + this.getUnlocalizedName());
//}}

       @Override
       @SideOnly(Side.CLIENT)
       public void registerIcons(IconRegister iconRegister)
       {
       itemIcon = iconRegister.registerIcon("Paleocraft Dimension:" + this.getUnlocalizedName());
       }
}
