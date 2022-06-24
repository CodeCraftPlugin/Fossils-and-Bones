package me.codecraft.fossilsandbones;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FossilSounds {
    public static SoundEvent DOWSING_ROD_FOUND_ORE = registerSoundEvent("dowsing_rod_found_ore");
    public static SoundEvent TREX_ROAR = registerSoundEvent("trex_roar");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Fossil.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
    public static void modsound(){
        System.out.println("sound registered by "+ Fossil.MOD_ID);
    }
}