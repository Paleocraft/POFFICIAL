/*package fisherman77.paleocraft.common.config;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class PaleocraftConfigCore {

//Items
public static int itemFossilID;
public static int itemTroodonEggID;
public static int itemDromaeosaurusEggID;
//Biomes
public static int biomepaleoplainsID;
public static int biomepaleoforestID;
public static int biomepaleodesertID;
public static int biomepaleoswampID;
public static int biomepaleoseaID;
public static int biomepaleotempforestID;
//Blocks
public static int blockPaleoPortalID;
public static int blockPaleoPortalPlacerID;
public static int blockSeaweedID;
public static int blockPaleoDesertSandID;
public static int blockPaleoPlainsDirtID;
public static int blockPaleoPlainsGrassID;
public static int blockPaleoForestGrassID;
public static int blockfossiloreID;
public static int blockportaltriggerID;
public static int blocktreesapling1ID;
public static int blocktreesapling2ID;
//General
public static boolean spawnBary;
public static boolean spawnCiti;
public static boolean spawnDimorph;
public static boolean spawnTroo;
public static boolean spawnDromie;

public static void loadConfig(FMLPreInitializationEvent e){
Configuration config = new Configuration(e.getSuggestedConfigurationFile()); //Gets the file

config.load(); //Loads it

/*Property CBronzeItem; //This is a property, see below
CBronzeItem = config.getItem("Celestial Bronze Ingot ID", 1400); //This gets the property
//CBronzeItem.comment = "The base CBronze item"; //This adds a comment
itemCBronzeIngotID = CBronzeItem.getInt(); //This gets the value*/

//Item ID's (last left off: 1414)
/*itemFossilID = config.getItem("Fossil ID", 2024).getInt(2024);
itemTroodonEggID = config.getItem("WIP ITEM 1", 2025).getInt(2025);
itemDromaeosaurusEggID = config.getItem("WIP ITEM 2", 2026).getInt(2026);
//Biomes
//biomepaleoplainsID = config.("Paleoplains Portal ID", 1251).getInt(1251);
biomepaleoplainsID = config.get("Biome", "PaleoPlains ID", 56).getInt();
biomepaleoforestID = config.get("Biome", "PaleoForest ID", 53).getInt();
biomepaleodesertID = config.get("Biome", "PaleoDesert ID", 54).getInt();
biomepaleoswampID = config.get("Biome", "PaleoSwamp ID", 52).getInt();
biomepaleoseaID = config.get("Biome", "PaleoSea ID", 55).getInt();
biomepaleotempforestID = config.get("Biome", "PaleoTempForest (WIP) ID", 57).getInt();
//Block ID's
blockPaleoPortalID = config.getBlock("Paleoplains Portal ID", 1251).getInt(1251);
blockPaleoPortalPlacerID = config.getBlock("Paleoplains Portal Placer Block ID", 1252).getInt(1252);
blockSeaweedID = config.getBlock("Seaweed ID", 1254).getInt(1254);
blockPaleoDesertSandID = config.getBlock("PaleoDesert Sand ID", 205).getInt(205);
blockPaleoPlainsDirtID = config.getBlock("PaleoPlains Dirt ID", 206).getInt(206);
blockPaleoPlainsGrassID = config.getBlock("PaleoPlains Grass ID", 207).getInt(207);
blockPaleoForestGrassID = config.getBlock("PaleoForest Grass ID", 208).getInt(208);
blockfossiloreID = config.getBlock("Fossil Ore (WIP) ID", 209).getInt(209);
blockportaltriggerID = config.getBlock("Trigger Block for portal ID", 210).getInt(210);
blocktreesapling1ID = config.getBlock("Paleoforest Tree Sapling ID", 211).getInt(211);
blocktreesapling2ID = config.getBlock("WIP Tree Sapling ID", 212).getInt(212);
//General
spawnBary = config.get(config.CATEGORY_GENERAL, "Spawn Baryonyx", false).getBoolean(false);
spawnCiti = config.get(config.CATEGORY_GENERAL, "Spawn Citipati", false).getBoolean(false);
//spawnDimorph = config.get(config.CATEGORY_GENERAL, "Spawn Dimorphodon", false).getBoolean(false);
spawnTroo = config.get(config.CATEGORY_GENERAL, "Spawn Troodon", false).getBoolean(false);
spawnDromie = config.get(config.CATEGORY_GENERAL, "Spawn Dromaeosaurus", false).getBoolean(false);


config.save(); //Saves the file

}

}
*/
