package fisherman77.paleocraft.common;

import bladeking68.paleocraft.dimension.BiomeGenPaleoplains;
import bladeking68.paleocraft.dimension.BlockPortalPaleocraft;
import bladeking68.paleocraft.dimension.ItemFossil;
import bladeking68.paleocraft.dimension.PaleocraftBlocksCreativeTab;
import bladeking68.paleocraft.dimension.WorldProviderPaleocraft;
import bladeking68.paleocraft.dimension.portalTriggerPaleocraft;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import fisherman77.paleocraft.client.PaleocraftClientProxy;
import fisherman77.paleocraft.common.config.PaleocraftConfigCore;
import fisherman77.paleocraft.common.handlers.*;
import fisherman77.paleocraft.common.mobs.EntityBaryonyx;
import fisherman77.paleocraft.common.mobs.EntityCitipati;
import fisherman77.paleocraft.common.mobs.EntityDimorphodon;
import fisherman77.paleocraft.common.mobs.EntityDromaeosaurus;
import fisherman77.paleocraft.common.mobs.EntityTroodon;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Paleocraft" }, packetHandler = PaleocraftClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Paleocraft"}, packetHandler = PaleocraftServerPacketHandler.class)) //For serverside packet handling


//==========
//Mod Basics
//==========
@Mod(modid="Paleocraft",name="Paleocraft",version="Release")

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
public static CreativeTabs PaleocraftBlocks = new PaleocraftBlocksCreativeTab(CreativeTabs.getNextID(),"Paleocraft");
public static Block portalTrigger;
//public static Block portalPlacer2;
public static int PaleocraftDimension = 20;
public static Item fossil;

@PreInit
public void PreLoad(FMLPreInitializationEvent e)
{
	
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
//Biome
	//Paleoplains
	Paleoplains = new BiomeGenPaleoplains(53).setColor(2900485).setBiomeName("PaleoPlains").setTemperatureRainfall(1F, 0.5F).setMinMaxHeight(0.1F, 0.2F);

//Items
	fossil = new ItemFossil(cc.itemFossilID).setUnlocalizedName("Fossil");

//Blocks
	portalTrigger = new portalTriggerPaleocraft(cc.blockPaleoPortalPlacerID, 1).setUnlocalizedName("portaltrigger");
	PaleocraftPortal = new BlockPortalPaleocraft(cc.blockPaleoPortalID).setUnlocalizedName("paleocraftportal");

//Config
	spawnBary = cc.spawnBary;
	spawnCiti = cc.spawnCiti;
	spawnDimorph = cc.spawnDimorph;
	spawnTroo = cc.spawnTroo;
	spawnDromie = cc.spawnDromie;
	

}

@Init
public void InitPaleocraft(FMLInitializationEvent event){ //Your main initialization method

NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data


//Game registery 
GameRegistry.addBiome(Paleoplains);
GameRegistry.registerBlock(PaleocraftPortal, "Paleocraft Portal");
GameRegistry.registerBlock(portalTrigger, "Fossilmiddle");


//Language registery
 LanguageRegistry.addName(PaleocraftPortal, "Paleocraft Portal");
                LanguageRegistry.addName(fossil, "Fossil");
                LanguageRegistry.addName(portalTrigger, "Fossilmiddle");

//Dimension
DimensionManager.registerProviderType(PaleocraftDimension, WorldProviderPaleocraft.class, false);

DimensionManager.registerDimension(PaleocraftDimension, PaleocraftDimension);


//crafting recipe (Fossil)
ItemStack stonestack = new ItemStack(Block.stone);
ItemStack bonestack = new ItemStack(Item.bone);
GameRegistry.addRecipe(new ItemStack(fossil), "xxx", "xyx", "xxx",
        'x', stonestack, 'y', bonestack);



//MOBS
		proxy.registerRenderers();
	//Baryonyx
		EntityRegistry.registerGlobalEntityID(EntityBaryonyx.class, "Baryonyx", EntityRegistry.findGlobalUniqueEntityId(), 0x405135, 0xC4C67D);
		LanguageRegistry.instance().addStringLocalization("entity.Baryonyx.name", "Baryonyx");
		if(spawnBary == true){
			EntityRegistry.addSpawn(EntityBaryonyx.class, 4, 1, 1, EnumCreatureType.creature, Paleocraft.Paleoplains);
		//	EntityRegistry.addSpawn(entityName, weightedProb, min, max, spawnList, biomes)
		}
	//Citipati
		EntityRegistry.registerGlobalEntityID(EntityCitipati.class, "Citipati", EntityRegistry.findGlobalUniqueEntityId(), 0xA67822, 0xA14A5C);
		LanguageRegistry.instance().addStringLocalization("entity.Citipati.name", "Citipati");
		if(spawnCiti == true){
			EntityRegistry.addSpawn(EntityCitipati.class, 7, 2, 5, EnumCreatureType.creature, Paleocraft.Paleoplains);
		}
	//Dromaeosaurus
		EntityRegistry.registerGlobalEntityID(EntityDromaeosaurus.class, "Dromaeosaurus", EntityRegistry.findGlobalUniqueEntityId(), 0x5C5B5C, 0x551305);
		LanguageRegistry.instance().addStringLocalization("entity.Dromaeosaurus.name", "Dromaeosaurus");
		if(spawnDromie == true){
			EntityRegistry.addSpawn(EntityDromaeosaurus.class, 7, 3, 6, EnumCreatureType.creature, Paleocraft.Paleoplains);
		}
	//Troodon
		EntityRegistry.registerGlobalEntityID(EntityTroodon.class, "Troodon", EntityRegistry.findGlobalUniqueEntityId(), 0x5A5A5A, 0xE8E1BF);
		LanguageRegistry.instance().addStringLocalization("entity.Troodon.name", "Troodon");
		if(spawnTroo == true){
			EntityRegistry.addSpawn(EntityTroodon.class, 3, 1, 3, EnumCreatureType.monster, Paleocraft.Paleoplains);
		}
	//Dimorphodon
		EntityRegistry.registerGlobalEntityID(EntityDimorphodon.class, "Dimorphodon", EntityRegistry.findGlobalUniqueEntityId(), 0xC8C968, 0x6064C4);
		LanguageRegistry.instance().addStringLocalization("entity.Dimorphodon.name", "Dimorphodon");
		//if(spawnDimorph == true){
		//	EntityRegistry.addSpawn(EntityDimorphodon.class, 8, 3, 10, EnumCreatureType.creature, Paleocraft.Paleoplains);
		//}
	}
}
