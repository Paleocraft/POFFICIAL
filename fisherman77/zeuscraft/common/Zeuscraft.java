
package fisherman77.zeuscraft.common; //The package your mod is in

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import fisherman77.zeuscraft.common.handlers.ZeuscraftServerPacketHandler;
import fisherman77.zeuscraft.common.handlers.ZeuscraftClientPacketHandler;;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Zeuscraft"}, packetHandler = ZeuscraftClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Zeuscraft"}, packetHandler = ZeuscraftServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="Zeuscraft",name="Zeuscraft",version="Dev Build")

public class Zeuscraft {

@Instance("Zeuscraft") //The instance, this is very important later on
public static Zeuscraft instance = new Zeuscraft();

@SidedProxy(clientSide = "fisherman77.zeuscraft.client.ZeuscraftClientProxy", serverSide = "fisherman77.zeuscraft.common.ZeuscraftCommonProxy") //Tells Forge the location of your proxies
public static ZeuscraftCommonProxy proxy;
	
	

@PreInit
public void PreInit(FMLPreInitializationEvent e){
	
	}

@Init
public void InitZeuscraft(FMLInitializationEvent event){ //Your main initialization method
	
//MULTIPLAYER ABILITY
	NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

}
}