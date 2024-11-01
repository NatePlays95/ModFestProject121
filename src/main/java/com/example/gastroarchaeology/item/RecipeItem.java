package com.example.gastroarchaeology.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class RecipeItem extends Item {
    public RecipeItem() {
        super( new Item.Properties()
                .stacksTo(1)
        );
    }

    @Override
    public boolean hasCraftingRemainingItem(@NotNull ItemStack stack) { return true; }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) { return stack.copy(); }
}
