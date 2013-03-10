package fisherman77.zeuscraft.client;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fisherman77.zeuscraft.common.ZeuscraftCommonProxy;
import fisherman77.zeuscraft.common.mobs.EntityCentaur;
import fisherman77.zeuscraft.common.mobs.EntityCyclops;
import fisherman77.zeuscraft.common.mobs.EntityHarpie;
import fisherman77.zeuscraft.common.mobs.EntityHostileCentaur;
import fisherman77.zeuscraft.common.mobs.EntityWiseCentaur;
import fisherman77.zeuscraft.common.mobs.ModelCentaur;
import fisherman77.zeuscraft.common.mobs.ModelHarpie;
import fisherman77.zeuscraft.common.mobs.RenderCentaur;
import fisherman77.zeuscraft.common.mobs.RenderCyclops;
import fisherman77.zeuscraft.common.mobs.RenderHarpie;
import fisherman77.zeuscraft.common.mobs.RenderHostileCentaur;
import fisherman77.zeuscraft.common.mobs.RenderWiseCentaur;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

public class ZeuscraftClientProxy extends ZeuscraftCommonProxy {
        
public void registerRenderInformation(){
	MinecraftForgeClient.preloadTexture(ITEMS_PNG);
	MinecraftForgeClient.preloadTexture(BLOCK_PNG);
}

public void registerRenderers(){
	float shadowSize = 0.5F;
	RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new RenderCentaur(new ModelCentaur(), shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityCyclops.class, new RenderCyclops(new ModelBiped(), shadowSize, 5.0F));
	RenderingRegistry.registerEntityRenderingHandler(EntityHarpie.class, new RenderHarpie(new ModelHarpie(), shadowSize));   
	RenderingRegistry.registerEntityRenderingHandler(EntityWiseCentaur.class, new RenderWiseCentaur(new ModelCentaur(), shadowSize));   
	RenderingRegistry.registerEntityRenderingHandler(EntityHostileCentaur.class, new RenderHostileCentaur(new ModelCentaur(), shadowSize));   

}

}