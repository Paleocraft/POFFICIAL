package fisherman77.zeuscraft.common.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.*;
import fisherman77.zeuscraft.common.Zeuscraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;

public class ItemThunderbolt extends Item {
public ItemThunderbolt(int par1) {
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/Zeuscraft/ZeuscraftItems.png"); //Sets the item texture file
		setItemName("Thunderbolt"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(Zeuscraft.tabZeuscraft); //Tells the game what creative mode tab it goes in
		setIconIndex(2);
}

public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
{
         if((par3EntityPlayer.rayTrace(200, 1.0F) != null)){
                double blockHitX = par3EntityPlayer.rayTrace(200, 1.0F).blockX;
                double blockHitY = par3EntityPlayer.rayTrace(200, 1.0F).blockY;
                double blockHitZ = par3EntityPlayer.rayTrace(200, 1.0F).blockZ;
                double blockHitSide = par3EntityPlayer.rayTrace(200, 1.0F).sideHit;
                par2World.spawnEntityInWorld(new EntityLightningBolt(par2World, blockHitX , blockHitY , blockHitZ ));
        }
  
  
          return par1ItemStack;
}

@SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering

public EnumRarity getRarity(ItemStack par1ItemStack)
{
    return par1ItemStack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
}

}