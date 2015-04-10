package bladeking68.paleocraft.BlocksItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
//import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Blockpaleoplainsgrass extends Block
{
@SideOnly(Side.CLIENT)
private IIcon iconGrassTop;
@SideOnly(Side.CLIENT)
private IIcon iconGrassBottom;
@SideOnly(Side.CLIENT)
private static IIcon iconGrassSideOverlay;

public Blockpaleoplainsgrass()
{
super(Material.grass);
this.setTickRandomly(true);
//this.setCreativeTab(CreativeTabs.tabBlock);
}

@SideOnly(Side.CLIENT)

/**
* From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
*/
public IIcon getIcon(int par1, int par2)
{
return par1 == 1 ? this.iconGrassTop : (par1 == 0 ? this.iconGrassBottom : this.blockIcon);
}

/**
* Ticks the block if it's been scheduled
*/


/**
* Returns the ID of the items to drop on destruction.
*/
public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
{
    return Blocks.dirt.getItemDropped(0, p_149650_2_, p_149650_3_);
}

@SideOnly(Side.CLIENT)

/**
* Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
*/
public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
{
if (par5 == 1)
{
return this.iconGrassTop;
}
else if (par5 == 0)
{
return this.iconGrassBottom;
}
else
{

return this.blockIcon;
}
}

@SideOnly(Side.CLIENT)

/**
* When this method is called, your block should register all the icons it needs with the given IconRegister. This
* is the only chance you get to register icons.
*/
public void registerIcons(IIconRegister par1IconRegister)
{
this.blockIcon = par1IconRegister.registerIcon("paleocraft:ppgrass_side");
this.iconGrassTop = par1IconRegister.registerIcon("paleocraft:ppgrass_top");
this.iconGrassBottom = par1IconRegister.registerIcon("paleocraft:Paleoplains_dirt");
this.iconGrassSideOverlay = par1IconRegister.registerIcon("paleocraft:ppgrass_side");
}

@SideOnly(Side.CLIENT)
public static IIcon getIconSideOverlay()
{
return iconGrassSideOverlay;
}
}
