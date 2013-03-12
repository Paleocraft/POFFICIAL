package bladeking68.paleocraft.dimension;

import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class portalTriggerPaleocraft extends Block
{
public portalTriggerPaleocraft(int par1, int par2)
{
super(par1, par2, Material.rock);
this.setTickRandomly(true);
//this.setCreativeTab(Paleocraft.PaleocraftBlocks);
this.setHardness(1.2F);
this.setStepSound(Block.soundGlassFootstep);
this.setBlockName("portalTriggerXXX");
}

@Override
public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
if (par1World.getBlockId(par2, par3 - 1, par4) != Block.cobblestoneMossy.blockID || !bladeking68.paleocraft.dimension.BlockPortalPaleocraft.tryToCreatePortal(par1World, par2, par3, par4))
{
if (par3 - 1 != Block.cobblestoneMossy.blockID)
{
}
else
{
par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate() + par1World.rand.nextInt(10));
}
}
}

@Override
public String getTextureFile()
{
return "Paleocraft/PaleocraftBlocks.png";
}
}