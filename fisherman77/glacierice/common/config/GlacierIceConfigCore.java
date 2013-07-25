package fisherman77.glacierice.common.config;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class GlacierIceConfigCore {

//Blocks
public static int blockBlueIceID;
public static int blockGreenIceID;
public static boolean GlacierBiome;

public static void loadConfig(FMLPreInitializationEvent e){
Configuration config = new Configuration(e.getSuggestedConfigurationFile()); //Gets the file

config.load(); //Loads it

//Block ID's
blockBlueIceID = config.getBlock("Blue Glacier Ice ID (Keep less than 256)", 160).getInt(160);
blockGreenIceID = config.getBlock("Green Glacier Ice ID", 1290).getInt(1290);

GlacierBiome = config.get(config.CATEGORY_GENERAL, "Glacier Biome", true).getBoolean(true);


config.save(); //Saves the file

}

}