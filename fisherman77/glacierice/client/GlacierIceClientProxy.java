package fisherman77.glacierice.client;
import fisherman77.glacierice.common.GlacierIceCommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;

public class GlacierIceClientProxy extends GlacierIceCommonProxy {
        
public void registerRenderInformation(){
	MinecraftForgeClient.preloadTexture("/GlacierIce/GlacierBlocks.png");
}

}