package net.hellonearth311.registries.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// fuck you item remainders, this should be easier
public class ChefsKnifeItem extends Item {
    public ChefsKnifeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack remainder = stack.copy();
        if (remainder.isDamageable()) {
            int newDamage = remainder.getDamage() + 1;
            if (newDamage >= remainder.getMaxDamage()) {
                return ItemStack.EMPTY;
            }
            remainder.setDamage(newDamage);
        }
        return remainder;
    }
}
