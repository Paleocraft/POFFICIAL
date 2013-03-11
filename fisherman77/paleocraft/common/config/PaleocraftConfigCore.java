package fisherman77.paleocraft.common.config;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class PaleocraftConfigCore {

//Items
public static int itemFossilID;

//Blocks
public static int blockPaleoPortalID;
public static int blockPaleoPortalPlacerID;

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
itemFossilID = config.getItem("Fossil ID", 253).getInt();

//Block ID's
blockPaleoPortalID = config.getBlock("Paleoplains Portal ID", 251).getInt();
blockPaleoPortalPlacerID = config.getBlock("Paleoplains Portal Placer Block ID", 252).getInt();

//General
spawnBary = config.get(config.CATEGORY_GENERAL, "Spawn Baryonyx", false).getBoolean(false);
spawnCiti = config.get(config.CATEGORY_GENERAL, "Spawn Citipati", false).getBoolean(false);
spawnDimorph = config.get(config.CATEGORY_GENERAL, "Spawn Dimorphodon", false).getBoolean(false);
spawnTroo = config.get(config.CATEGORY_GENERAL, "Spawn Troodon", false).getBoolean(false);
spawnDromie = config.get(config.CATEGORY_GENERAL, "Spawn Dromaeosaurus", false).getBoolean(false);


config.save(); //Saves the file

}

}