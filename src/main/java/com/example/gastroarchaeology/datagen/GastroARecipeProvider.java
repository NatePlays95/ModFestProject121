package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
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
                .requires(Items.STONE) //TODO: replace with salt?
                .unlockedBy("has_curd_bucket", has(GastroAItems.CURD_BUCKET))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.SWEET_BERRY_YOGURT, 3)
                .requires(GastroAItems.YOGURT_RECIPE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE, 3)
                .unlockedBy("has_yogurt_recipe", has(GastroAItems.YOGURT_RECIPE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.GLOW_BERRY_YOGURT, 3)
                .requires(GastroAItems.YOGURT_RECIPE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.GLOW_BERRIES)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE, 3)
                .unlockedBy("has_yogurt_recipe", has(GastroAItems.YOGURT_RECIPE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GastroAItems.HONEY_CARROT_YOGURT, 3)
                .requires(GastroAItems.YOGURT_RECIPE)
                .requires(GastroAItems.CURD_BUCKET)
                .requires(Items.CARROT)
                .requires(Items.SUGAR)
                .requires(Items.HONEY_BOTTLE, 3)
                .unlockedBy("has_yogurt_recipe", has(GastroAItems.YOGURT_RECIPE))
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

//        List<ItemLike> MACHALITE_SMELTABLES = List.of(ModItems.MALACHITE_CHUNK, ModBlocks.MACHALITE_ORE);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MACHALITE_BLOCK.get())
//                .pattern("III").pattern("III").pattern("III")
//                .define('I', ModItems.MALACHITE_INGOT.get())
//                .unlockedBy("has_machalite_ingot", has(ModItems.MALACHITE_INGOT)).save(recipeOutput);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MALACHITE_INGOT.get(), 9)
//                .requires(ModBlocks.MACHALITE_BLOCK)
//                .unlockedBy("has_machalite_block", has(ModBlocks.MACHALITE_BLOCK)).save(recipeOutput);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MALACHITE_INGOT.get(), 9)
//                .requires(ModBlocks.MAGIC_BLOCK)
//                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK))
//                .save(recipeOutput, MyNeoForgeMod.MODID+":machalite_ingot_from_magic_block");
//
//        oreSmelting(recipeOutput, MACHALITE_SMELTABLES, RecipeCategory.MISC, ModItems.MALACHITE_INGOT.get(), 0.25f, 200, "machalite");
//        oreBlasting(recipeOutput, MACHALITE_SMELTABLES, RecipeCategory.MISC, ModItems.MALACHITE_INGOT.get(), 0.25f, 100, "machalite");
//
//        stairBuilder(ModBlocks.MACHALITE_STAIRS.get(), Ingredient.of(ModBlocks.MACHALITE_BLOCK)).group("machalite")
//                .unlockedBy("has_machalite_block", has(ModBlocks.MACHALITE_BLOCK)).save(recipeOutput);
//        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MACHALITE_SLAB, Ingredient.of(ModBlocks.MACHALITE_BLOCK)).group("machalite")
//                .unlockedBy("has_machalite_block", has(ModBlocks.MACHALITE_BLOCK)).save(recipeOutput);
//
//        buttonBuilder(ModBlocks.MACHALITE_BUTTON.get(), Ingredient.of(ModItems.MALACHITE_INGOT.get())).group("machalite")
//                .unlockedBy("has_machalite_ingot", has(ModItems.MALACHITE_INGOT.get())).save(recipeOutput);
//        pressurePlate(recipeOutput, ModBlocks.MACHALITE_PRESSURE_PLATE.get(), ModItems.MALACHITE_INGOT.get());
//
//        fenceBuilder(ModBlocks.MACHALITE_FENCE.get(), Ingredient.of(ModItems.MALACHITE_INGOT.get())).group("machalite")
//                .unlockedBy("has_machalite_ingot", has(ModItems.MALACHITE_INGOT.get())).save(recipeOutput);
//        fenceGateBuilder(ModBlocks.MACHALITE_FENCE_GATE.get(), Ingredient.of(ModItems.MALACHITE_INGOT.get())).group("machalite")
//                .unlockedBy("has_machalite_ingot", has(ModItems.MALACHITE_INGOT.get())).save(recipeOutput);
//        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MACHALITE_WALL.get(), ModItems.MALACHITE_INGOT.get());
//
//        doorBuilder(ModBlocks.MACHALITE_DOOR.get(), Ingredient.of(ModItems.MALACHITE_INGOT.get())).group("machalite")
//                .unlockedBy("has_machalite_ingot", has(ModItems.MALACHITE_INGOT.get())).save(recipeOutput);
//        trapdoorBuilder(ModBlocks.MACHALITE_TRAPDOOR.get(), Ingredient.of(ModItems.MALACHITE_INGOT.get())).group("machalite")
//                .unlockedBy("has_machalite_ingot", has(ModItems.MALACHITE_INGOT.get())).save(recipeOutput);
    }



    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
                                      ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category,
                                      ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
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
