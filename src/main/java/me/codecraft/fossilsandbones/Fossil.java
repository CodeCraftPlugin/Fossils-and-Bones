package me.codecraft.fossilsandbones;

import me.codecraft.fossilsandbones.entities.FossilEntities;
import me.codecraft.fossilsandbones.items.FossilItemGroups;
import me.codecraft.fossilsandbones.items.FossilItems;
import me.codecraft.fossilsandbones.sounds.FossilSounds;
import me.codecraft.fossilsandbones.utils.Registeries;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Fossil.
 */
public class Fossil implements ModInitializer {
	/**
	 * The constant MOD_ID.
	 */
// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "fossilsandbones";
	/**
	 * The constant LOGGER.
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution
		LOGGER.info("Hello Fabric world!");
		Registeries.init();
		FossilEntities.entiesregistered();
		FossilSounds.modsound();
		FossilItems.registeredFossilItems();
		FossilItemGroups.registered();

	}
}
