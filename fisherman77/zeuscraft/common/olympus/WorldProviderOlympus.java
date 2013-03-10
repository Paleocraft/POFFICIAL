package fisherman77.zeuscraft.common.olympus;

import fisherman77.zeuscraft.common.Zeuscraft;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderOlympus extends WorldProvider
{
 public void registerWorldChunkManager()
 {
  this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.beach, 0.8F, 0.1F);
  this.dimensionId = Zeuscraft.Olympus;
 }
 
 public String getDimensionName() 
 {
  return "Olympus";
 }
 
 public boolean canRespawnHere()
 {
  return true;
 }
 
 @Override
 public IChunkProvider createChunkGenerator()
 {
  return new ChunkProviderOlympus(worldObj, worldObj.getSeed(), true);
 }
}