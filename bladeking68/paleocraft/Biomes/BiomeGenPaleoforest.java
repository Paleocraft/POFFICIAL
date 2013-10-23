package bladeking68.paleocraft.Biomes;

import java.util.List;
import java.util.Random;

import bladeking68.paleocraft.Tree.WorldGenPaleocraftTree1;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.mobs.EntityDromaeosaurus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
public class BiomeGenPaleoforest extends BiomeGenBase
{
public final Material blockMaterial;
//private WorldGenTrees WorldGenPaleocraftTree1;
private WorldGenPaleocraftTree1 WorldGenPaleocraft1;

//private WorldGenerator WorldGenPaleocraftTree1;
//private Object worldGeneratorPaleocraftTree1;
public BiomeGenPaleoforest(int par1)
{
super(par1);
this.blockMaterial = Material.water;
this.minHeight = 0.1F;
this.maxHeight = 0.6F;
this.spawnableMonsterList.clear();
this.spawnableCreatureList.clear();
this.spawnableWaterCreatureList.clear();
//this.theBiomeDecorator.treesPerChunk = 25;
this.topBlock = (byte)fisherman77.paleocraft.common.Paleocraft.paleoforestgrass.blockID;
this.spawnableCreatureList.add(new SpawnListEntry(EntityDromaeosaurus.class, 100, 4, 4));
//this.spawnableCreatureList.add(new SpawnListEntry(fisherman77.paleocraft.common.mobs.EntityDimorphodon.class,  8, 4, 4));
//this.topBlock = ((byte)fisherman77.paleocraft.common.Paleocraft.dirttest.blockID);
this.fillerBlock = ((byte)Block.grass.blockID);
//this.WorldGenPaleocraftTree1 = new WorldGenPaleocraftTree1(false);
this.setBiomeName("PaleoForest");
this.WorldGenPaleocraft1 = new WorldGenPaleocraftTree1(false);}
/** this changes the water colour, its set to red now but google the java colours **/
//this.waterColorMultiplier = 0xE42D17;
//}
public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
{
return (WorldGenerator)(par1Random.nextInt(5) == 0 ? this.worldGeneratorForest : (par1Random.nextInt(10) == 0 ? this.WorldGenPaleocraft1 : this.worldGeneratorTrees));
}


}
