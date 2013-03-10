package fisherman77.glacierice.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GlacierIceCommonProxy implements IGuiHandler{ //THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!
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
	//Blue Glacier Ice
		GameRegistry.registerBlock(GlacierIce.BlueGlacierIce, "BlueGlacierIce");
		LanguageRegistry.addName(GlacierIce.BlueGlacierIce, "Blue Glacier Ice");
		GameRegistry.addRecipe(new ItemStack(GlacierIce.BlueGlacierIce,1), "XXX","YXY","ZYZ", Character.valueOf('X'), Item.bucketWater, Character.valueOf('Y'), Item.snowball, Character.valueOf('Z'), Block.glass);
	//Green Glacier Ice
		GameRegistry.registerBlock(GlacierIce.GreenGlacierIce, "GreenGlacierIce");
		LanguageRegistry.addName(GlacierIce.GreenGlacierIce, "Green Glacier Ice");
		GameRegistry.addRecipe(new ItemStack(GlacierIce.GreenGlacierIce,1), "MMM","MDM","MMM", Character.valueOf('M'), Item.slimeBall, Character.valueOf('D'), GlacierIce.BlueGlacierIce);
}

public void addNames(){ //For adding Item's ingame names

}
public void addRecipes(){ //For adding your Item's recipes
}
}