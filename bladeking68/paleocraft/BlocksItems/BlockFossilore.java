package bladeking68.paleocraft.BlocksItems;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockFossilore extends Block
{
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	
	
	public BlockFossilore()
    {
        super(Material.iron);
        this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
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

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Items.bone;
    }

}
