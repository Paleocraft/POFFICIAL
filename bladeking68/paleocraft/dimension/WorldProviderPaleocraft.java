package bladeking68.minecraft.paleocraftD;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderPaleocraft extends WorldProvider
{
 public void registerWorldChunkManager()
 {
  this.worldChunkMgr = new WorldChunkManagerHell(PaleocraftDimension.Paleoplains, 0.8F, 0.1F);
  this.dimensionId = PaleocraftDimension.PaleocraftDimension;
 }
 
 public String getDimensionName() 
 {
  return "Paleocraft Dimension";
 }
 
 public boolean canRespawnHere()
 {
  return true;
 }
 
 public String getSaveFolder()
 {
     return "Paleocraft Dimension";
 }

 
 @Override
 public IChunkProvider createChunkGenerator()
 {
  return new ChunkProviderPaleocraft(worldObj, worldObj.getSeed(), true);
 }
}

