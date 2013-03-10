package fisherman77.ancientgreececraft.common;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fisherman77.zeuscraft.common.blocks.ItemBlockMarble;
import fisherman77.zeuscraft.common.cbronze.WorldGeneratorCBronzeOre;
import fisherman77.zeuscraft.common.mobs.EntityCentaur;

public class AncientGreececraftCommonProxy implements IGuiHandler{//THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!
	
	public static String ITEMS_PNG = "/AncientGreececraft/AGItems.png";
    public static String BLOCK_PNG = "/AncientGreececraft/AGBlocks.png";
    
public void registerRenderInformation() //Client side texture registering
{
}
@Override
public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
return null;
}
@Override
public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
return null;
}

public void registerTiles(){ //For registering TileEntities
}

public void registerBlocks(){ //For registering Blocks
	//Altar Block
		//GameRegistry.registerBlock(AncientGreececraft.AltarBlock, "AltarBlock");
		//LanguageRegistry.addName(AncientGreececraft.AltarBlock, "Altar Block");
		
	//Grape Leaves
		//GameRegistry.registerBlock(AncientGreececraft.GrapeLeaves, "GrapeLeaves");
		//LanguageRegistry.addName(AncientGreececraft.GrapeLeaves, "Grape Leaves");
		
	//Grape Log
		//GameRegistry.registerBlock(AncientGreececraft.GrapeLog, "GrapeLog");
		//LanguageRegistry.addName(AncientGreececraft.GrapeLog, "Grape Log");
}

public void registerItems(){ //For adding Item's ingame names
	//Goblet
		//LanguageRegistry.addName(AncientGreececraft.Goblet, "Goblet");
		//GameRegistry.addRecipe(new ItemStack(AncientGreececraft.Goblet, 4), "X X", " X ", "XXX", Character.valueOf('X'), Block.planks);
	//Goblet
		//LanguageRegistry.addName(AncientGreececraft.SpearIron, "Iron Spear");
		//GameRegistry.addRecipe(new ItemStack(AncientGreececraft.SpearIron, 1), "L  ", " X ", "  X", Character.valueOf('X'), Item.stick, Character.valueOf('L'), Item.ingotIron);
		
}

public void worldGenerators(){
	//Celestial Bronze Ore Generation
		//GameRegistry.registerWorldGenerator(new WorldGeneratorCBronzeOre());
}

public void registerRenderers(){
	
}
}