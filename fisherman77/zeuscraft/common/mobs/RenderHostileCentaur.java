package fisherman77.zeuscraft.common.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderHostileCentaur extends RenderLiving
{
 protected ModelCentaur model;
 
 public RenderHostileCentaur (ModelCentaur modelCentaur, float f)
 {
  super(modelCentaur, f);
  model = ((ModelCentaur)mainModel);
 }
 
 public void renderCentaur(EntityHostileCentaur entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderCentaur((EntityHostileCentaur)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderCentaur((EntityHostileCentaur)par1Entity, par2, par4, par6, par8, par9);
    }
}