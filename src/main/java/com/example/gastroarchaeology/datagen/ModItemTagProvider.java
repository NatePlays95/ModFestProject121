package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.ExampleMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(ModItems.EARTH_CRYSTAL.get())
//                .add(ModItems.MALACHITE_CHUNK.get())
//                .add(ModItems.MALACHITE_INGOT.get())
//                .add(Items.COAL)
//                .add(Items.DIAMOND);
//
//        tag(ItemTags.SWORDS).add(ModItems.MACHALITE_SWORD.get());
//        tag(ItemTags.PICKAXES).add(ModItems.MACHALITE_PICKAXE.get());
//        tag(ItemTags.SHOVELS).add(ModItems.MACHALITE_SHOVEL.get());
//        tag(ItemTags.AXES).add(ModItems.MACHALITE_AXE.get());
//        tag(ItemTags.HOES).add(ModItems.MACHALITE_HOE.get());
//
//        tag(ItemTags.DYEABLE)
//                .add(ModArmorItems.F_GHOST_HELM.get())
//                .add(ModArmorItems.F_GHOST_MAIL.get());
    }
}
