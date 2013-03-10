
package fisherman77.zeuscraft.common; //The package your mod is in

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
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
import fisherman77.zeuscraft.client.ZeuscraftClientProxy;
import fisherman77.zeuscraft.common.blocks.BlockCBronzeBlock;
import fisherman77.zeuscraft.common.blocks.BlockColumn;
import fisherman77.zeuscraft.common.blocks.BlockMarble;
import fisherman77.zeuscraft.common.blocks.BlockMinotaurHead;
import fisherman77.zeuscraft.common.blocks.BlockOlympusPortal;
import fisherman77.zeuscraft.common.cbronze.BlockCBronzeOre;
import fisherman77.zeuscraft.common.cbronze.ItemCBronzeAxe;
import fisherman77.zeuscraft.common.cbronze.ItemCBronzeHoe;
import fisherman77.zeuscraft.common.cbronze.ItemCBronzeIngot;
import fisherman77.zeuscraft.common.cbronze.ItemCBronzePickaxe;
import fisherman77.zeuscraft.common.cbronze.ItemCBronzeSpade;
import fisherman77.zeuscraft.common.cbronze.ItemCBronzeSword;
import fisherman77.zeuscraft.common.config.ZeuscraftBlocksConfig;
import fisherman77.zeuscraft.common.config.ZeuscraftConfigCore;
import fisherman77.zeuscraft.common.config.ZeuscraftConfigSettings;
import fisherman77.zeuscraft.common.config.ZeuscraftItemsConfig;
import fisherman77.zeuscraft.common.handlers.*;
import fisherman77.zeuscraft.common.items.ItemBowGolden;
import fisherman77.zeuscraft.common.items.ItemBowSilver;
import fisherman77.zeuscraft.common.items.ItemDragonTooth;
import fisherman77.zeuscraft.common.items.ItemGoldenFleece;
import fisherman77.zeuscraft.common.items.ItemHarpieHead;
import fisherman77.zeuscraft.common.items.ItemNectar;
import fisherman77.zeuscraft.common.items.ItemPegasusFeather;
import fisherman77.zeuscraft.common.items.ItemPegasusSaddle;
import fisherman77.zeuscraft.common.items.ItemReedPipes;
import fisherman77.zeuscraft.common.items.ItemThunderPearl;
import fisherman77.zeuscraft.common.items.ItemThunderbolt;
import fisherman77.zeuscraft.common.items.ItemTrident;
import fisherman77.zeuscraft.common.items.ItemWaterPearl;
import fisherman77.zeuscraft.common.mobs.EntityCentaur;
import fisherman77.zeuscraft.common.mobs.EntityCyclops;
import fisherman77.zeuscraft.common.mobs.EntityHarpie;
import fisherman77.zeuscraft.common.mobs.EntityHostileCentaur;
import fisherman77.zeuscraft.common.mobs.EntityWiseCentaur;
import fisherman77.zeuscraft.common.olympus.WorldProviderOlympus;
import fisherman77.zeuscraft.common.tabs.TabZeuscraft;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Zeuscraft" }, packetHandler = ZeuscraftClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ZeuscraftServerPacketHandler.class)) //For serverside packet handling


//MOD BASICS
@Mod(modid="Zeuscraft",name="Zeuscraft",version="OLYMPUS 4.0")

public class Zeuscraft {

@Instance("Zeuscraft") //The instance, this is very important later on
public static Zeuscraft instance = new Zeuscraft();

@SidedProxy(clientSide = "fisherman77.zeuscraft.client.ZeuscraftClientProxy", serverSide = "fisherman77.zeuscraft.common.ZeuscraftCommonProxy") //Tells Forge the location of your proxies
public static ZeuscraftCommonProxy proxy;



//ENUMS (MATERIALS)
	public static EnumToolMaterial celestialBronze = EnumHelper.addToolMaterial("CelestialBronze", 2, 250, 8.0F, 4, 30);
	
//ZEUSCRAFT CREATIVE TAB
	public static CreativeTabs tabZeuscraft = new TabZeuscraft(CreativeTabs.getNextID(),"Zeuscraft"); //Our custom creative tab's object

//BLOCKS (LIST)
	public static Block CBronzeBlock;
	public static int CBronzeBlockID;
	public static Block CBronzeOre;
	public static int CBronzeOreID;
	public static Block Column;
	public static int ColumnID;
	public static Block Marble;
	public static int MarbleID;
	public static Block MinotaurHead;
	public static int MinotaurHeadID;
	public static Block OlympusPortal;
	public static int OlympusPortalID;
	
	//ITEMS (LIST)
	public static Item BowGolden;
	public static Item BowSilver;
	public static Item CBronzeAxe;
	public static Item CBronzeHoe;
	public static Item CBronzeIngot;
	public static Item CBronzePickaxe;
	public static Item CBronzeSpade;
	public static Item CBronzeSword;
	public static Item DragonTooth;
	public static Item GoldenFleece;
	public static Item HarpieHead;
	public static Item Nectar;
	public static Item PegasusSaddle;
	public static Item PegasusFeather;
	public static Item ReedPipes;
	public static Item Thunderbolt;
	public static Item ThunderPearl;
	public static Item Trident;
	public static Item WaterPearl;
	
//DIMENSION (LIST)
	public static int Olympus = 21;
	
//ACHIEVEMENTS
	public static AchievementPage ZeuscraftPage;
	public static Achievement BirdHunting;
	public static Achievement Thunderstruck;
	

	
	@PreInit
	public void PreInit(FMLPreInitializationEvent e)
	{
		ZeuscraftConfigCore cc = new ZeuscraftConfigCore();

		ZeuscraftConfigCore.loadConfig(e);
		
		//BLOCKS
				CBronzeOre = (new BlockCBronzeOre(cc.blockCBronzeOreID).setBlockName("CBronzeOre"));
				CBronzeBlock = (new BlockCBronzeBlock(cc.blockCBronzeBlockID).setBlockName("CBronzeBlock"));
				Column = (new BlockColumn(cc.blockColumnID).setBlockName("Column"));
				Marble = (new BlockMarble(cc.blockMarbleID).setBlockName("Marble"));
				MinotaurHead = (new BlockMinotaurHead(cc.blockMinotaurHeadID).setBlockName("MinotaurHead"));
				OlympusPortal = (new BlockOlympusPortal(cc.blockOlympusPortalID, 1).setBlockName("OlympusPortal"));
				
		//ITEMS
				BowGolden = new ItemBowGolden(cc.itemBowGoldenID);
				BowSilver = new ItemBowSilver(cc.itemBowSilverID);
				CBronzeAxe = new ItemCBronzeAxe(cc.toolCBronzeAxeID, celestialBronze, 13, "CBronzeAxe");
				CBronzeHoe = new ItemCBronzeHoe(cc.toolCBronzeHoeID, celestialBronze, 14, "CBronzeHoe");
				CBronzeIngot = new ItemCBronzeIngot(cc.itemCBronzeIngotID);
				CBronzePickaxe = new ItemCBronzePickaxe(cc.toolCBronzePickID, celestialBronze, 10, "CBronzePickaxe");
				CBronzeSpade = new ItemCBronzeSpade(cc.toolCBronzeShovelID, celestialBronze, 11, "CBronzeSpade");
				CBronzeSword = new ItemCBronzeSword(cc.toolCBronzeSwordID, celestialBronze, 12, "CBronzeSword");
				DragonTooth = new ItemDragonTooth(cc.itemDragonToothID);
				GoldenFleece = new ItemGoldenFleece(cc.itemGoldenFleeceID);
				HarpieHead = new ItemHarpieHead(cc.itemHarpieHeadID);
				Nectar = new ItemNectar(cc.itemNectarID);
				PegasusSaddle = new ItemPegasusSaddle(cc.itemPegasusSaddleID);
				PegasusFeather = new ItemPegasusFeather(cc.itemPegasusFeatherID);
				ReedPipes = new ItemReedPipes(cc.itemReedPipesID);
				Thunderbolt = new ItemThunderbolt(cc.itemThunderboltID);
				ThunderPearl = new ItemThunderPearl(cc.itemThunderPearlID);
				Trident = new ItemTrident(cc.itemTridentID);
				WaterPearl = new ItemWaterPearl(cc.itemWaterPearlID);
	}

	@Init
	public void InitZeuscraft(FMLInitializationEvent event){ //Your main initialization method
		
	//BLOCKS
		proxy.registerBlocks(); //Calls the registerBlocks method

		
	//ACHIEVEMENTS
		//ZeuscraftPage = new AchievementPage("Zeuscraft Achievements", BirdHunting, Thunderstruck);
		//AchievementPage.registerAchievementPage(ZeuscraftPage);
		//Thunderstruck = new Achievement(30, "ThunderstruckAchievement", 0, 0, Zeuscraft.Thunderbolt, null).registerAchievement();
		//this.addAchievementName("ThunderstruckAchievement", "Thunderstruck");
		//this.addAchievementDesc("TutorialAchievement", "ACDC");
		//BirdHunting = new Achievement(31, "BirdHuntingAchievement", 2, 0, Zeuscraft.HarpieHead, Thunderstruck).registerAchievement();
		//this.addAchievementName("BirdHuntingAchievement", "Bird Hunting");
		//this.addAchievementDesc("BirdHuntingAchievement", "Bang.");
		
		
	//MULTIPLAYER ABILITY
		NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

	//ITEMS (METHOD)
		proxy.registerItems();
	
	//WORLD GENERATION (METHOD)
		proxy.worldGenerators();
	
	//MOBS
		proxy.registerRenderers();
		
	//DIMENSION
		DimensionManager.registerProviderType(Olympus, WorldProviderOlympus.class, false);
		DimensionManager.registerDimension(Olympus, Olympus);
		
		//Centaur
			EntityRegistry.registerGlobalEntityID(EntityCentaur.class, "Centaur", EntityRegistry.findGlobalUniqueEntityId(), 0x7B6343, 0xE5E5E5);
			LanguageRegistry.instance().addStringLocalization("entity.Centaur.name", "Centaur");
			EntityRegistry.addSpawn(EntityCentaur.class, 10, 3, 10, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.desert, BiomeGenBase.forest);
			
		//Cyclops
			EntityRegistry.registerGlobalEntityID(EntityCyclops.class, "Cyclops", EntityRegistry.findGlobalUniqueEntityId(), 0xF9C693, 0xF2F0F0);
			LanguageRegistry.instance().addStringLocalization("entity.Cyclops.name", "Cyclops");
			EntityRegistry.addSpawn(EntityCyclops.class, 6, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains);
			
		//Harpie
			EntityRegistry.registerGlobalEntityID(EntityHarpie.class, "Harpie", EntityRegistry.findGlobalUniqueEntityId(), 0x7B6343, 0x9D150E);
			LanguageRegistry.instance().addStringLocalization("entity.Harpie.name", "Harpie");
			EntityRegistry.addSpawn(EntityHarpie.class, 4, 3, 4, EnumCreatureType.creature, BiomeGenBase.hell);
			
		//Hostile Centaur
			EntityRegistry.registerGlobalEntityID(EntityHostileCentaur.class, "HostileCentaur", EntityRegistry.findGlobalUniqueEntityId(), 0x7B6343, 0xFF0000);
			LanguageRegistry.instance().addStringLocalization("entity.HostileCentaur.name", "Hostile Centaur");
			EntityRegistry.addSpawn(EntityHostileCentaur.class, 4, 2, 3, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.taiga);
			
		//Wise Centaur
			EntityRegistry.registerGlobalEntityID(EntityWiseCentaur.class, "WiseCentaur", EntityRegistry.findGlobalUniqueEntityId());
			LanguageRegistry.instance().addStringLocalization("entity.WiseCentaur.name", "Wise Centaur");
			EntityRegistry.addSpawn(EntityWiseCentaur.class, 2, 1, 1, EnumCreatureType.creature, BiomeGenBase.taigaHills);

}
	
	private void addAchievementName(String ach, String name)
	{
	LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}

	private void addAchievementDesc(String ach, String desc)
	{
	LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}
}