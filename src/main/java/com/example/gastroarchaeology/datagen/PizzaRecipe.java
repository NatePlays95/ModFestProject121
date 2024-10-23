package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.block.GastroABlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PizzaRecipe extends CustomRecipe {
    private final List<Item> baseItems;
    public PizzaRecipe(CraftingBookCategory category, Item... baseItems) {
        super(category);
        this.baseItems = List.of(baseItems);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, @NotNull Level level) {
        List<Item> checkList = baseItems.reversed();
        for(int i = 0; i < craftingInput.size(); ++i) {
            ItemStack itemstack = craftingInput.getItem(i);
            if(!checkList.contains(itemstack.getItem()) || !itemstack.getComponents().has(DataComponents.FOOD))
                return false;
            for(Item item : checkList){
                if(itemstack.is(item.asItem())){
                    checkList.remove(item);
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        return new ItemStack(GastroABlocks.PIZZA);
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 6;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.SHAPELESS_RECIPE;
    }

    public class Serializer implements RecipeSerializer<PizzaRecipe> {
        @Override
        public MapCodec<PizzaRecipe> codec() {
            return null;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, PizzaRecipe> streamCodec() {
            return null;
        }
    }
}
