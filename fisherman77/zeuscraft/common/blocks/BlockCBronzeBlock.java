package fisherman77.zeuscraft.common.blocks;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.*;
import fisherman77.zeuscraft.common.Zeuscraft;


public class BlockCBronzeBlock extends Block{
	
public BlockCBronzeBlock(int ID){
	
         super(ID,Material.rock); //The ID and material
         
         setHardness(3.0F); //How hard the block is
         setResistance(5.0F); //How well the block resists explosions
         setStepSound(Block.soundStoneFootstep); //The sounds the block makes
         setCreativeTab(Zeuscraft.tabZeuscraft); //The tab it appears in
         setTextureFile("/Zeuscraft/ZeuscraftBlocks.png"); //The texture file
}

@SideOnly(Side.CLIENT)
public int getBlockTextureFromSideAndMetadata(int i, int j)
{
        return getBlockTextureFromSide(i);
}

public int getBlockTextureFromSide(int i)
{
        if (i == 0)
        {
                return 10;
        }
        if (i == 1)
        {
                return 10;
        }
        else
        {
                return 9;
        }
}
}