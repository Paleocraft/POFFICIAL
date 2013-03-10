package fisherman77.zeuscraft.common.config;
/**
 * @author Ferrokev
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
public class ZeuscraftBlocksConfig
{

	public static Block BlockOre;
	public static Block BlockOreBlock;
	public static Block BlockEssence;
	public static Block BlockCrusher;
	public static Block BlockCompressor;
	public static Block BlockBlastFurnace;

	public static GameRegistry gr;
	public static LanguageRegistry lg;

	public static final String CATEGORY_RARITY = "sets rarity of ores, the higher the number the more common";
	public static final String CATEGORY_DURATIONS = "sets the duration of fuel and how long it takes to smelt";
}