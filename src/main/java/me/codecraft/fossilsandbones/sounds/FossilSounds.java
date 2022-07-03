package me.codecraft.fossilsandbones.sounds;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * The type Fossil sounds.
 */
public class FossilSounds {
    /**
     * The constant DOWSING_ROD_FOUND_ORE.
     */
    public static SoundEvent DOWSING_ROD_FOUND_ORE = registerSoundEvent("dowsing_rod_found_ore");
    /**
     * The constant TREX_ROAR.
     */
    public static SoundEvent TREX_ROAR = registerSoundEvent("trex_roar");
    /**
     * The constant TREX_DEATH.
     */
    public static SoundEvent TREX_DEATH = registerSoundEvent("trex_death");
    /**
     * The constant TREX_ANGER.
     */
    public static SoundEvent TREX_ANGER = registerSoundEvent("trex_idle");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Fossil.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    /**
     * Modsound.
     */
    public static void modsound(){
        System.out.println("sound registered by "+ Fossil.MOD_ID);
    }
}