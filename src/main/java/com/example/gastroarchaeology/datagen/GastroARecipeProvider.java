package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.compat.GastroAChickensaurs;
import com.example.gastroarchaeology.compat.GastroAMineconRuins;
import com.example.gastroarchaeology.item.GastroAItems;
import net.hyper_pigeon.chickensaurs.register.ItemRegistry;
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.CURD_MIXTURE, 3)
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.TAPIOCA_DOUGH, 8)
                .requires(GastroAItems.CRUSHED_CASSAVA, 8)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_crushed_cassava", has(GastroAItems.CRUSHED_CASSAVA))
                .unlockedBy("has_cassava", has(GastroAItems.CASSAVA))
                .unlockedBy("has_tapioca_recipe", has(GastroAItems.TAPIOCA_RECIPE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.BEEF_PACOCA, 2)
                .requires(GastroAItems.PACOCA_RECIPE)
                .requires(GastroAItems.CASSAVA_FLOUR)
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_pacoca_recipe", has(GastroAItems.PACOCA_RECIPE))
                .unlockedBy("has_cassava_flour", has(GastroAItems.CASSAVA_FLOUR))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.PORK_PACOCA, 2)
                .requires(GastroAItems.PACOCA_RECIPE)
                .requires(GastroAItems.CASSAVA_FLOUR)
                .requires(Items.COOKED_PORKCHOP)
                .unlockedBy("has_pacoca_recipe", has(GastroAItems.PACOCA_RECIPE))
                .unlockedBy("has_cassava_flour", has(GastroAItems.CASSAVA_FLOUR))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.CHICKEN_PACOCA, 2)
                .requires(GastroAItems.PACOCA_RECIPE)
                .requires(GastroAItems.CASSAVA_FLOUR)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_pacoca_recipe", has(GastroAItems.PACOCA_RECIPE))
                .unlockedBy("has_cassava_flour", has(GastroAItems.CASSAVA_FLOUR))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.FISH_PACOCA, 2)
                .requires(GastroAItems.PACOCA_RECIPE)
                .requires(GastroAItems.CASSAVA_FLOUR)
                .requires(Items.COOKED_COD)
                .unlockedBy("has_pacoca_recipe", has(GastroAItems.PACOCA_RECIPE))
                .unlockedBy("has_cassava_flour", has(GastroAItems.CASSAVA_FLOUR))
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
        tripleCookingRecipe(
                recipeOutput,
                200, GastroAItems.CASSAVA, GastroAItems.BAKED_CASSAVA, 2
        );
        tripleCookingRecipe(
                recipeOutput,
                200, GastroAItems.CASSAVA_DOUGH, GastroAItems.CASSAVA_FLOUR, 2
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

        //Compat
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAChickensaurs.CHICKENSAUR_PACOCA, 2)
                .requires(GastroAItems.PACOCA_RECIPE)
                .requires(GastroAItems.CASSAVA_FLOUR)
                .requires(ItemRegistry.COOKED_CHICKENSAUR.get())
                .unlockedBy("has_pacoca_recipe", has(GastroAItems.PACOCA_RECIPE))
                .unlockedBy("has_cassava_flour", has(GastroAItems.CASSAVA_FLOUR))
                .save(recipeOutput.withConditions(modLoaded("chickensaurs")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAMineconRuins.MINECON_BURGUER)
                .requires(GastroAMineconRuins.MINECON_RECIPE)
                .requires(GastroAItems.TOMATO)
                .requires(Items.COOKED_BEEF)
                .requires(Items.BREAD)
                .unlockedBy("has_minecon_recipe", has(GastroAMineconRuins.MINECON_RECIPE))
                .save(recipeOutput.withConditions(modLoaded("minecon_ruins")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAMineconRuins.MINECON_HOT_WINGS)
                .requires(GastroAMineconRuins.MINECON_RECIPE)
                .requires(GastroAItems.PEPPER)
                .requires(Items.COOKED_CHICKEN)
                .requires(Items.PAPER)
                .unlockedBy("has_minecon_recipe", has(GastroAMineconRuins.MINECON_RECIPE))
                .save(recipeOutput.withConditions(modLoaded("minecon_ruins")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAMineconRuins.MINECON_TACO)
                .requires(GastroAMineconRuins.MINECON_RECIPE)
                .requires(GastroAItems.TOMATO)
                .requires(Items.COOKED_PORKCHOP)
                .requires(Items.WHEAT)
                .unlockedBy("has_minecon_recipe", has(GastroAMineconRuins.MINECON_RECIPE))
                .save(recipeOutput.withConditions(modLoaded("minecon_ruins")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAMineconRuins.MINECON_PIZZA_SLICE)
                .requires(GastroAMineconRuins.MINECON_RECIPE)
                .requires(GastroAItems.TOMATO)
                .requires(GastroAItems.CHEESE)
                .requires(Items.WHEAT)
                .unlockedBy("has_minecon_recipe", has(GastroAMineconRuins.MINECON_RECIPE))
                .save(recipeOutput.withConditions(modLoaded("minecon_ruins")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAMineconRuins.MINECON_WAFFLE)
                .requires(GastroAMineconRuins.MINECON_RECIPE)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.WHEAT)
                .unlockedBy("has_minecon_recipe", has(GastroAMineconRuins.MINECON_RECIPE))
                .save(recipeOutput.withConditions(modLoaded("minecon_ruins")));
    }

    protected static void tripleCookingRecipe(RecipeOutput recipeOutput, int cookingTime, ItemLike material, ItemLike result, float experience) {
        simpleCookingRecipe(
                recipeOutput,
                "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new,
                cookingTime / 2, material, result, experience
        );
        simpleCookingRecipe(
                recipeOutput,
                "smelting", RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                cookingTime, material, result, experience
        );
        simpleCookingRecipe(
                recipeOutput,
                "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new,
                cookingTime * 2, material, result, 0
        );
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
