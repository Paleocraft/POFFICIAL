package bladeking68.paleocraft.BlocksItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.mobs.EntityTroodon;

public class ItemTroodonEgg extends Item
{
       private Object iconIndex;

       public ItemTroodonEgg(int id)
       {
             super(id);
             //this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
       }
      
       public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
       {
       if(!par2World.isRemote)
       if(par1ItemStack.getItemDamage() <= 0)
       {
       par1ItemStack.stackSize = 0;
       {

       EntityTroodon entitytroodon = new EntityTroodon (par2World);
       entitytroodon.setPosition(par3EntityPlayer.posX, par3EntityPlayer.posY + 1, par3EntityPlayer.posZ);
       par2World.spawnEntityInWorld(entitytroodon);
       }
       return par1ItemStack;
       }
       return par1ItemStack;
       }
       @Override
       @SideOnly(Side.CLIENT)
       public void registerIcons(IconRegister iconRegister)
       {
       itemIcon = iconRegister.registerIcon("paleocraft:" + "DinoEgg");
       }
}
