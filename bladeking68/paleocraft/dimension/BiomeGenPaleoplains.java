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
       }
}