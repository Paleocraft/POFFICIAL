package bladeking68.paleocraft.dimension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class portalTriggerPaleocraft extends Block
{
public portalTriggerPaleocraft(int par1, int par2)
{
super(par1, Material.rock);
this.setTickRandomly(true);
//this.setCreativeTab(PaleocraftDimension.PaleocraftBlocks);
this.setHardness(1.2F);
this.setStepSound(Block.soundGlassFootstep);

}

public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
    if (par1World.provider.dimensionId > 20 || par1World.getBlockId(par2, par3 - 1, par4) != Block.cobblestoneMossy.blockID || !((BlockPortalPaleocraft) Paleocraft.PaleocraftPortal).tryToCreatePortal(par1World, par2, par3, par4))
   
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else
        {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World) + par1World.rand.nextInt(10));
        }
    
}



//@SideOnly(Side.CLIENT)
//public void registerIcons(IconRegister par1IconRegister)
//{
 //this.blockIcon = par1IconRegister.registerIcon(PaleocraftDimension.PaleocraftDimension + "Portal" + this.getUnlocalizedName2());
//}
//}

public void registerIcons(IconRegister iconRegister)
{
         blockIcon = iconRegister.registerIcon("Paleocraft Dimension:Portal trigger");
}
}
