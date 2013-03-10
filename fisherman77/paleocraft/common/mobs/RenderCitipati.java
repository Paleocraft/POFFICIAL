package fisherman77.paleocraft.common.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderCitipati extends RenderLiving
{
 protected ModelCitipati model;
 
 public RenderCitipati (ModelCitipati modelCitipati, float f)
 {
  super(modelCitipati, f);
  model = ((ModelCitipati)mainModel);
 }
 
 public void renderCitipati(EntityCitipati entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderCitipati((EntityCitipati)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderCitipati((EntityCitipati)par1Entity, par2, par4, par6, par8, par9);
    }
}