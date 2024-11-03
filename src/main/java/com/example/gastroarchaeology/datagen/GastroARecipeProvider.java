package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GastroARecipeProvider extends RecipeProvider implements IConditionBuilder {
    public GastroARecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.CURD_MIXTURE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.BONE_MEAL) //TODO: replace with salt?
                .unlockedBy("has_curd_bucket", has(GastroAItems.CURD_BUCKET))
                .unlockedBy("has_pizza_recipe", has(GastroAItems.PIZZA_RECIPE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.SWEET_BERRY_YOGURT, 3)
                .requires(GastroAItems.YOGURT_RECIPE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE, 3)
                .unlockedBy("has_yogurt_recipe", has(GastroAItems.YOGURT_RECIPE))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .unlockedBy("has_curd_bucket", has(GastroAItems.CURD_BUCKET))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.GLOW_BERRY_YOGURT, 3)
                .requires(GastroAItems.YOGURT_RECIPE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.GLOW_BERRIES)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE, 3)
                .unlockedBy("has_yogurt_recipe", has(GastroAItems.YOGURT_RECIPE))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_glow_berries", has(Items.GLOW_BERRIES))
                .unlockedBy("has_curd_bucket", has(GastroAItems.CURD_BUCKET))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.HONEY_CARROT_YOGURT, 3)
                .requires(GastroAItems.YOGURT_RECIPE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.CARROT)
                .requires(Items.SUGAR)
                .requires(Items.HONEY_BOTTLE, 3)
                .unlockedBy("has_yogurt_recipe", has(GastroAItems.YOGURT_RECIPE))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_honey_bottle", has(Items.HONEY_BOTTLE))
                .unlockedBy("has_curd_bucket", has(GastroAItems.CURD_BUCKET))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.CHORUS_FRUIT_YOGURT, 3)
                .requires(GastroAItems.YOGURT_RECIPE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE, 3)
                .unlockedBy("has_yogurt_recipe", has(GastroAItems.YOGURT_RECIPE))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_chorus_fruit", has(Items.CHORUS_FRUIT))
                .unlockedBy("has_curd_bucket", has(GastroAItems.CURD_BUCKET))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.TAPIOCA_BEEF_WRAP)
                .requires(GastroAItems.TAPIOCA_RECIPE)
                .requires(GastroAItems.TAPIOCA_DOUGH)
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_tapioca_recipe", has(GastroAItems.TAPIOCA_RECIPE))
                .unlockedBy("has_tapioca_dough", has(GastroAItems.TAPIOCA_DOUGH))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.TAPIOCA_CHEESE_WRAP)
                .requires(GastroAItems.TAPIOCA_RECIPE)
                .requires(GastroAItems.TAPIOCA_DOUGH)
                .requires(GastroAItems.CHEESE)
                .unlockedBy("has_tapioca_recipe", has(GastroAItems.TAPIOCA_RECIPE))
                .unlockedBy("has_tapioca_dough", has(GastroAItems.TAPIOCA_DOUGH))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.TAPIOCA_HAM_AND_CHEESE_WRAP)
                .requires(GastroAItems.TAPIOCA_RECIPE)
                .requires(GastroAItems.TAPIOCA_DOUGH)
                .requires(GastroAItems.CHEESE)
                .requires(Items.COOKED_PORKCHOP)
                .unlockedBy("has_tapioca_recipe", has(GastroAItems.TAPIOCA_RECIPE))
                .unlockedBy("has_tapioca_dough", has(GastroAItems.TAPIOCA_DOUGH))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GastroAItems.TAPIOCA_DOUGH, 8)
                .requires(GastroAItems.CRUSHED_CASSAVA, 8)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_crushed_cassava", has(GastroAItems.CRUSHED_CASSAVA))
                .unlockedBy("has_cassava", has(GastroAItems.CASSAVA))
                .unlockedBy("has_tapioca_recipe", has(GastroAItems.TAPIOCA_RECIPE))
                .unlockedBy("has_water_bucket", has(Items.BUCKET))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroABlocks.SPICY_CHIPS)
                .requires(GastroAItems.PEPPER)
                .requires(Items.BAKED_POTATO)
                .requires(Items.RED_DYE)
                .requires(Items.BOWL)
                .unlockedBy("has_pepper", has(GastroAItems.PEPPER))
                .unlockedBy("has_baked_potato", has(Items.BAKED_POTATO))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroABlocks.EXTRA_SPICY_CHIPS)
                .requires(GastroAItems.PEPPER,6)
                .requires(Items.BAKED_POTATO)
                .requires(Items.RED_DYE)
                .requires(Items.BOWL)
                .unlockedBy("has_pepper", has(GastroAItems.PEPPER))
                .unlockedBy("has_baked_potato", has(Items.BAKED_POTATO))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GastroABlocks.PIZZA)
                .define('S', GastroAItems.TOMATO)
                .define('R', GastroAItems.PIZZA_RECIPE)
                .define('C', GastroAItems.CHEESE)
                .define('D', Items.WHEAT)
                .pattern("SRC")
                .pattern("DDD")
                .unlockedBy("has_pizza_recipe", has(GastroAItems.PIZZA_RECIPE))
                .unlockedBy("has_tomato", has(GastroAItems.TOMATO))
                .unlockedBy("has_cheese", has(GastroAItems.CHEESE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GastroABlocks.BRAZILIAN_PIZZA)
                .define('F', Tags.Items.FOODS)
                .define('S', GastroAItems.TOMATO)
                .define('R', GastroAItems.PIZZA_RECIPE)
                .define('C', GastroAItems.CHEESE)
                .define('D', Items.WHEAT)
                .pattern("FFF")
                .pattern("SRC")
                .pattern("DDD")
                .unlockedBy("has_pizza_recipe", has(GastroAItems.PIZZA_RECIPE))
                .unlockedBy("has_tomato", has(GastroAItems.TOMATO))
                .unlockedBy("has_cheese", has(GastroAItems.CHEESE))
                .save(recipeOutput);

        simpleCookingRecipe(
                recipeOutput,
                "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new,
                100, GastroAItems.CURD_MIXTURE, GastroAItems.CHEESE, 2
        );
        simpleCookingRecipe(
                recipeOutput,
                "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new,
                100, GastroAItems.CASSAVA, GastroAItems.BAKED_CASSAVA, 2
        );
        simpleCookingRecipe(
                recipeOutput,
                "smelting", RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                200, GastroAItems.CASSAVA, GastroAItems.BAKED_CASSAVA, 2
        );
        simpleCookingRecipe(
                recipeOutput,
                "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new,
                400, GastroAItems.CASSAVA, GastroAItems.BAKED_CASSAVA, 0
        );

        stonecutterResultFromBase(
                recipeOutput,
                RecipeCategory.MISC,
                GastroAItems.CRUSHED_CASSAVA,
                GastroAItems.CASSAVA
        );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SLIME_BALL)
                .requires(GastroAItems.TAPIOCA_DOUGH)
                .requires(Items.LIME_DYE)
                .unlockedBy("has_tapioca_dough", has(GastroAItems.TAPIOCA_DOUGH))
                .save(recipeOutput);

    }



    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
                                      ItemLike result, float experience, int cookingTime, String group) {
        recipeMaking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
                                      ItemLike result, float experience, int cookingTime, String group) {
        recipeMaking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void recipeMaking(
            RecipeOutput recipeOutput,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.Factory<T> recipeFactory,
            List<ItemLike> ingredients,
            RecipeCategory category,
            ItemLike result,
            float experience,
            int cookingTime,
            String group,
            String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Gastroarchaeology.MOD_ID + ":" + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }
}
