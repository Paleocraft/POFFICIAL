package bladeking68.paleocraft.BlocksItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Blocksandtest extends Block
{
    public Blocksandtest(int par1)
    {
        super(Material.sand);
       // this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
    public void registerIcons(IIconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("paleocraft:Test1");
    }
    }
