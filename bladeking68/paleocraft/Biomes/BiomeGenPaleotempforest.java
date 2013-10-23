package bladeking68.paleocraft.Biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenPaleotempforest extends BiomeGenBase
{
    private net.minecraft.world.gen.feature.WorldGenForest WorldGenForest;

	public BiomeGenPaleotempforest(int par1)
    {
        super(par1);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 1;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.reedsPerChunk = 10;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.waterlilyPerChunk = 4;
        this.waterColorMultiplier = 14745518;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
       
    
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
	

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
   

   

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    
}
