package fisherman77.ancientgreececraft.client;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fisherman77.ancientgreececraft.common.AncientGreececraftCommonProxy;
import fisherman77.ancientgreececraft.common.mobs.EntityAGCyclops;
import fisherman77.ancientgreececraft.common.mobs.EntityAGMinotaur;
import fisherman77.ancientgreececraft.common.mobs.EntityAGSatyr;
import fisherman77.ancientgreececraft.common.mobs.RenderAGCyclops;
import fisherman77.ancientgreececraft.common.mobs.RenderAGMinotaur;
import fisherman77.ancientgreececraft.common.mobs.RenderAGSatyr;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

public class AncientGreececraftClientProxy extends AncientGreececraftCommonProxy {
        
public void registerRenderInformation(){
	MinecraftForgeClient.preloadTexture(ITEMS_PNG);
	MinecraftForgeClient.preloadTexture(BLOCK_PNG);
}

public void registerRenderers(){
	float shadowSize = 0.5F;
	//RenderingRegistry.registerEntityRenderingHandler(EntityAGSatyr.class, new RenderAGSatyr(new ModelBiped(), shadowSize));
	//RenderingRegistry.registerEntityRenderingHandler(EntityAGCyclops.class, new RenderAGCyclops(new ModelBiped(), shadowSize, 5.0F));
	//RenderingRegistry.registerEntityRenderingHandler(EntityAGMinotaur.class, new RenderAGMinotaur(new ModelBiped(), shadowSize));   

}

}