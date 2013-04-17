package bladeking68.minecraft.paleocraftD;



import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class BlockPortalPaleocraft extends BlockPortal
{
       public BlockPortalPaleocraft(int id)
       {
             super(id);
             this.setCreativeTab(CreativeTabs.tabBlock);
       }
      
      // public void registerIcons(IconRegister par1IconRegister)
   // {
     //   this.blockIcon = par1IconRegister.registerIcon(PaleocraftDimension.PaleocraftDimension + "Portal" + this.getUnlocalizedName2());
    //}
      
       public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
       {

       }
      
       public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
       {
             if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
             {
                    if (par5Entity instanceof EntityPlayerMP)
                    {
                           EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
                           if (par5Entity.dimension != PaleocraftDimension.PaleocraftDimension)
                           {
                             thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, PaleocraftDimension.PaleocraftDimension, new TeleporterPaleocraft(thePlayer.mcServer.worldServerForDimension(PaleocraftDimension.PaleocraftDimension)));
                           }
                           else
                           {
                        	   thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterPaleocraft(thePlayer.mcServer.worldServerForDimension(0)));
                           }
                    }
             }
       }
      
       public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == Block.cobblestoneMossy.blockID || par1World.getBlockId(par2 + 1, par3, par4) == Block.cobblestoneMossy.blockID)
        {
            b0 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == Block.cobblestoneMossy.blockID || par1World.getBlockId(par2, par3, par4 + 1) == Block.cobblestoneMossy.blockID)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (par1World.getBlockId(par2 - b0, par3, par4 - b1) == 0)
            {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);

                        if (flag)
                        {
                            if (j1 != Block.cobblestoneMossy.blockID)
                            {
                                return false;
                            }
                        }
                        else if (j1 != 0 && j1 != PaleocraftDimension.portalTrigger.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, PaleocraftDimension.PaleocraftPortal.blockID, 0, 2);
                }
            }

            return true;
        }
    }
      
       public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
       
    }
      
       public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == this.blockID; --i1)
        {
            ;
        }

        if (par1World.getBlockId(par2, i1 - 1, par4) != Block.cobblestoneMossy.blockID)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4 && par1World.getBlockId(par2, i1 + j1, par4) == this.blockID; ++j1)
            {
                ;
            }

            if (j1 == 3 && par1World.getBlockId(par2, i1 + j1, par4) == Block.cobblestoneMossy.blockID)
            {
                boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
                boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

                if (flag && flag1)
                {
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else
                {
                    if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != Block.cobblestoneMossy.blockID || par1World.getBlockId(par2 - b0, par3, par4 - b1) != this.blockID) && (par1World.getBlockId(par2 - b0, par3, par4 - b1) != Block.cobblestoneMossy.blockID || par1World.getBlockId(par2 + b0, par3, par4 + b1) != this.blockID))
                    {
                        par1World.setBlockToAir(par2, par3, par4);
                    }
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
    }

public void registerIcons(IconRegister iconRegister)
{
         blockIcon = iconRegister.registerIcon("Paleocraft Dimension:Portal (2)");
}
}
