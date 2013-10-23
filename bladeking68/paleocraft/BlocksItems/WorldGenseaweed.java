package bladeking68.paleocraft.BlocksItems;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenseaweed extends WorldGenerator implements IWorldGenerator 
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int l = 0; l < 10; ++l)
        {
            int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
            int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
            int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

            if (par1World.isAirBlock(i1, j1, k1) && Paleocraft.seaweed.canPlaceBlockAt(par1World, i1, j1, k1))
            {
                par1World.setBlock(i1, j1, k1, Paleocraft.seaweed.blockID, 0, 2);
            }
        }

        return true;
    }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		
	}
}
