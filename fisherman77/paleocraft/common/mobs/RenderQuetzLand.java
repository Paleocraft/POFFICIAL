package fisherman77.paleocraft.common.mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderQuetzLand extends RenderLiving
{
 protected ModelQuetzLand model;
 private static final ResourceLocation skin = new ResourceLocation("paleocraft", "textures/entity/Quetz.png");
 public RenderQuetzLand (ModelQuetzLand modelquetzland, float f)
 {
  super(modelquetzland, f);
  model = ((ModelQuetzLand)mainModel);
 }
 
 public void renderQuetzalcoatlusL(EntityQuetzalcoatlusL entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderQuetzalcoatlusL((EntityQuetzalcoatlusL)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderQuetzalcoatlusL((EntityQuetzalcoatlusL)par1Entity, par2, par4, par6, par8, par9);
    }
 @Override
        protected ResourceLocation getEntityTexture(Entity entity) {
                return skin;
        }


}
