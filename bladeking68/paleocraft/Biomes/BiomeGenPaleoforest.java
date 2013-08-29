package bladeking68.paleocraft.Biomes;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
private WorldGenTrees WorldGenPaleocraftTree1;

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
this.theBiomeDecorator.treesPerChunk = 25;

//this.spawnableCreatureList.add(new SpawnListEntry(fisherman77.paleocraft.common.mobs.EntityDromaeosaurus.class,  5, 4, 4));
//this.spawnableCreatureList.add(new SpawnListEntry(fisherman77.paleocraft.common.mobs.EntityDimorphodon.class,  8, 4, 4));
//this.topBlock = ((byte)fisherman77.paleocraft.common.Paleocraft.dirttest.blockID);
//this.fillerBlock = ((byte)Block.dirt.blockID);
//this.WorldGenPaleocraftTree1 = new WorldGenPaleocraftTree1(false);
this.setBiomeName("PaleoForest");}

/** this changes the water colour, its set to red now but google the java colours **/
//this.waterColorMultiplier = 0xE42D17;
//}

}
