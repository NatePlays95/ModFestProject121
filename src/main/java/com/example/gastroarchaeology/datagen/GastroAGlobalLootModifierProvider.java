package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.item.GastroAItems;
import com.example.gastroarchaeology.loot.modifiers.GastroARandomOverrideLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GastroAGlobalLootModifierProvider extends GlobalLootModifierProvider {
    // Get the PackOutput from GatherDataEvent.
    public GastroAGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Gastroarchaeology.MOD_ID);
    }

    @Override
    protected void start() {
//        // Call #add to add a new GLM. This also adds a corresponding entry in global_loot_modifiers.json.
//        add(
//                // The name of the modifier. This will be the file name.
//                "my_loot_modifier_instance",
//
//                // The loot modifier to add. For the sake of example, we add a weather loot condition.
//                new MyLootModifier(
//                        new LootItemCondition[] { WeatherCheck.weather().setRaining(true).build() },
//                        "somestring",
//                        10,
//                        Items.DIRT
//                ),
//
//                // A list of data load conditions. Note that these are unrelated to the loot conditions
//                // specified on the modifier itself. For the sake of example, we add a mod loaded condition.
//                // An overload of #add is available that accepts a vararg of conditions instead of a list.
//                List.of(new ModLoadedCondition(ExampleMod.MOD_ID))
//        );

        //crops

        add(
                "desert_well_tomato_modifier",
                new GastroARandomOverrideLootModifier(
                    new LootItemCondition[] {
                            LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("archaeology/desert_well")).build()
                    },
                    0.1f,
                    GastroAItems.TOMATO.get(),
                    1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );

        add(
                "desert_pyramid_tomato_modifier",
                new GastroARandomOverrideLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("archaeology/desert_pyramid")).build()
                        },
                        0.05f,
                        GastroAItems.TOMATO.get(),
                        1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );

        add(
                "trailruins_common_cassava_modifier",
                new GastroARandomOverrideLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("archaeology/trail_ruins_common")).build()
                        },
                        0.05f,
                        GastroAItems.CASSAVA.get(),
                        1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );

        add(
                "oceanruins_warm_cassava_modifier",
                new GastroARandomOverrideLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("archaeology/ocean_ruin_warm")).build()
                        },
                        0.05f,
                        GastroAItems.CASSAVA.get(),
                        1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );

        add(
                "sniffer_dig_pepper_modifier",
                new GastroARandomOverrideLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/sniffer_digging")).build()
                        },
                        0.2f,
                        GastroAItems.PEPPER.get(),
                        1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );



        //recipes



        add(
                "oceanruins_cold_recipe_modifier",
                new GastroARandomOverrideLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("archaeology/ocean_ruin_warm")).build()
                        },
                        0.03f,
                        GastroAItems.YOGURT_RECIPE.get(),
                        1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );

        add(
                "desert_pyramid_recipe_modifier",
                new GastroARandomOverrideLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("archaeology/desert_pyramid")).build()
                        },
                        0.03f,
                        GastroAItems.PIZZA_RECIPE.get(),
                        1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );

        add(
                "trailruins_rare_recipe_modifier",
                new GastroARandomOverrideLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("archaeology/trail_ruins_rare")).build()
                        },
                        0.03f,
                        GastroAItems.TAPIOCA_RECIPE.get(),
                        1, 1
                ),
                List.of(new ModLoadedCondition(Gastroarchaeology.MOD_ID))
        );

    }
}