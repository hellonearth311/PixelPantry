package net.hellonearth311.registries.item;

import net.hellonearth311.PixelPantry;
import net.hellonearth311.registries.block.ModBlocks;
import net.hellonearth311.registries.item.custom.ChefsKnifeItem;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    private static Item register(String name, Function<Item.Settings, Item> function, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PixelPantry.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, function.apply(settings.registryKey(key)));
    }

    private static Item register(String name, Function<Item.Settings, Item> function) {
        return register(name, function, new Item.Settings());
    }

    private static Item registerFood(String name, int nutrition, float saturation) {
        FoodComponent food = new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturation).build();
        return register(name, Item::new, new Item.Settings().food(food));
    }

    // BLOCKS / MACHINES

    // TOOLS
    public static Item CHEFS_KNIFE = register("chefs_knife", ChefsKnifeItem::new, new Item.Settings().maxDamage(256));

    // CROPS / PLANTS

    // tomato
    public static final Item TOMATO = registerFood("tomato", 3, 0.25f);
    public static final Item TOMATO_SEED = register("tomato_seed",
            settings -> new BlockItem(ModBlocks.TOMATO_CROP, settings));

    // red pepper
    public static final Item RED_PEPPER = registerFood("red_pepper", 2, 0.2f);
    public static final Item RED_PEPPER_SEED = register("red_pepper_seed", Item::new);

    // garlic
    public static final Item GARLIC = register("garlic", Item::new);
    public static final Item GARLIC_CLOVE = registerFood("garlic_clove", 1, 0.1f);
    public static final Item DRIED_GARLIC_CLOVE = register("dried_garlic_clove",
            settings -> new BlockItem(ModBlocks.GARLIC_CROP, settings));

    // onions
    public static final Item ONION = register("onion", Item::new);

    public static final ConsumableComponent ONION_BULB_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 4 * 20, 1), 0.75f))
            .build();
    public static final FoodComponent ONION_BULB_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final Item ONION_BULB = register("onion_bulb", Item::new, new Item.Settings().food(ONION_BULB_FOOD_COMPONENT, ONION_BULB_FOOD_CONSUMABLE_COMPONENT));
    public static final Item DRIED_ONION_BULB = register("dried_onion_bulb",
            settings -> new BlockItem(ModBlocks.ONION_CROP, settings));

    // PROCESSED INGREDIENTS

    public static final Item MINCED_GARLIC = register("minced_garlic", Item::new);
    public static final Item CHOPPED_TOMATO = register("chopped_tomato", Item::new);
    public static final Item CHOPPED_ONION = register("chopped_onion", Item::new);

    // DOUBLE PROCESSED INGREDIENTS

    // T1 FOODS
    public static final Item TOMATO_SOUP = registerFood("tomato_soup", 8, 0.7f);
    public static final Item GARLIC_BREAD = registerFood("garlic_bread", 7, 0.9f);

    // T2 FOODS

    public static void initialize() {
        // empty lmao
    }

}
