package bladeking68.paleocraft.BlocksItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Blockpaleoplainsgrass extends Block
{
@SideOnly(Side.CLIENT)
private Icon iconGrassTop;
@SideOnly(Side.CLIENT)
private Icon iconGrassBottom;
@SideOnly(Side.CLIENT)
private static Icon iconGrassSideOverlay;

public Blockpaleoplainsgrass(int par1)
{
super(par1, Material.grass);
this.setTickRandomly(true);
//this.setCreativeTab(CreativeTabs.tabBlock);
}

@SideOnly(Side.CLIENT)

/**
* From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
*/
public Icon getIcon(int par1, int par2)
{
return par1 == 1 ? this.iconGrassTop : (par1 == 0 ? this.iconGrassBottom : this.blockIcon);
}

/**
* Ticks the block if it's been scheduled
*/


/**
* Returns the ID of the items to drop on destruction.
*/
public int idDropped(int par1, Random par2Random, int par3)
{
return Block.dirt.idDropped(0, par2Random, par3);
}

@SideOnly(Side.CLIENT)

/**
* Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
*/
public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
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
public void registerIcons(IconRegister par1IconRegister)
{
this.blockIcon = par1IconRegister.registerIcon("paleocraft:ppgrass_side");
this.iconGrassTop = par1IconRegister.registerIcon("paleocraft:ppgrass_top");
this.iconGrassBottom = par1IconRegister.registerIcon("paleocraft:Paleoplains_dirt");
this.iconGrassSideOverlay = par1IconRegister.registerIcon("paleocraft:ppgrass_side");
}

@SideOnly(Side.CLIENT)
public static Icon getIconSideOverlay()
{
return iconGrassSideOverlay;
}
}