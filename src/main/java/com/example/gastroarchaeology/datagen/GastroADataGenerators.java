package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.compat.GastroAChickensaursItemModelProvider;
import com.example.gastroarchaeology.compat.GastroAChickensaursRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Gastroarchaeology.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class GastroADataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(GastroABlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        BlockTagsProvider blockTagsProvider = new GastroABlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new GastroAItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new GastroAItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new GastroABlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new GastroARecipeProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), new GastroADataMapProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), new GastroAGlobalLootModifierProvider(packOutput, lookupProvider));

        if (ModList.get().isLoaded("chickensaurs")){
            generator.addProvider(event.includeServer(), new GastroAChickensaursItemModelProvider(packOutput, existingFileHelper));
            generator.addProvider(event.includeServer(), new GastroAChickensaursRecipeProvider(packOutput, lookupProvider));
        }

    }
}
