package net.hellonearth311.registries.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hellonearth311.Pixelpantry;
import net.hellonearth311.registries.item.custom.ChefsKnifeItem;
import net.minecraft.component.type.Consumable;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
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

    public static Item registerFood(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings, int nutrition, float saturation) {
        return register(name, itemFactory, settings.food(new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturation).build()));
    }
    // BLOCKS / MACHINES

    // TOOLS
    public static Item CHEFS_KNIFE = register("chefs-knife", ChefsKnifeItem::new, new Item.Settings().maxDamage(256));

    // CROPS / PLANTS

    // tomato
    public static final Item TOMATO = registerFood("tomato", Item::new, new Item.Settings(), 3, 0.25f);
    public static final Item TOMATO_SEED = register("tomato-seed", Item::new, new Item.Settings());

    // red pepper
    public static final Item RED_PEPPER = registerFood("red-pepper", Item::new, new Item.Settings(), 2, 0.2f);
    public static final Item RED_PEPPER_SEED = register("red-pepper-seed", Item::new, new Item.Settings());

    // garlic
    public static final Item GARLIC = register("garlic", Item::new, new Item.Settings());
    public static final Item GARLIC_CLOVE = registerFood("garlic-clove", Item::new, new Item.Settings(), 1, 0.1f);
    public static final Item DRIED_GARLIC_CLOVE = register("dried-garlic-clove", Item::new, new Item.Settings());

    // onions
    public static final Item ONION = register("onion", Item::new, new Item.Settings());

    public static final ConsumableComponent ONION_BULB_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 4 * 20, 1), 0.75f))
            .build();
    public static final FoodComponent ONION_BULB_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final Item ONION_BULB = register("onion-bulb", Item::new, new Item.Settings().food(ONION_BULB_FOOD_COMPONENT, ONION_BULB_FOOD_CONSUMABLE_COMPONENT));

    // PROCESSED INGREDIENTS

    public static final Item MINCED_GARLIC = register("minced-garlic", Item::new, new Item.Settings());
    public static final Item CHOPPED_TOMATO = register("chopped-tomato", Item::new, new Item.Settings());
    public static final Item CHOPPED_ONION = register("chopped-onion", Item::new, new Item.Settings());

    // DOUBLE PROCESSED INGREDIENTS

    // T1 FOODS

    // add tomato soup (with garlic and onions) and garlic bread (also with onions)

    // T2 FOODS

    public static void initialize() {
        // empty lmao
    }

}
