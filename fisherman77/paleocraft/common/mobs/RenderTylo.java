package fisherman77.paleocraft.common.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderTylo extends RenderLiving
{
 protected ModelTylo model;
 
 public RenderTylo (ModelTylo modelTylo, float f)
 {
  super(modelTylo, f);
  model = ((ModelTylo)mainModel);
 }
 
 public void renderTylo(EntityTylo entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderTylo((EntityTylo)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderTylo((EntityTylo)par1Entity, par2, par4, par6, par8, par9);
    }
}
