package bladeking68.paleocraft.Biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeGenPaleodesert extends BiomeGenBase
{
       private WorldGenMinable theWorldGenerator;

       public BiomeGenPaleodesert(int par1)
       {
             super(par1);
             this.topBlock = (byte)Block.sand.blockID;
             this.fillerBlock = (byte)Block.sand.blockID;
             
             
             this.theBiomeDecorator.treesPerChunk = -999;
             this.theBiomeDecorator.flowersPerChunk = -999;
             this.theBiomeDecorator.deadBushPerChunk = -999;
             this.theBiomeDecorator.grassPerChunk = -999;
             this.theWorldGenerator = new WorldGenMinable(Block.pumpkin.blockID, -999);
             this.spawnableMonsterList.clear();
             this.spawnableCreatureList.clear();
             this.spawnableWaterCreatureList.clear();
          //   this.spawnableMonsterList.add(new SpawnListEntry(fisherman77.paleocraft.common.mobs.EntityDromaeosaurus.class, 1, 4, 4)); //Fisherman just keep coping this for each dino and the numbers are the spawn rate i think so you can edit that if you want
           // this.spawnableCreatureList.add(new SpawnListEntry(fisherman77.paleocraft.common.mobs.EntityTroodon.class, 5, 2, 6));
             //this.spawnableCreatureList.add(new SpawnListEntry(fisherman77.paleocraft.common.mobs.EntityDimorphodon.class,  8, 4, 4));
       }
}
