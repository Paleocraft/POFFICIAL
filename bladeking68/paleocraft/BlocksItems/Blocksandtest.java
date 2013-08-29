package bladeking68.paleocraft.BlocksItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Blocksandtest extends Block
{
    public Blocksandtest(int par1)
    {
        super(par1, Material.sand);
        this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
    public void registerIcons(IconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("paleocraft:Test1");
    }
    }
