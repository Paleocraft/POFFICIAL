package bladeking68.paleocraft.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Blockseaweed extends BlockFlower
{
    public Blockseaweed(int par1)
    {
        super(par1, Material.plants);
        this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
    public void registerIcons(IconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("Paleocraft Dimension:seaweed");
    }
    }
