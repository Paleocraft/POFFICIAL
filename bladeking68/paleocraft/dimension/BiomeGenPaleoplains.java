package bladeking68.paleocraft.dimension;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenPaleoplains extends BiomeGenBase
{
       public BiomeGenPaleoplains(int par1)
       {
             super(par1);
             this.theBiomeDecorator.treesPerChunk = 0;
             this.theBiomeDecorator.flowersPerChunk = 0;
             this.theBiomeDecorator.deadBushPerChunk = 1;
              this.spawnableMonsterList.clear();
             this.spawnableCreatureList.clear();
             this.spawnableWaterCreatureList.clear();
             //this.spawnableMonsterList.add(new SpawnListEntry(EntityNAME.class, 1, 4, 4)); //Fisherman just keep coping this for each dino and the numbers are the spawn rate i think so you can edit that if you want
      
      
      }
}
