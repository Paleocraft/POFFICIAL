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
            event.manager.soundPoolSounds.addSound("paleocraft/bary/living1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Bary/Bary1.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/bary/living2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Bary/Bary2.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/bary/living3.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Bary/Bary3.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/bary/hurt.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Bary/BaryHurt.ogg"));
            
        //CITIPATI
            event.manager.soundPoolSounds.addSound("paleocraft/citi/living1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Citi/Citi1.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/citi/living2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Citi/Citi2.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/citi/living3.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Citi/Citi3.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/citi/hurt.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Citi/CitiHurt.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/citi/smallherbdeath.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Citi/SmallHerbDeath.ogg"));
            
        //DROMAEOSAURUS
            event.manager.soundPoolSounds.addSound("paleocraft/dromie/living1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dromie/Dromie1.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/dromie/living2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dromie/Dromie2.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/dromie/living3.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dromie/Dromie3.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/dromie/living4.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dromie/Dromie4.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/dromie/living5.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dromie/Dromie5.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/dromie/hurt.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dromie/DromieHurt.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/dromie/smallcarndeath.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dromie/SmallCarnDeath.ogg"));

        //TROODON
            event.manager.soundPoolSounds.addSound("paleocraft/troo/living1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Troo/Troo1.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/troo/living2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Troo/Troo2.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/troo/living3.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Troo/Troo3.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/troo/hurt.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Troo/TrooHurt.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/troo/smallcarndeath.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Troo/SmallCarnDeath.ogg"));
            
        //DIMORPHODON
            event.manager.soundPoolSounds.addSound("paleocraft/dimorph/living1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dimorph/Dimorph1.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/dimorph/living2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dimorph/Dimorph2.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/dimorph/hurt.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dimorph/DimorphHurt.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/dimorph/smallcarndeath.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Dimorph/TinyDeath.ogg"));
            
        //Tylo
            event.manager.soundPoolSounds.addSound("paleocraft/Tylo/Tylo1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Tylo/Tylo1.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/Tylo/Tylo2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Tylo/Tylo2.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/Tylo/Tylo3.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Tylo/Tylo3.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/Tylo/TyloHurt.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Tylo/TyloHurt.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/Tylo/LargeCarnDeath.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Tylo/LargeCarnDeath.ogg"));
             
            //Spinosaurus
            event.manager.soundPoolSounds.addSound("paleocraft/Spino/Spino1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Spino/Spino1.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/Spino/Spino2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Spino/Spino2.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/Spino/Spino3.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Spino/Spino3.ogg"));            
            event.manager.soundPoolSounds.addSound("paleocraft/Spino/SpinoHurt.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Spino/SpinoHurt.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/Spino/LargeCarnDeath.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Spino/LargeCarnDeath.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/Spino/SpinoMad1.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Spino/SpinoMad1.ogg"));
            event.manager.soundPoolSounds.addSound("paleocraft/Spino/SpinoMad2.ogg", Paleocraft.class.getResource("/Paleocraft/Mobs/Spino/SpinoMad2.ogg"));
        } 
        catch (Exception e)
        {
            System.err.println("[Paleocraft] Failed to register one or more sounds.");
        }
    }
}
