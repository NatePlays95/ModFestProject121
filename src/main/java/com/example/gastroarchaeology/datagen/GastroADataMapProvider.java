package com.example.gastroarchaeology.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

public class GastroADataMapProvider extends DataMapProvider {
    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    protected GastroADataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    /**
     * Generate data map entries.
     */
    @Override
    protected void gather() {
//        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
//                .add(ModItems.NULBERRY.getKey(), new FurnaceFuel(20), false);
    }
}
