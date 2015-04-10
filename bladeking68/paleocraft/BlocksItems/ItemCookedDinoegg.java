package bladeking68.paleocraft.BlocksItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukebox;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
//import net.minecraft.client.renderer.texture.IconRegister;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Facing;
import net.minecraft.util.ChatComponentTranslation;
//import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;
import fisherman77.paleocraft.common.mobs.EntityDromaeosaurus;
import fisherman77.paleocraft.common.mobs.EntityTroodon;

public class ItemCookedDinoegg extends ItemFood
{
       private Object iconIndex;

       public ItemCookedDinoegg()
       {
    	   super(2, 2.0F, false);  
            this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
       }
      
    public boolean onItemUse(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9, Block var1)
    {
    	if(!world.isRemote)
    	
    		 if(var1 == Paleocraft.nest)
    		 {
    			 ItemStack myItemStack = new ItemStack(Paleocraft.nestbaby, 1);
    				EntityItem entityitem = new EntityItem(world, x, y, z, myItemStack);
    				entityitem.delayBeforeCanPickup = 0;
    				world.spawnEntityInWorld(entityitem); 
    		 }
    	
  return false;
    	}
    }
    
    
    
    
    
    
    

