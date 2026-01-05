package net.hellonearth311.registries.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hellonearth311.Pixelpantry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Pixelpantry.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.TOMATO))
            .displayName(Text.translatable("itemGroup.pixel-pantry"))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.TOMATO);
            itemGroup.add(ModItems.TOMATO_SEED);
            itemGroup.add(ModItems.CHOPPED_TOMATO);
            itemGroup.add(ModItems.RED_PEPPER);
            itemGroup.add(ModItems.RED_PEPPER_SEED);
            itemGroup.add(ModItems.GARLIC);
            itemGroup.add(ModItems.GARLIC_CLOVE);
            itemGroup.add(ModItems.DRIED_GARLIC_CLOVE);
            itemGroup.add(ModItems.MINCED_GARLIC);
            itemGroup.add(ModItems.ONION);
            itemGroup.add(ModItems.ONION_BULB);
            itemGroup.add(ModItems.CHOPPED_ONION);
            itemGroup.add(ModItems.TOMATO_SOUP);
            itemGroup.add(ModItems.GARLIC_BREAD);
            itemGroup.add(ModItems.CHEFS_KNIFE);
        });
    }
}