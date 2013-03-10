package fisherman77.glacierice.common.blocks;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.*;
import fisherman77.glacierice.common.GlacierIce;

public class BlockGreenGlacierIce extends Block{
public BlockGreenGlacierIce(int ID){
         super(ID,Material.rock); //The ID and material
        
         setBlockName("GreenGlacierIce"); //The incode name
         setHardness(1.0F); //How hard the block is
         setResistance(5.0F); //How well the block resists explosions
         setStepSound(Block.soundStoneFootstep); //The sounds the block makes
         setCreativeTab(GlacierIce.tabGlacierIce); //The tab it appears in
         setTextureFile("/GlacierIce/GlacierIceBlocks.png"); //The texture file
}

/*public void onEntityWalking(World world, int i, int j, int k, Entity entity)
        {
                entity.motionY += 3.0;
        }*/
/**
 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
 * cleared to be reused)
 */
public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
    float var5 = 0.125F;
    return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
}

/**
 * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
 */
public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
{
    //par5Entity.setInWeb();
    par5Entity.fallDistance = 0.0F;
    par5Entity.motionY += 3.0;
}

public int idDropped(int i, Random random, int j)
{
        return GlacierIce.GreenGlacierIce.blockID;
}
public int quantityDropped(Random random)
{
                        return 1;
}

@SideOnly(Side.CLIENT)
public int getBlockTextureFromSide(int i){ //What texture it uses
return 1;
}
}