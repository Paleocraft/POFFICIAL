

package bladeking68.paleocraft.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderPaleocraft extends WorldProvider
{
 public void registerWorldChunkManager()
 {
  this.worldChunkMgr = new WorldChunkManagerPaleocraft(fisherman77.paleocraft.common.Paleocraft.Paleoplains);
  this.dimensionId = fisherman77.paleocraft.common.Paleocraft.PaleocraftDimension;
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

