package bladeking68.paleocraft.BlocksItems;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class Blockpaleoplainsdirt extends Block
{
    public Blockpaleoplainsdirt()
    {
        super(Material.ground);
        //this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    blockIcon = p_149651_1_.registerIcon("Paleocraft" + ":" + this.getUnlocalizedName().substring(5));
    
}
	@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    return blockIcon;
    }
    public Block idDropped(int par1, Random par2Random, int par3)
    {
        return Blocks.dirt;
    }}
