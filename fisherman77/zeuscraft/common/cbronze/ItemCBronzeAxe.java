package fisherman77.zeuscraft.common.cbronze;
import fisherman77.zeuscraft.common.Zeuscraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemCBronzeAxe extends ItemToolCBronze
{
public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};
public ItemCBronzeAxe(int ID, EnumToolMaterial m, int tex, String name)
{
         super(ID, 1, m, blocksEffectiveAgainst);
         this.setCreativeTab(Zeuscraft.tabZeuscraft);
         setTextureFile("/Zeuscraft/ZeuscraftItems.png");
         setIconIndex(tex);
         setItemName(name);
}

public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
{
         return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
}
}