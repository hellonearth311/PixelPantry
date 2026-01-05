package net.hellonearth311.registries;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hellonearth311.Pixelpantry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Pixelpantry.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    // tomato
    public static final FoodComponent TOMATO_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f).build();

    public static final Item TOMATO = register("tomato", Item::new, new Item.Settings().food(TOMATO_FOOD_COMPONENT));

    // le seed de tomato

    public static final Item TOMATO_SEED = register("tomato-seed", Item::new, new Item.Settings());

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.TOMATO));
    }

}
