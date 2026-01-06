package net.hellonearth311;

import net.fabricmc.api.ModInitializer;

import net.hellonearth311.registries.block.ModBlocks;
import net.hellonearth311.registries.item.ModItemGroups;
import net.hellonearth311.registries.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PixelPantry implements ModInitializer {
	public static final String MOD_ID = "pixel_pantry";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("le food system is being le enhanced hehe (pixelpantry v.0.0.1)");
		ModBlocks.initialize();
		ModItems.initialize();
		ModItemGroups.initialize();
	}
}