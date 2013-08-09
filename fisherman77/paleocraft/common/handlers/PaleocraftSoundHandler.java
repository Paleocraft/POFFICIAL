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
            event.manager.addSound("paleocraft:citihurt.ogg");
            event.manager.addSound("paleocraft:smallherbdeath.ogg");
            
        //DROMAEOSAURUS
            event.manager.addSound("paleocraft:dromieliving1.ogg");            
            event.manager.addSound("paleocraft:dromieliving2.ogg");            
            event.manager.addSound("paleocraft:dromieliving3.ogg");
            event.manager.addSound("paleocraft:dromieliving4.ogg");            
            event.manager.addSound("paleocraft:dromieliving5.ogg");
            event.manager.addSound("paleocraft:dromiehurt.ogg");
            event.manager.addSound("paleocraft:smallcarndeath.ogg");

        //TROODON
            event.manager.addSound("paleocraft:trooliving1.ogg");            
            event.manager.addSound("paleocraft:trooliving2.ogg");            
            event.manager.addSound("paleocraft:trooliving3.ogg");            
            event.manager.addSound("paleocraft:troohurt.ogg");
            event.manager.addSound("paleocraft:smallcarndeath.ogg");
            
        //DIMORPHODON
            event.manager.addSound("paleocraft:dimorphliving1.ogg");            
            event.manager.addSound("paleocraft:dimorphliving2.ogg");            
            event.manager.addSound("paleocraft:dimorphhurt.ogg");
            event.manager.addSound("paleocraft:smallcarndeath.ogg");
            
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
        
        //Compsognathus
            event.manager.addSound("paleocraft:Compy1.ogg");     
            event.manager.addSound("paleocraft:Compy2.ogg");
            event.manager.addSound("paleocraft:CompyDeath.ogg");
            event.manager.addSound("paleocraft:CompyHurt.ogg");
        
           //Massospondylus
            event.manager.addSound("paleocraft:Masso1.ogg"); 
            event.manager.addSound("paleocraft:Masso2.ogg"); 
            event.manager.addSound("paleocraft:Masso3.ogg"); 
            event.manager.addSound("paleocraft:MassoHurt.ogg"); 
            event.manager.addSound("paleocraft:MedHerbDeath.ogg"); 
        } 
        catch (Exception e)
        {
            System.err.println("[Paleocraft] Failed to register one or more sounds.");
        }
    }
}

