package fisherman77.paleocraft.common.mobs;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

//Tons of credit to CrackedEgg and his Reptiles mod. Check it out, it's pretty awesome!

public class RenderTroodon extends RenderLiving
{
	private static final ResourceLocation skin = new ResourceLocation("paleocraft", "textures/entity/Troo.png");
	private static final ResourceLocation eyes = new ResourceLocation("paleocraft", "textures/entity/TrooEyes.png");

	public RenderTroodon(ModelBase modelbase, float f) {
		super(modelbase, f);
		setRenderPassModel((ModelTroodon) modelbase);
	}

	public RenderTroodon() {
		super(new ModelTroodon(), 0.8F);
		setRenderPassModel(new ModelTroodon());
	}

	public void renderTroodon(EntityTroodon entitycroc, double d, double d1, double d2, float f, float f1) {
		super.doRenderLiving(entitycroc, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLivingBase entityliving, double d, double d1, double d2, float f, float f1) {
		renderTroodon((EntityTroodon) entityliving, d, d1, d2, f, f1);
	}

    @Override
	public void doRender(Entity entity, double d, double d1, double d2,	float f, float f1) {
		renderTroodon((EntityTroodon) entity, d, d1, d2, f, f1);
	}

	/*protected int setCrocEyeBrightness(EntityTroodon entitycroc, int i, float f) {
		if (i != 0) {
			return -1;
		} else {
			func_110776_a(eyes);
			// float alpha = (1.0F - entitycroc.getBrightness(1.0F)) * 0.5F;
			// GL11.glEnable(GL11.GL_BLEND);
			// GL11.glDisable(GL11.GL_ALPHA_TEST);
			// GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			// GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
			GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

			if (entitycroc.isInvisible()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }
			char color = 61680;
			int u = color % 65536;
			int v = color / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) u / 1.0F, (float) v / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			return 1;
		}
	}

    @Override
	protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {
		return setCrocEyeBrightness((EntityTroodon) entityliving, i, f);
	}*/

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return skin;
	}
}