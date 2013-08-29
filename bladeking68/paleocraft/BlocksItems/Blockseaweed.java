package bladeking68.paleocraft.BlocksItems;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class Blockseaweed extends BlockFlower
{
    public Blockseaweed(int par1)
    {
        super(par1, Material.cactus);
        this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
    public void registerIcons(IconRegister iconRegister)
    {
             blockIcon = iconRegister.registerIcon("paleocraft:seaweed");
    }
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.sand.blockID || par1 == Block.waterStill.blockID || par1 == fisherman77.paleocraft.common.Paleocraft.seaweed.blockID;}
   
   
    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return EnumPlantType.Water;
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.2D;
        par5Entity.motionZ *= 0.2D;
    }
}