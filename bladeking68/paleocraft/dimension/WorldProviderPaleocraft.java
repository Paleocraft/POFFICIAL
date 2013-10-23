package bladeking68.paleocraft.dimension;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderPaleocraft extends WorldProvider
{
public void registerWorldChunkManager()
{
/** tells Minecraft to use our new WorldChunkManager **/
this.worldChunkMgr = new WorldChunkManagerPaleocraft(worldObj.getSeed(), terrainType);
this.hasNoSky = false;
}

@Override
/** Dimension Name **/
public String getDimensionName()
{
return "Paleocraft";
}

/** Get Provider for dimension **/
public static WorldProvider getProviderForDimension(int id)
{
return DimensionManager.createProviderFor(fisherman77.paleocraft.common.Paleocraft.PaleocraftDimension);
}

/** Welcome message **/
public String getWelcomeMessage()
{
return "Entering Paleocraft";
}

/** What chunk provider to use **/
public IChunkProvider createChunkGenerator()
{
return new ChunkProviderPaleocraft(worldObj, worldObj.getSeed(), true);
}

/** Can player re-spawn here **/
public boolean canRespawnHere()
{
return true;
}

/** Set user message **/
// not sure if this works any more ?
protected synchronized String setUserMessage(String par1Str)
{
return "Building Paleocraft";
}

/** Determines the dimension the player will be respawned in **/
public int getRespawnDimension(EntityPlayerMP player)
{
return 0;
}

/** Dimension Movement speed **/
public double getMovementFactor()
{
return 10.0;
}
public boolean renderClouds()
{

 return true;

}
public String getSaveFolder()
{
    return "Paleocraft Dimension";
}
public boolean renderStars()
{

 return true;

}}
