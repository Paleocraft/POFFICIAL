package fisherman77.paleocraft.common.handlers;

import java.beans.EventHandler;

//import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.event.ForgeSubscribe;
//SOUND HANDLER DOESN'T WORK! SOUNDS ARE USED IN THE sound.json FILE IN RESOURCES


public class PaleocraftSoundHandler
{
   
	public static void onEntityPlay(String name,World world,Entity entityname,float volume ,float pitch){
	           world.playSoundAtEntity(entityname, ("Paleocraft:" + name), (float)volume,(float) pitch);}
	
	
	//@ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
        //BARY
             
        
        } 
        catch (Exception e)
        {
            System.err.println("[Paleocraft] Failed to register one or more sounds.");
        }
    }
}
