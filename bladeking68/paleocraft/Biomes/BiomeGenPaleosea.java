package bladeking68.paleocraft.Biomes;


import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeGenPaleosea extends BiomeGenBase
{
       private WorldGenMinable theWorldGenerator;
	

       public BiomeGenPaleosea(int par1)
       {
             super(par1);
             this.topBlock = (byte)Block.waterStill.blockID;
             this.fillerBlock = (byte)Block.sand.blockID;
             
             //this.theBiomeDecorator.SeaweedPerChunk = -999;
             this.theBiomeDecorator.treesPerChunk = -999;
             this.theBiomeDecorator.treesPerChunk = -999;
             this.theBiomeDecorator.flowersPerChunk = -999;
             this.theBiomeDecorator.deadBushPerChunk = -999;
             this.theBiomeDecorator.grassPerChunk = -999;
             this.theWorldGenerator = new WorldGenMinable(Block.pumpkin.blockID, -999);
             this.spawnableMonsterList.clear();
             this.spawnableCreatureList.clear();
             this.spawnableWaterCreatureList.clear();
             //this.spawnableCreatureList.add(new SpawnListEntry(fisherman77.paleocraft.common.mobs.EntityTylo.class,  10, 4, 4));
             
       }
}
