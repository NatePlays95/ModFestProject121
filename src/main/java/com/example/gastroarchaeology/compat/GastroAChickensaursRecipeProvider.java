package com.example.gastroarchaeology.compat;

import com.example.gastroarchaeology.RegistryHelper;
import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class GastroAChickensaursRecipeProvider extends RecipeProvider {
    public GastroAChickensaursRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.CHICKEN_PACOCA, 2)
                .requires(GastroAItems.PACOCA_RECIPE)
                .requires(GastroAItems.CASSAVA_FLOUR)
                .requires(RegistryHelper.getItem("chickensaurs:cooked_chickensaur"))
                .unlockedBy("has_pacoca_recipe", has(GastroAItems.PACOCA_RECIPE))
                .unlockedBy("has_cassava_flour", has(GastroAItems.CASSAVA_FLOUR))
                .save(recipeOutput);
    }
}
