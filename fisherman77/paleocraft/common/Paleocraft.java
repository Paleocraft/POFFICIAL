package fisherman77.paleocraft.common;

import java.lang.reflect.Type;
import java.util.LinkedList;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import bladeking68.paleocraft.dimension.BiomeGenPaleoSwamp;
import bladeking68.paleocraft.dimension.BiomeGenPaleodesert;
import bladeking68.paleocraft.dimension.BiomeGenPaleoforest;
import bladeking68.paleocraft.dimension.BiomeGenPaleoplains;
import bladeking68.paleocraft.dimension.BiomeGenPaleosea;
import bladeking68.paleocraft.dimension.BlockPortalPaleocraft;
import bladeking68.paleocraft.dimension.Blockdirttest;
import bladeking68.paleocraft.dimension.Blockseaweed;
import bladeking68.paleocraft.dimension.Blocktree1sapling;
import bladeking68.paleocraft.dimension.ItemFossil;
import bladeking68.paleocraft.dimension.MainRegistryPaleocraft;
import bladeking68.paleocraft.dimension.PaleocraftBlocksCreativeTab;
import bladeking68.paleocraft.dimension.PaleocraftEventClass;
import bladeking68.paleocraft.dimension.WorldGenPaleocraftTree1;
import bladeking68.paleocraft.dimension.WorldProviderPaleocraft;
import bladeking68.paleocraft.dimension.portalTriggerPaleocraft;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fisherman77.paleocraft.common.config.PaleocraftConfigCore;
import fisherman77.paleocraft.common.handlers.PaleocraftClientPacketHandler;
import fisherman77.paleocraft.common.handlers.PaleocraftServerPacketHandler;
import fisherman77.paleocraft.common.handlers.PaleocraftSoundHandler;
import fisherman77.paleocraft.common.mobs.EntityBaryonyx;
import fisherman77.paleocraft.common.mobs.EntityCitipati;
import fisherman77.paleocraft.common.mobs.EntityCompy;
import fisherman77.paleocraft.common.mobs.EntityDimorphodon;
import fisherman77.paleocraft.common.mobs.EntityDromaeosaurus;
import fisherman77.paleocraft.common.mobs.EntityMasso;
import fisherman77.paleocraft.common.mobs.EntitySpino;
import fisherman77.paleocraft.common.mobs.EntityTroodon;
import fisherman77.paleocraft.common.mobs.EntityTylo;


@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Paleocraft" }, packetHandler = PaleocraftClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Paleocraft"}, packetHandler = PaleocraftServerPacketHandler.class)) //For serverside packet handling


//==========
//Mod Basics
//==========
@Mod(modid="Paleocraft",name="Paleocraft",version="Dev Build")

public class Paleocraft {
	public static Block PaleocraftPortal;
	
	@Instance("Paleocraft") //The instance, this is very important later on
public static Paleocraft instance = new Paleocraft();

@SidedProxy(clientSide = "fisherman77.paleocraft.client.PaleocraftClientProxy", serverSide = "fisherman77.paleocraft.common.PaleocraftCommonProxy") //Tells Forge the location of your proxies
public static PaleocraftCommonProxy proxy;

boolean spawnBary;
boolean spawnCiti;
boolean spawnDromie;
boolean spawnTroo;
boolean spawnDimorph;
public static BiomeGenBase Paleoplains;
public static BiomeGenBase Paleodesert;
public static BiomeGenBase Paleosea;
public static BiomeGenBase Paleoforest;
public static BiomeGenBase Paleoswamp;
public static CreativeTabs PaleocraftBlocks = new PaleocraftBlocksCreativeTab(CreativeTabs.getNextID(),"Paleocraft");
public static Block portalTrigger;
//public static Block treesapling1;
public static Block seaweed;
public static Block dirttest;
//public static Block portalPlacer2;
public static int PaleocraftDimension = 20;
public static Item fossil;
public static BiomeGenBase TutorialBiomeDeafult; 

@PreInit
public void PreLoad(FMLPreInitializationEvent e)
{
	
	//event bonemeal
	MinecraftForge.EVENT_BUS.register(new PaleocraftEventClass());
	
	
/**
* Registering Paleocraft sounds...
**/
MinecraftForge.EVENT_BUS.register(new PaleocraftSoundHandler());

/**
 * Registering the Core Config class
 */
PaleocraftConfigCore cc = new PaleocraftConfigCore();

PaleocraftConfigCore.loadConfig(e);

/**
 * We've got to put this stuff here in case we reference it in the Init
 */
//Biomes
	Paleoplains = new BiomeGenPaleoplains(56).setColor(2900485).setBiomeName("PaleoPlains").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(0.1F, 0.2F);
	Paleodesert = new BiomeGenPaleodesert(54).setColor(2900485).setBiomeName("Paleodesert").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(0.1F, 0.2F);
	Paleosea = new BiomeGenPaleosea(55).setColor(2900485).setBiomeName("Paleosea").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(-1.0F, 0.4F);
	Paleoforest = new BiomeGenPaleoforest(53).setColor(2900485).setBiomeName("Paleoforest").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(-0.2F, 0.1F);
	Paleoswamp = new BiomeGenPaleoSwamp(52).setColor(522674).setBiomeName("PaleoSwamp").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.1F).setTemperatureRainfall(0.8F, 0.9F);
	fossil = new ItemFossil(253).setUnlocalizedName("Fossil");

//Blocks
	seaweed = new Blockseaweed(254).setUnlocalizedName("seaweed");
	portalTrigger = new portalTriggerPaleocraft(252, 1).setUnlocalizedName("portaltrigger");
	PaleocraftPortal = new BlockPortalPaleocraft(251).setUnlocalizedName("paleocraftportal");
    //treesapling1 = new Blocktree1sapling(253, 0).setUnlocalizedName("tree1");
    dirttest = new Blockdirttest(250).setUnlocalizedName("Test1");
    }


//Config
/*	spawnBary = cc.spawnBary;
	spawnCiti = cc.spawnCiti;
	spawnDimorph = cc.spawnDimorph;
	spawnTroo = cc.spawnTroo;
	spawnDromie = cc.spawnDromie;
	*/



@Init
public void InitPaleocraft(FMLInitializationEvent event){ //Your main initialization method

NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data


//Game registery 
GameRegistry.addBiome(Paleoplains);
GameRegistry.registerBlock(PaleocraftPortal, "Paleocraft Portal");
GameRegistry.registerBlock(portalTrigger, "Fossilmiddle");
//GameRegistry.registerWorldGenerator(new WorldGenPaleocraftTree1(false));
//GameRegistry.registerBlock(treesapling1, "Tree 1");
GameRegistry.registerBlock(seaweed, "Seaweed");
GameRegistry.registerBlock(dirttest, "Test1");
MainRegistryPaleocraft.RegisterInit();
//Language registery
 LanguageRegistry.addName(PaleocraftPortal, "Paleocraft Portal");
                LanguageRegistry.addName(fossil, "Fossil");
                LanguageRegistry.addName(portalTrigger, "Fossilmiddle");
                //LanguageRegistry.addName(treesapling1, "Tree 1");
                LanguageRegistry.addName(seaweed, "Seaweed");
                LanguageRegistry.addName(dirttest, "Test1");
                //Dimension
  DimensionManager.registerProviderType(PaleocraftDimension, WorldProviderPaleocraft.class, true);

DimensionManager.registerDimension(PaleocraftDimension, PaleocraftDimension);


//crafting recipe (Fossil)
ItemStack stonestack = new ItemStack(Block.stone);
ItemStack bonestack = new ItemStack(Item.bone);
GameRegistry.addRecipe(new ItemStack(fossil), "xxx", "xyx", "xxx",
        'x', stonestack, 'y', bonestack);



//MOBS
	proxy.registerRenderers();
		
	registerEntity(EntityBaryonyx.class, "Baryonyx",  0x405135, 0xC4C67D);
	registerEntity(EntityCitipati.class, "Citipati",  0xA67822, 0xA14A5C);
	registerEntity(EntityCompy.class, "Compsognathus", 0x4B4A31, 0xBDBC8B);
	registerEntity(EntityDimorphodon.class, "Dimorphodon", 0xC8C968, 0x6064C4);
	registerEntity(EntityDromaeosaurus.class, "Dromaeosaurus",  0x5C5B5C, 0x551305);
	registerEntity(EntityMasso.class, "Massospondylus", 0x515151, 0x1E0F50);
	registerEntity(EntitySpino.class, "Spinosaurus", 0x0E1640, 0xF78708);
	registerEntity(EntityTroodon.class, "Troodon", 0x5A5A5A, 0xE8E1BF);
	registerEntity(EntityTylo.class, "Tylosaurus", 0x45369F, 0xFFFFFF);

	//Baryonyx
		LanguageRegistry.instance().addStringLocalization("entity.Baryonyx.name", "Baryonyx");
	//Citipati
		LanguageRegistry.instance().addStringLocalization("entity.Citipati.name", "Citipati");
	//Compsognathus
		LanguageRegistry.instance().addStringLocalization("entity.Compsognathus.name", "Compsognathus");
	//Dimorphodon
		LanguageRegistry.instance().addStringLocalization("entity.Dimorphodon.name", "Dimorphodon");
	//Dromaeosaurus
		LanguageRegistry.instance().addStringLocalization("entity.Dromaeosaurus.name", "Dromaeosaurus");
	//Massospondylus
		LanguageRegistry.instance().addStringLocalization("entity.Massospondylus.name", "Massospondylus");
	//Spinosaurus
		LanguageRegistry.instance().addStringLocalization("entity.Spinosaurus.name", "Spinosaurus");
	//Troodon
		LanguageRegistry.instance().addStringLocalization("entity.Troodon.name", "Troodon");
	//Tylosaurus
		LanguageRegistry.instance().addStringLocalization("entity.Tylosaurus.name", "Tylosaurus");
}
	
	public void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
		int id = EntityRegistry.findGlobalUniqueEntityId();
	
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
	}
	
	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
		}
	}
}
