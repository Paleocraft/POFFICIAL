package fisherman77.paleocraft.common.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderQuetzalcoatlus extends RenderLiving
{
 protected ModelQuetzalcoatlus model;
 private static final ResourceLocation skin = new ResourceLocation("paleocraft", "textures/entity/Quetz.png");
 public RenderQuetzalcoatlus (ModelQuetzalcoatlus modelquetzalcoatlus, float f)
 {
  super(modelquetzalcoatlus, f);
  model = ((ModelQuetzalcoatlus)mainModel);
 }
 
 public void renderQuetzalcoatlus(EntityQuetzalcoatlus entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderQuetzalcoatlus((EntityQuetzalcoatlus)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderQuetzalcoatlus((EntityQuetzalcoatlus)par1Entity, par2, par4, par6, par8, par9);
    }
 @Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return skin;
	}


}
