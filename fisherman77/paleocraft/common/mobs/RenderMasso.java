package fisherman77.paleocraft.common.mobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderMasso extends RenderLiving
{
	private static final ResourceLocation skin = new ResourceLocation("paleocraft", "textures/entity/Masso.png");

	public RenderMasso(ModelBase modelbase, float shadowSize) {
		super(modelbase, shadowSize);
	}

	public void func_177_a(EntityMasso entityMasso, double d, double d1,
			double d2, float f, float f1) {
		super.doRenderLiving(entityMasso, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLivingBase entityliving, double d, double d1,
			double d2, float f, float f1) {
		func_177_a((EntityMasso) entityliving, d, d1, d2, f, f1);
	}

    @Override
	public void doRender(Entity entity, double d, double d1, double d2,
			float f, float f1) {
		func_177_a((EntityMasso) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return skin;
	}
}
