package bladeking68.paleocraft.BlocksItems;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class Blockhorsetails extends BlockBush
{
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
    public Blockhorsetails()
    {
    	super(Material.plants);
        this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
   /* public void registerIcons(IIconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("paleocraft:seaweed");
    }*/
    /*public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return !super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) ? false : this.canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
    }*/

    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
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
 

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
   
    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
  /*  public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
    {
        if (p_149718_1_.getBlock(p_149718_2_ - 1, p_149718_3_, p_149718_4_).getMaterial().isSolid())
        {
            return false;
        }
        else if (p_149718_1_.getBlock(p_149718_2_ + 1, p_149718_3_, p_149718_4_).getMaterial().isSolid())
        {
            return false;
        }
        else if (p_149718_1_.getBlock(p_149718_2_, p_149718_3_, p_149718_4_ - 1).getMaterial().isSolid())
        {
            return false;
        }
        else if (p_149718_1_.getBlock(p_149718_2_, p_149718_3_, p_149718_4_ + 1).getMaterial().isSolid())
        {
            return false;
        }
        else
        {
            Block block = p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_);
            return block.canSustainPlant(p_149718_1_, p_149718_2_, p_149718_3_ - 1, p_149718_4_, ForgeDirection.UP, this);
        }
    }*/



   /* @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.;
    }*/

 



}
