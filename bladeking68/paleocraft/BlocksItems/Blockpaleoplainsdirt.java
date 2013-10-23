package bladeking68.paleocraft.BlocksItems;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Blockpaleoplainsdirt extends Block
{
    public Blockpaleoplainsdirt(int par1)
    {
        super(par1, Material.ground);
        //this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
    public void registerIcons(IconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("paleocraft:Paleoplains_dirt");
    }
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Block.dirt.blockID;
    }}