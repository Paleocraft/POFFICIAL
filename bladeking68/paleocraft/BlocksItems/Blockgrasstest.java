package bladeking68.paleocraft.BlocksItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Blockgrasstest extends Block
{
    public Blockgrasstest(int par1)
    {
        super(par1, Material.grass);
        //this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
    public void registerIcons(IconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("paleocraft:Test1");
    }
    }