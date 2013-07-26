package fisherman77.paleocraft.common.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderSpino extends RenderLiving
{
	private static final ResourceLocation skin = new ResourceLocation("paleocraft", "textures/entity/Spino.png");

	public RenderSpino(ModelBase modelbase, float shadowSize) {
		super(modelbase, shadowSize);
	}

	public void func_177_a(EntitySpino entitySpino, double d, double d1,
			double d2, float f, float f1) {
		super.doRenderLiving(entitySpino, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLivingBase entityliving, double d, double d1,
			double d2, float f, float f1) {
		func_177_a((EntitySpino) entityliving, d, d1, d2, f, f1);
	}

    @Override
	public void doRender(Entity entity, double d, double d1, double d2,
			float f, float f1) {
		func_177_a((EntitySpino) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return skin;
	}
}
