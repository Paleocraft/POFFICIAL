// This Is My Package Declaration And Everything Applies To Before With This
package fisherman77.glacierice.common.gen;

// You Don't Need This If You Have package net.minecraft.src;
import fisherman77.glacierice.common.GlacierIce;
import net.minecraft.block.Block;
import net.minecraft.src.*;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenGlacier extends BiomeGenBase{
public BiomeGenGlacier(int id){
super(id);
// This Is The Top Five Or So Blocks, Remember The Java Byte Rule: No Byte Is Above 127
topBlock = (byte)Block.oreEmerald.blockID;
// This Is The Rest Of The Blocks, Again The Java Byte Rule :)
fillerBlock = (byte)Block.ice.blockID;

theBiomeDecorator.treesPerChunk = 0;
theBiomeDecorator.deadBushPerChunk = 0;
theBiomeDecorator.reedsPerChunk = 0;
theBiomeDecorator.cactiPerChunk = 0;
waterColorMultiplier = 0x242424;
}
}