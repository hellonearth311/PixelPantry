package net.hellonearth311;

import net.fabricmc.api.ModInitializer;

import net.hellonearth311.registries.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pixelpantry implements ModInitializer {
	public static final String MOD_ID = "pixel-pantry";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("le food system is being le enhanced hehe (pixelpantry v.0.0.1)");
		ModItems.initialize();
	}
}