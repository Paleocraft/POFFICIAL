package bladeking68.paleocraft.dimension;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
public class MainTreeGenPaleocraft implements IWorldGenerator
{
/** Methods For Ore Generation **/
@Override
public void generate(Random random, int chunkX, int chunkZ, World world,
IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
{
if(world.provider.dimensionId == 0)//surface
{
this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
}
else if(world.provider.dimensionId == -1)//End
{
this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
}
else if(world.provider.dimensionId == 1)//Nether
{
generateNether(world, random, chunkX * 16, chunkZ * 16, chunkProvider, chunkX, chunkZ);
}
else if(world.provider.dimensionId == 5)//Tutorial
{
this.generateTutorial(world, random, chunkX * 16, chunkZ * 16);
}
}
/** Generate's the Ore's In Surface World **/
private void generateSurface(World world, Random random, int chunkX, int chunkZ)
{
if(world.getFirstUncoveredBlock(chunkX, chunkZ) == Block.grass.blockID)
{
for(int k = 0; k < 20; k++) //Creates a new integer, 'k', which is between 0 and whatever we used for the rarity.
{
//this below just tells me if its generating or not
//System.out.println("Generating Trees on surface");

int RandPosX = chunkX + random.nextInt(16); //These states the position of the structure; between 0 and 16 for the x and z axes, and between 0 and 128 (just below cloud level for the
int RandPosY = random.nextInt(90); //y axis. This is very standard stuff, so you don't need to change any of this except the rarity. You can play around with these figures
int RandPosZ = chunkZ + random.nextInt(16); //if you want, but nothing really needs to be altered.

//(new WorldGenPaleocraftTree1(false)).generate(world, random, RandPosX, RandPosY, RandPosZ);
}
}
}
/** Generates Ore's In Nether **/
private void generateNether(World world, Random random, int chunkX, int chunkZ, IChunkProvider par1IChunkProvider, int par2, int par3)
{
;
}
/** Generates Ore's in TheEnd **/
private void generateEnd(World world, Random random, int chunkX, int chunkZ)
{
;
}

private void generateTutorial(World world, Random random, int chunkX, int chunkZ)
{
for(int k = 0; k < 20; k++) //Creates a new integer, 'k', which is between 0 and whatever we used for the rarity.
{
//this below just tells me if its generating or not
//System.out.println("Generating Trees in dimension");

int RandPosX = chunkX + random.nextInt(16); //These states the position of the structure; between 0 and 16 for the x and z axes, and between 0 and 128 (just below cloud level for the
int RandPosY = random.nextInt(90); //y axis. This is very standard stuff, so you don't need to change any of this except the rarity. You can play around with these figures
int RandPosZ = chunkZ + random.nextInt(16); //if you want, but nothing really needs to be altered.

//(new WorldGenPaleocraftTree1(false)).generate(world, random, RandPosX, RandPosY, RandPosZ);
}

for(int k = 0; k < 10; k++) //Creates a new integer, 'k', which is between 0 and whatever we used for the rarity.
{
//this below just tells me if its generating or not


}
}}
