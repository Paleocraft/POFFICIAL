package fisherman77.zeuscraft.common.config;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ZeuscraftConfigCore {

//Items
public static int itemCBronzeIngotID;
public static int itemBowGoldenID;
public static int itemBowSilverID;
public static int itemDragonToothID;
public static int itemGoldenFleeceID;
public static int itemHarpieHeadID;
public static int itemNectarID;
public static int itemPegasusSaddleID;
public static int itemPegasusFeatherID;
public static int itemReedPipesID;
public static int itemThunderboltID;
public static int itemThunderPearlID;
public static int itemTridentID;
public static int itemWaterPearlID;

//Tools
public static int toolCBronzeShovelID;
public static int toolCBronzePickID;
public static int toolCBronzeAxeID;
public static int toolCBronzeSwordID;
public static int toolCBronzeHoeID;

//Blocks
public static int blockCBronzeOreID;
public static int blockCBronzeBlockID;
public static int blockColumnID;
public static int blockMarbleID;
public static int blockMinotaurHeadID;
public static int blockOlympusPortalID;

//General
public static boolean isAwesome;

public static void loadConfig(FMLPreInitializationEvent e){
Configuration config = new Configuration(e.getSuggestedConfigurationFile()); //Gets the file

config.load(); //Loads it

/*Property CBronzeItem; //This is a property, see below
CBronzeItem = config.getItem("Celestial Bronze Ingot ID", 1400); //This gets the property
//CBronzeItem.comment = "The base CBronze item"; //This adds a comment
itemCBronzeIngotID = CBronzeItem.getInt(); //This gets the value*/

//Item ID's (last left off: 1414)
itemCBronzeIngotID = config.getItem("Celestial Bronze Ingot ID", 1401).getInt();
itemBowGoldenID = config.getItem("Golden Bow ID", 1402).getInt();
itemBowSilverID = config.getItem("Silver Bow ID", 1403).getInt();
itemDragonToothID = config.getItem("Dragon Tooth ID", 1404).getInt();
itemGoldenFleeceID = config.getItem("Golden Fleece ID", 1405).getInt();
itemHarpieHeadID = config.getItem("Harpie Head Item ID", 1406).getInt();
itemNectarID = config.getItem("Nectar ID", 1407).getInt();
itemPegasusSaddleID = config.getItem("Pegasus Saddle ID", 1408).getInt();
itemPegasusFeatherID = config.getItem("Pegasus Feather ID", 1410).getInt();
itemReedPipesID = config.getItem("Reed Pipes ID", 1415).getInt();
itemThunderboltID = config.getItem("Thunderbolt ID", 1411).getInt();
itemThunderPearlID = config.getItem("Thunder Pearl ID", 1412).getInt();
itemTridentID = config.getItem("Trident ID", 1413).getInt();
itemWaterPearlID = config.getItem("Water Pearl ID", 1414).getInt();

//Tool ID's
toolCBronzeShovelID = config.getItem("CBronze Shovel", 1450).getInt();
toolCBronzePickID = config.getItem("CBronze Pick", 1451).getInt();
toolCBronzeAxeID = config.getItem("CBronze Axe", 1452).getInt();
toolCBronzeSwordID = config.getItem("CBronze Sword", 1453).getInt();
toolCBronzeHoeID = config.getItem("CBronze Hoe", 1454).getInt();

//Block ID's
blockCBronzeBlockID = config.getBlock("Celestial Bronze Block ID", 1200).getInt();
blockCBronzeOreID = config.getBlock("Celestial Bronze Ore ID", 1201).getInt();
blockColumnID = config.getBlock("Column ID", 1202).getInt();
blockMarbleID = config.getBlock("Marble ID", 1203).getInt();
blockMinotaurHeadID = config.getBlock("Minotaur Head ID", 1204).getInt();
blockOlympusPortalID = config.getBlock("Olympus Portal ID", 1205).getInt();

//General
//isAwesome = config.get(config.CATEGORY_GENERAL, "Is the mod awesome", true).getBoolean(true);

config.save(); //Saves the file

}

}