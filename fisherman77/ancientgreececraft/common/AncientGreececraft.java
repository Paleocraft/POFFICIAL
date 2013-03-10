
package fisherman77.ancientgreececraft.common; //The package your mod is in

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
import fisherman77.ancientgreececraft.common.config.AncientGreececraftConfigCore;
import fisherman77.ancientgreececraft.common.mobs.EntityAGCyclops;
import fisherman77.ancientgreececraft.common.mobs.EntityAGMinotaur;
import fisherman77.ancientgreececraft.common.mobs.EntityAGSatyr;
import fisherman77.ancientgreececraft.common.tabs.TabAncientGreecraft;
import fisherman77.ancientgreececraft.handlers.AncientGreececraftServerPacketHandler;
import fisherman77.ancientgreececraft.handlers.AncientGreececraftClientPacketHandler;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"AG" }, packetHandler = AncientGreececraftClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = AncientGreececraftServerPacketHandler.class)) //For serverside packet handling


//MOD BASICS
@Mod(modid="AncientGreececraft",name="Ancient Greececraft",version="0.61")

public class AncientGreececraft {

@Instance("AncientGreeceraft") //The instance, this is very important later on
public static AncientGreececraft instance = new AncientGreececraft();

@SidedProxy(clientSide = "fisherman77.ancientgreececraft.client.AncientGreececraftClientProxy", serverSide = "fisherman77.ancientgreececraft.common.AncientGreececraftCommonProxy") //Tells Forge the location of your proxies
public static AncientGreececraftCommonProxy proxy;

//ENUMS
	public static EnumToolMaterial AGcelestialBronze = EnumHelper.addToolMaterial("AGCelestialBronze", 2, 250, 8.0F, 4, 30);

//ZEUSCRAFT CREATIVE TAB
	public static CreativeTabs tabAncientGreececraft = new TabAncientGreecraft(CreativeTabs.getNextID(),"Ancient Greececraft"); //Our custom creative tab's object

//BLOCKS (LIST)
	public static Block GrapeLog;
	public static Block GrapeLeaves;
	public static Block AltarBlock;
	
	//ITEMS (LIST)
	public static Item Grapes;
	public static Item Goblet;
	public static Item SpearIron;
	public static Item Wine;
	
//ACHIEVEMENTS
	public static AchievementPage ZeuscraftPage;
	public static Achievement BirdHunting;
	public static Achievement Thunderstruck;
	

	
	@PreInit
	public void PreInit(FMLPreInitializationEvent e)
	{
		AncientGreececraftConfigCore cc = new AncientGreececraftConfigCore();

		AncientGreececraftConfigCore.loadConfig(e);
		
		//BLOCKS
		//		AltarBlock = (new BlockAltar(cc.blockAltarID).setBlockName("CBronzeOre"));
		//		GrapeLeaves = (new BlockGrapeLeaves(cc.GrapeLeavesID).setBlockName("CBronzeBlock"));
		//		GrapeLog = (new BlockGrapeLog(cc.blockGrapeLogID).setBlockName("Column"));
				
		//ITEMS
		//		Goblet = new ItemGoblet(cc.itemGobletID);
		//		Grapes = new ItemGrapes(cc.itemGrapesID);
		//		SpearIron = new ItemSpearIron(cc.itemSpearIronID);
		//		Wine = new ItemWine(cc.itemWineID);
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
		
		//Ancient Greececraft Satyr
			//EntityRegistry.registerGlobalEntityID(EntityAGSatyr.class, "AGSatyr", EntityRegistry.findGlobalUniqueEntityId(), 0x7B6343, 0xE5E5E5);
			//LanguageRegistry.instance().addStringLocalization("entity.AGSatyr.name", "Satyr (Ancient Greececraft)");
			//EntityRegistry.addSpawn(EntityAGSatyr.class, 7, 1, 3, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.forestHills);
			
		//Ancient Greececraft Cyclops
			//EntityRegistry.registerGlobalEntityID(EntityAGCyclops.class, "AGCyclops", EntityRegistry.findGlobalUniqueEntityId(), 0xF9C693, 0xF2F0F0);
			//LanguageRegistry.instance().addStringLocalization("entity.AGCyclops.name", "Cyclops (Ancient Greececraft)");
			//EntityRegistry.addSpawn(EntityAGCyclops.class, 6, 1, 1, EnumCreatureType.creature, BiomeGenBase.beach);
			
		//Ancient Greececraft Minotaur
			//EntityRegistry.registerGlobalEntityID(EntityAGMinotaur.class, "AGMinotaur", EntityRegistry.findGlobalUniqueEntityId(), 0xF9C693, 0xF2F0F0);
			//LanguageRegistry.instance().addStringLocalization("entity.AGMinotaur.name", "Minotaur (Ancient Greececraft)");
			//EntityRegistry.addSpawn(EntityAGMinotaur.class, 2, 1, 1, EnumCreatureType.monster);
			//EntityRegistry.addSpawn(entityName, weightedProb, min, max, spawnList, biomes)

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