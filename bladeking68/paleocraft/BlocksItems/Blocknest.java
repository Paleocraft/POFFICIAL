package bladeking68.paleocraft.BlocksItems;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Blocknest extends BlockEndPortalFrame
{
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	 @SideOnly(Side.CLIENT)
	    private IIcon iconnestTop;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconnestside;
	
	public Blocknest()
    {
        super();
        this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
    }
	 @SideOnly(Side.CLIENT)
	 public IIcon getIcon(int par1, int par2)
	 {
	 return par1 == 1 ? this.iconnestTop : (par1 == 0 ? this.iconnestside : this.blockIcon);
	 }
	   
	 @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister p_149651_1_)
	    {
		 this.blockIcon = p_149651_1_.registerIcon(Paleocraft.MODID + ":" + "nest_side");
		 this.iconnestTop = p_149651_1_.registerIcon(Paleocraft.MODID + ":" + "nest_top");
		 this.iconnestside = p_149651_1_.registerIcon(Paleocraft.MODID + ":" + "nest_side");
	    }

	
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    /**
	     * The type of render function that is called for this block
	     */
	    public int getRenderType()
	    {
	        return 26;
	    }

	    /**
	     * Sets the block's bounds for rendering it as an item
	     */
	    public void setBlockBoundsForItemRender()
	    {
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
	    }
	 //   @Override
	/*	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9) {
		{
		if(!world.isRemote)//world.isRemote == false - has to be false otherwise you do it twice once for server and once for client
		{
		ItemStack myItemStack = new ItemStack(Paleocraft.dinoegg, 1);
		EntityItem entityitem = new EntityItem(world, x, y, z, myItemStack);
		entityitem.delayBeforeCanPickup = 0;
		world.spawnEntityInWorld(entityitem);
		}
		return false;
		}
		
		}*/
	  
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int X, float Y, float Z, float f)
		{
	    		if  (!world.isRemote)
	    	if  (  entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().getItem() == Paleocraft.babyseareptile)
	    		
	    	{--entityplayer.getCurrentEquippedItem().stackSize;
	    		
	    		EntityItem entityitem = new EntityItem(world, x, y, z, new ItemStack(Paleocraft.babyseareptileawake, 1));
								entityitem.delayBeforeCanPickup = 5;
								world.spawnEntityInWorld(entityitem);
								
					}
					return true;
		}

}
