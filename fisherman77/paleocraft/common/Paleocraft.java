package fisherman77.paleocraft.common;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
//import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import bladeking68.paleocraft.Biomes.BiomeGenPaleoSwamp;
import bladeking68.paleocraft.Biomes.BiomeGenPaleodesert;
import bladeking68.paleocraft.Biomes.BiomeGenPaleoforest;
import bladeking68.paleocraft.Biomes.BiomeGenPaleoplains;
import bladeking68.paleocraft.Biomes.BiomeGenPaleosea;
import bladeking68.paleocraft.Biomes.BiomeGenPaleotempforest;
import bladeking68.paleocraft.Biomes.PaleocraftBiomes;
import bladeking68.paleocraft.BlocksItems.BlockFossilore;
import bladeking68.paleocraft.BlocksItems.BlockPortalPaleocraft;
import bladeking68.paleocraft.BlocksItems.Blockhorsetails;
import bladeking68.paleocraft.BlocksItems.Blockcyad;
import bladeking68.paleocraft.BlocksItems.Blockconiferlog;
//import bladeking68.paleocraft.BlocksItems.BlockDINOEGG;
//import bladeking68.paleocraft.BlocksItems.BlockPortalPaleocraft;
import bladeking68.paleocraft.BlocksItems.Blockdirttest;
import bladeking68.paleocraft.BlocksItems.Blockgrasstest;
import bladeking68.paleocraft.BlocksItems.Blocknest;
import bladeking68.paleocraft.BlocksItems.Blockpaleocraftbasic;
import bladeking68.paleocraft.BlocksItems.Blockpaleodesertsand;
import bladeking68.paleocraft.BlocksItems.Blockpaleoforestgrass;
import bladeking68.paleocraft.BlocksItems.Blockpaleoplainsdirt;
import bladeking68.paleocraft.BlocksItems.Blockpaleoplainsgrass;
import bladeking68.paleocraft.BlocksItems.Blockseaweed;
import bladeking68.paleocraft.BlocksItems.Blocksmallcycad;
import bladeking68.paleocraft.BlocksItems.ItemBabyFish;
import bladeking68.paleocraft.BlocksItems.ItemBabySeaReptile;
import bladeking68.paleocraft.BlocksItems.ItemBabySeaReptileAwake;
import bladeking68.paleocraft.BlocksItems.ItemCookedDinoegg;
import bladeking68.paleocraft.BlocksItems.ItemDinoegg;
import bladeking68.paleocraft.BlocksItems.ItemFishSleep;
import bladeking68.paleocraft.BlocksItems.ItemFossilCandyCane;
import bladeking68.paleocraft.BlocksItems.ItemNestBaby;
import bladeking68.paleocraft.BlocksItems.ItemNestBabyAwake;
import bladeking68.paleocraft.BlocksItems.PaleocraftWorldGenerator;
import bladeking68.paleocraft.BlocksItems.portalTriggerPaleocraft;
//import bladeking68.paleocraft.BlocksItems.Blocktree1sapling;
//import bladeking68.paleocraft.BlocksItems.Blocktree2sapling;
import bladeking68.paleocraft.BlocksItems.ItemDromaeosaurusEgg;
import bladeking68.paleocraft.BlocksItems.ItemFossil;
import bladeking68.paleocraft.BlocksItems.ItemTroodonEgg;
import bladeking68.paleocraft.BlocksItems.PaleocraftBlocksCreativeTab;
import bladeking68.paleocraft.BlocksItems.TileEntityEGG;
//import bladeking68.paleocraft.BlocksItems.portalTriggerPaleocraft;
import bladeking68.paleocraft.Tree.PaleocraftEventClass;
import bladeking68.paleocraft.Tree.WorldGenPaleocraftTree1;
import bladeking68.paleocraft.Tree.WorldGenPaleocraftTree2;
import bladeking68.paleocraft.WorldGen.WorldGenHorseTails;
import bladeking68.paleocraft.WorldGen.WorldGenNest;
import bladeking68.paleocraft.WorldGen.WorldGenseaweed;
import bladeking68.paleocraft.dimension.PaleocraftDimension;
import bladeking68.paleocraft.dimension.PaleocraftDimensionID;
import bladeking68.paleocraft.dimension.WorldProviderPaleocraft;
import bladeking68.paleocraft.dimension.WorldTypesPaleocraft;
import cpw.mods.fml.common.IWorldGenerator;
//import bladeking68.paleocraft.dimension.MainRegistryPaleocraft;
//import bladeking68.paleocraft.dimension.WorldProviderPaleocraft;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
//import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
//import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import cpw.mods.fml.common.network.NetworkMod;
//import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fisherman77.paleocraft.common.handlers.GameLogger;
//import fisherman77.paleocraft.common.config.PaleocraftConfigCore;
//import fisherman77.paleocraft.common.handlers.PaleocraftClientPacketHandler;
//import fisherman77.paleocraft.common.handlers.PaleocraftServerPacketHandler;
import fisherman77.paleocraft.common.handlers.PaleocraftSoundHandler;
import fisherman77.paleocraft.common.mobs.EntityBaryonyx;
import fisherman77.paleocraft.common.mobs.EntityCitipati;
import fisherman77.paleocraft.common.mobs.EntityCompy;
import fisherman77.paleocraft.common.mobs.EntityDimorphodon;
import fisherman77.paleocraft.common.mobs.EntityDromaeosaurus;
//import fisherman77.paleocraft.common.mobs.EntityGhost;
import fisherman77.paleocraft.common.mobs.EntityMasso;
import fisherman77.paleocraft.common.mobs.EntityMegalodon;
import fisherman77.paleocraft.common.mobs.EntityQuetzalcoatlus;
import fisherman77.paleocraft.common.mobs.EntitySpino;
import fisherman77.paleocraft.common.mobs.EntityTroodon;
import fisherman77.paleocraft.common.mobs.EntityTylo;
import fisherman77.paleocraft.common.mobs.RegEntity;


/*@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Paleocraft" }, packetHandler = PaleocraftClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Paleocraft"}, packetHandler = PaleocraftServerPacketHandler.class)) //For serverside packet handling*/


//==========
//Mod Basics
//==========
@Mod(modid="Paleocraft",name="Paleocraft",version="1.7.10 Cambrian 1.6.0")

public class Paleocraft {
	//public static Block PaleocraftPortal;

	@Instance("Paleocraft") //The instance, this is very important later on
public static Paleocraft instance = new Paleocraft();

@SidedProxy(clientSide = "fisherman77.paleocraft.client.PaleocraftClientProxy", serverSide = "fisherman77.paleocraft.common.PaleocraftCommonProxy") //Tells Forge the location of your proxies
public static PaleocraftCommonProxy proxy;

boolean spawnBary;
boolean spawnCiti;
boolean spawnDromie;
boolean spawnTroo;
boolean spawnDimorph;
public static Block dirttest;
public static Block grasstest;
public static Block Paleoplains_dirt;
public static Block Paleodesert_sand;
public static Block paleoplainsgrass;
public static Block pfgrass;
public static BiomeGenBase Paleoplains;
public static BiomeGenBase Paleotempforest;
public static BiomeGenBase Paleodesert;
public static BiomeGenBase Paleosea;
public static BiomeGenBase Paleoforest;
public static BiomeGenBase Paleoswamp;
public static CreativeTabs PaleocraftBlocks = new PaleocraftBlocksCreativeTab("Paleocraft");
public static Block portalTrigger;
public static Block treesapling1;
public static Block treesapling2;
public static Block seaweed;
public static Block horsetails;
public static Block Fossiloreholiday;
public static Block DINOEGG;
public static Block paleocraftbasic;
public static Item dinoegg;
public static Block nest;
public static Block cyad;
public static Block smallcycad;
public static Block coniferlog;
public static Item nestbabyawake;
//public static Block portalPlacer2;
//public static int PaleocraftDimension = 20;
public static Item nestbaby;
public static Item fossil;
public static Item fossilcandycane;
public static Item cookeddinoegg;
public static Item babyseareptile;
public static Item babyseareptileawake;
PaleocraftWorldGenerator ore_gen = new PaleocraftWorldGenerator();
public static Item TroodonEgg;
public static Item DromaeosaurusEgg;
public static Item babyfish;
public static Item sleepingfish;


public static BiomeGenBase TutorialBiomeDeafult; 
//public static final StepSound soundGrassFootstep = new StepSound("grass", 1.0F, 1.0F);
public static final String MODID = "Paleocraft";
public static BlockPortalPaleocraft portalpaleocraft;
public static portalTriggerPaleocraft portaltrigger;
@EventHandler
public void PreLoad(FMLPreInitializationEvent e)
{
	RegEntity.Paleocraft();
	//event bonemeal
	MinecraftForge.EVENT_BUS.register(new PaleocraftEventClass());
	GameLogger.createFolders();
	proxy.registerRenderers();
/**
* Registering Paleocraft sounds...
**/
//MinecraftForge.EVENT_BUS.register(new PaleocraftSoundHandler());
	proxy.registerSounds();
/**
 * Registering the Core Config class
 */
/*PaleocraftConfigCore cc = new PaleocraftConfigCore();

PaleocraftConfigCore.loadConfig(e);*/

/**
 * We've got to put this stuff here in case we reference it in the Init
 */
//SPAWN TEST


//EntityRegistry.addSpawn(EntityDromaeosaurus.class, 10, 4, 4, EnumCreatureType.creature, Paleocraft.Paleoforest);

//Biome Blocks
dirttest = new Blockdirttest().setBlockName("dirttest"); GameRegistry.registerBlock(dirttest, dirttest.getUnlocalizedName().substring(5)).setHardness(0.5F);//.setStepSound(Block.soundGravelFootstep);
grasstest = new Blockgrasstest().setBlockName("grasstest"); GameRegistry.registerBlock(grasstest, grasstest.getUnlocalizedName().substring(5));
//Paleodesert_sand = new Blockpaleocraftbasic(Material.rock, "Paleodesert_sand", "Paleodesert_sand", Block.soundTypeSand);
Paleodesert_sand = new Blockpaleodesertsand().setBlockName("Paleodesert_sand"); GameRegistry.registerBlock(Paleodesert_sand, Paleodesert_sand.getUnlocalizedName().substring(5)).setHardness(0.5F).setStepSound(Block.soundTypeSand);
Paleoplains_dirt = new Blockpaleoplainsdirt().setBlockName("Paleoplains_dirt"); GameRegistry.registerBlock(Paleoplains_dirt, Paleoplains_dirt.getUnlocalizedName().substring(5)).setHardness(0.5F).setStepSound(Block.soundTypeGravel);
paleoplainsgrass = new Blockpaleoplainsgrass().setBlockName("paleoplainsgrass"); GameRegistry.registerBlock(paleoplainsgrass, paleoplainsgrass.getUnlocalizedName().substring(5)).setHardness(0.5F).setStepSound(Block.soundTypeGrass);
pfgrass = new Blockpaleoforestgrass().setBlockName("pfgrass"); GameRegistry.registerBlock(pfgrass, pfgrass.getUnlocalizedName().substring(5)).setHardness(0.5F).setStepSound(Block.soundTypeGrass);
Fossiloreholiday = new BlockFossilore().setBlockName("fossilore"); GameRegistry.registerBlock(Fossiloreholiday, Fossiloreholiday.getUnlocalizedName().substring(5)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
paleocraftbasic = new Blockpaleocraftbasic(Material.rock, "paleocraftbasic", "paleocraftbasic", Block.soundTypeStone);
nest = new Blocknest().setBlockName("nest"); GameRegistry.registerBlock(nest, nest.getUnlocalizedName().substring(5)).setBlockTextureName("nest").setStepSound(Block.soundTypeSand);//.setStepSound(Block.soundGravelFootstep);
coniferlog = new Blockconiferlog().setBlockName("coniferlog");// GameRegistry.registerBlock(coniferlog, coniferlog.getUnlocalizedName().substring(5)).setBlockTextureName("log_conifer");//.setStepSound(Block.soundGravelFootstep);
//Biomes
	/*Paleoplains = new BiomeGenPaleoplains().setColor(2900485).setBiomeName("PaleoPlains").setTemperatureRainfall(1F, 0.5F).BiomeGenBase.Height(0.1F, 0.2F);
	Paleotempforest = new BiomeGenPaleotempforest().setColor(2900485).setBiomeName("PaleoTempForest").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(0.1F, 0.2F);
	Paleodesert = new BiomeGenPaleodesert().setColor(2900485).setBiomeName("Paleodesert").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(0.1F, 0.2F);
	Paleosea = new BiomeGenPaleosea(PaleocraftConfigCore.biomepaleoseaID).setColor(2900485).setBiomeName("Paleosea").setTemperatureRainfall(1F, 0.5F).Height(-1.0F, 0.1F);
	Paleoforest = new BiomeGenPaleoforest(PaleocraftConfigCore.biomepaleoforestID).setColor(2900485).setBiomeName("Paleoforest").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(-0.2F, 0.1F);
	Paleoswamp = new BiomeGenPaleoSwamp(PaleocraftConfigCore.biomepaleoswampID).setColor(522674).setBiomeName("PaleoSwamp").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.1F).setTemperatureRainfall(0.8F, 0.9F);*/
	
	
	//Items
	fossil = new ItemFossil().setUnlocalizedName("Fossil").setTextureName("Paleocraft" + ":" + "Fossil");
	fossilcandycane = new ItemFossilCandyCane().setUnlocalizedName("fossilicecream").setTextureName("Paleocraft" + ":" + "fossilicecream");
	TroodonEgg = new ItemTroodonEgg().setUnlocalizedName("DinoEgg");
	DromaeosaurusEgg = new ItemDromaeosaurusEgg().setUnlocalizedName("DinoEgg2");
	dinoegg = new ItemDinoegg().setUnlocalizedName("dinoegg").setTextureName("Paleocraft" + ":" + "dino_egg");
	cookeddinoegg = new ItemCookedDinoegg().setUnlocalizedName("cookeddinoegg").setTextureName("Paleocraft" + ":" + "dinoegg_cooked");
	babyseareptile = new ItemBabySeaReptile().setUnlocalizedName("babyseareptile").setTextureName("Paleocraft" + ":" + "baby_sea_reptile");
	babyseareptileawake = new ItemBabySeaReptileAwake().setUnlocalizedName("babyseareptileawake").setTextureName("Paleocraft" + ":" + "baby_sea_reptile_awake");
	nestbaby = new ItemNestBaby().setUnlocalizedName("nestbaby").setTextureName("Paleocraft" + ":" + "nest_baby");
	nestbabyawake = new ItemNestBabyAwake().setUnlocalizedName("nestbabyawake").setTextureName("Paleocraft" + ":" + "nest_baby_awake");
	babyfish = new ItemBabyFish().setUnlocalizedName("baby_fish").setTextureName("Paleocraft" + ":" + "baby_fish");
	sleepingfish = new ItemFishSleep().setUnlocalizedName("nest_fish").setTextureName("Paleocraft" + ":" + "nest_fish");
	//Blocks
	seaweed = new Blockseaweed().setBlockName("seaweed"); GameRegistry.registerBlock(seaweed, seaweed.getUnlocalizedName().substring(5));}{
		portaltrigger  = new portalTriggerPaleocraft("PortalTrigger");
		horsetails = new Blockhorsetails().setBlockName("horsetails").setBlockTextureName("Paleocraft" + ":" + "horsetails").setStepSound(Block.soundTypeGrass);;
		cyad = new Blockcyad().setBlockName("cyad").setStepSound(Block.soundTypeGrass);;
		smallcycad = new Blocksmallcycad().setBlockName("small_cycad").setStepSound(Block.soundTypeGrass);;
		portalpaleocraft = new BlockPortalPaleocraft("Portal");}
	//PaleocraftPortal = new BlockPortalPaleocraft(251).setUnlocalizedName("paleocraftportal");
	//treesapling1 = new Blocktree1sapling().setBlockName("treesapling1"); GameRegistry.registerBlock(treesapling1, treesapling1.getUnlocalizedName().substring(5)).setStepSound(Block.soundTypeGrass);
//treesapling2 = new Blocktree2sapling().setBlockName("treesapling2"); GameRegistry.registerBlock(treesapling2, treesapling2.getUnlocalizedName().substring(5));}
//DINOEGG = new BlockDINOEGG(255).setUnlocalizedName("EGG");
   // dirttest = new Blockdirttest(204).setUnlocalizedName("Test1");
   // grasstest = new Blockgrasstest(203).setUnlocalizedName("dirttest");}







//Config gone now
/*	spawnBary = cc.spawnBary;
	spawnCiti = cc.spawnCiti;
	spawnDimorph = cc.spawnDimorph;
	spawnTroo = cc.spawnTroo;
	spawnDromie = cc.spawnDromie;
	*/

	@EventHandler
	public static void load(FMLInitializationEvent evt){
	//	Blockss.loadBlocks();
	//	PaleocraftBiomes.registerWithBiomeDictionary();
	//	PaleocraftDimension.registerWorldProvider();
	//	PaleocraftDimension.registerDimensions();
		WorldTypesPaleocraft.addCustomWorldTypes();
		//EventHelper.registerEvents();
		//Code below checks mod version though it requires the mod version checker I think.
		
		//FMLInterModComms.sendRuntimeMessage(Paleocraft.MODID, "VersionChecker", "addVersionCheck", "www.google.com");
		proxy.registerRenderers();
	}

@EventHandler
public void InitPaleocraft(FMLInitializationEvent event){ //Your main initialization method
	//proxy.initCapes();
//NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

	//Dimension.registerWorldProvider();
	//Dimension.registerDimensions();
	 DimensionManager.registerProviderType(PaleocraftDimensionID.PALEOCRAFTDIMENSION, WorldProviderPaleocraft.class, true);
	//PaleocraftBiomes.registerWithBiomeDictionary();
//	PaleocraftDimension.registerWorldProvider();
//	PaleocraftDimension.registerDimensions();
	 DimensionManager.registerDimension(PaleocraftDimensionID.PALEOCRAFTDIMENSION, PaleocraftDimensionID.PALEOCRAFTDIMENSION);
	 GameRegistry.registerBlock(portalpaleocraft, "PaleocraftPortal");
	 GameRegistry.registerBlock(portaltrigger, "PortalTrigger");
	 GameRegistry.registerBlock(paleocraftbasic, "paleocraftbasic");
	 GameRegistry.registerBlock(horsetails, "horsetails");
	 GameRegistry.registerBlock(cyad, "cyad");
	GameRegistry.registerBlock(smallcycad, "small_cycad");
	
	
	
	//	 GameRegistry.registerBlock(Paleodesert_sand, "Paleodesert_sand");
	 //PaleocraftDimension.registerDimensions();
	 
	//	PaleocraftBiomes.registerWithBiomeDictionary();
	 // GameRegistry.registerBlock(PaleocraftPortal, "PaleocraftPortal");
//DONT NEED GAMEREGISTERY ANYMORE!!!!! well not for blocks.....
//Game registery 
//GameRegistry.addBiome(Paleoplains);
/*GameRegistry.registerBlock(treesapling2, "Tree 2");
GameRegistry.registerBlock(PaleocraftPortal, "Paleocraft Portal");
GameRegistry.registerBlock(portalTrigger, "Fossilmiddle");
GameRegistry.registerWorldGenerator(new WorldGenPaleocraftTree1(false));
GameRegistry.registerWorldGenerator(new WorldGenPaleocraftTree2(false));
GameRegistry.registerWorldGenerator(new WorldGenseaweed());
GameRegistry.registerBlock(treesapling1, "Tree 1");
GameRegistry.registerBlock(seaweed, "Seaweed");
GameRegistry.registerBlock(grasstest, "Grass test");
GameRegistry.registerBlock(paleodesertsand, "PaleoDesert sand");
GameRegistry.registerBlock(dirttest, "Test1");
GameRegistry.registerBlock(paleoplainsdirt, "Paleoplains Dirt");
GameRegistry.registerBlock(paleoplainsgrass, "Paleoplains Grass");
GameRegistry.registerBlock(paleoforestgrass, "Paleoforest Grass");
//GameRegistry.registerBlock(Fossilore, "Fossil");
//GameRegistry.registerBlock(DINOEGG, "Dino Egg");*/
//MainRegistryPaleocraft.RegisterInit();
//Language registery

                //Dimension
  //DimensionManager.registerProviderType(PaleocraftDimension, WorldProviderPaleocraft.class, true);

//DimensionManager.registerDimension(PaleocraftDimension, PaleocraftDimension);
	//GameRegistry.registerWorldGenerator(gen, 1 /*This is the importance at which to generate the contents of the file, leave it at 1*/);
	      GameRegistry.registerWorldGenerator(new WorldGenNest(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenHorseTails(), 0);
		GameRegistry.registerWorldGenerator(ore_gen, 0);
	GameRegistry.registerItem(dinoegg, "dinoegg");
	GameRegistry.registerItem(fossil, "Fossil");
	//GameRegistry.registerItem(fossilcandycane, "Candy Cane Fossil");
	GameRegistry.registerItem(cookeddinoegg, "cookeddinoegg");
	GameRegistry.registerItem(babyseareptile, "babyseareptile");
	GameRegistry.registerItem(nestbaby, "nestbaby");
	GameRegistry.registerItem(nestbabyawake, "nestbabyawake");
	GameRegistry.registerItem(babyseareptileawake, "babyseareptileawake");
	GameRegistry.registerItem(babyfish, "baby_fish");
	GameRegistry.registerItem(sleepingfish, "nest_fish");
	
	GameRegistry.addShapelessRecipe(new ItemStack(babyfish), new Object[] {Items.fish, new ItemStack(sleepingfish)});
	GameRegistry.addShapelessRecipe(new ItemStack(babyseareptileawake), new Object[] {Items.fish, new ItemStack(babyseareptile)});
	
//crafting recipes 
ItemStack stonestack = new ItemStack(Blocks.stone);
ItemStack bonestack = new ItemStack(Items.bone);
ItemStack sandstack = new ItemStack(Blocks.sand);
ItemStack leavesstack = new ItemStack(Blocks.leaves);
GameRegistry.addRecipe(new ItemStack(fossil), "xxx", "xyx", "xxx",
        'x', stonestack, 'y', bonestack);


GameRegistry.addRecipe(new ItemStack(nest), "aaa", "yyy", "xxx",
        'x', sandstack, 'y', leavesstack);



GameRegistry.addSmelting(dinoegg, new ItemStack(cookeddinoegg), 0.35F);
}
}

	
	//MinecraftForge.setBlockHarvestLevel(paleodesertsand, "shovel", 0);}}

