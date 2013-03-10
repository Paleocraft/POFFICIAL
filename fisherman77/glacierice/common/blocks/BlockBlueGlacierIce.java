package fisherman77.glacierice.common.blocks;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.*;
import fisherman77.glacierice.common.GlacierIce;

public class BlockBlueGlacierIce extends Block{
public BlockBlueGlacierIce(int ID){
         super(ID,Material.rock); //The ID and material
        
         setBlockName("BlueGlacierIce"); //The incode name
         setHardness(1.0F); //How hard the block is
         setResistance(5.0F); //How well the block resists explosions
         setStepSound(Block.soundStoneFootstep); //The sounds the block makes
         setCreativeTab(GlacierIce.tabGlacierIce); //The tab it appears in
         setTextureFile("/GlacierIce/GlacierIceBlocks.png"); //The texture file
         slipperiness = 1.5F; //make glacier ice do what it does
}

@SideOnly(Side.CLIENT)
public int getBlockTextureFromSide(int i){ //What texture it uses
return 0;
}

public int idDropped(int i, Random random, int j)
{
        return GlacierIce.BlueGlacierIce.blockID;
}
public int quantityDropped(Random random)
{
                        return 1;
}

}