package fisherman77.zeuscraft.common.cbronze;
import fisherman77.zeuscraft.common.Zeuscraft;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;

public class ItemCBronzeSpade extends ItemToolCBronze
{
public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
public ItemCBronzeSpade(int ID, EnumToolMaterial m, int tex, String name)
{
         super(ID, 1, m, blocksEffectiveAgainst);
         setTextureFile("/Zeuscraft/ZeuscraftItems.png");
         this.setCreativeTab(Zeuscraft.tabZeuscraft);
         setIconIndex(tex);
         setItemName(name);
}
public boolean canHarvestBlock(Block par1Block)
{
         return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
}


}