package fisherman77.paleocraft.common.mobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.resources.ResourceLocation;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class RenderBaryonyx extends RenderLiving
{
    private static final ResourceLocation field_110833_a = new ResourceLocation("Paleocraft/Mobs/Bary/Bary.png");

    public RenderBaryonyx(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation func_110832_a(EntityBaryonyx par1EntityBaryonyx)
    {
        return field_110833_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110832_a((EntityBaryonyx)par1Entity);
    }
}
