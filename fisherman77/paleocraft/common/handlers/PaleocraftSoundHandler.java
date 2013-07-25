package fisherman77.paleocraft.common.handlers;

import java.beans.EventHandler;

import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fisherman77.paleocraft.common.Paleocraft;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class PaleocraftSoundHandler
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
        //BARY
            event.manager.addSound("paleocraft:baryliving1.ogg");
            event.manager.addSound("paleocraft:baryliving2.ogg");
            event.manager.addSound("paleocraft:baryliving3.ogg");            
            event.manager.addSound("paleocraft:baryhurt.ogg");
            
        //CITIPATI
            event.manager.addSound("paleocraft:citiliving1.ogg");
            event.manager.addSound("paleocraft:citiliving2.ogg");
            event.manager.addSound("paleocraft:citiliving3.ogg");            
            event.manager.addSound("paleocraft:citi/hurt.ogg");
            event.manager.addSound("paleocraft:citi/smallherbdeath.ogg");
            
        //DROMAEOSAURUS
            event.manager.addSound("paleocraft:dromieliving1.ogg");            
            event.manager.addSound("paleocraft:dromieliving2.ogg");            
            event.manager.addSound("paleocraft:dromieliving3.ogg");
            event.manager.addSound("paleocraft:dromieliving4.ogg");            
            event.manager.addSound("paleocraft:dromieliving5.ogg");
            event.manager.addSound("paleocraft:dromie/hurt.ogg");
            event.manager.addSound("paleocraft:dromie/smallcarndeath.ogg");

        //TROODON
            event.manager.addSound("paleocraft:trooliving1.ogg");            
            event.manager.addSound("paleocraft:trooliving2.ogg");            
            event.manager.addSound("paleocraft:trooliving3.ogg");            
            event.manager.addSound("paleocraft:troo/hurt.ogg");
            event.manager.addSound("paleocraft:troo/smallcarndeath.ogg");
            
        //DIMORPHODON
            event.manager.addSound("paleocraft:dimorphliving1.ogg");            
            event.manager.addSound("paleocraft:dimorphliving2.ogg");            
            event.manager.addSound("paleocraft:dimorph/hurt.ogg");
            event.manager.addSound("paleocraft:dimorph/smallcarndeath.ogg");
            
        //Tylo
            event.manager.addSound("paleocraft:tyloliving1.ogg");            
            event.manager.addSound("paleocraft:tyloliving2.ogg");            
            event.manager.addSound("paleocraft:tyloliving3.ogg");            
            event.manager.addSound("paleocraft:tylohurt.ogg");
            event.manager.addSound("paleocraft:largecarndeath.ogg");
             
            //Spinosaurus
            event.manager.addSound("paleocraft:spinoliving1.ogg");            
            event.manager.addSound("paleocraft:spinoliving2.ogg");            
            event.manager.addSound("paleocraft:spinoliving3.ogg");            
            event.manager.addSound("paleocraft:spinohurt.ogg");
            event.manager.addSound("paleocraft:largecarndeath.ogg");
            event.manager.addSound("paleocraft:spinomad1.ogg");
            event.manager.addSound("paleocraft:spinomad2.ogg");
        } 
        catch (Exception e)
        {
            System.err.println("[Paleocraft] Failed to register one or more sounds.");
        }
    }
}
