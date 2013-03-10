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
            
        } 
        catch (Exception e)
        {
            System.err.println("[Paleocraft] Failed to register one or more sounds.");
        }
    }
}
