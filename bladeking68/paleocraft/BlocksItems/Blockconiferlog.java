package bladeking68.paleocraft.BlocksItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class Blockconiferlog extends BlockLog{
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	 @SideOnly(Side.CLIENT)
	    private IIcon iconnestTop;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconnestside;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconnestbottom;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconnestnull;
	  public Blockconiferlog()
	    {
	        super();
	        this.setCreativeTab(fisherman77.paleocraft.common.Paleocraft.PaleocraftBlocks);
	    }

	

	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister p_149651_1_)
	    {
	        this.blockIcon = p_149651_1_.registerIcon(Paleocraft.MODID + ":" + "log_conifer");
	       // this.field_150039_M = p_149651_1_.registerIcon(this.getTextureName() + "_inner");
	        this.iconnestTop = p_149651_1_.registerIcon(Paleocraft.MODID + ":" + "log_conifer_top");
	        this.iconnestbottom = p_149651_1_.registerIcon(Paleocraft.MODID + ":" + "log_conifer_top");
	    }

}
