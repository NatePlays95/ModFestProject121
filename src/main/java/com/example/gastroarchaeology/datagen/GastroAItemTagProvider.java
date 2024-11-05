package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.compat.GastroAChickensaurs;
import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GastroAItemTagProvider extends ItemTagsProvider {

    public GastroAItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Gastroarchaeology.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(GastroAItems.CASSAVA.get())
                .add(GastroAItems.PEPPER.get())
                .add(GastroAItems.TOMATO.get());

        tag(Tags.Items.CROPS)
                .add(GastroAItems.CASSAVA.get())
                .add(GastroAItems.PEPPER.get())
                .add(GastroAItems.TOMATO.get());

        tag(Tags.Items.FOODS)
                .add(GastroAItems.CASSAVA.get())
                .add(GastroAItems.BAKED_CASSAVA.get())
                .add(GastroAItems.CASSAVA_FLOUR.get())
                .add(GastroAItems.PEPPER.get())
                .add(GastroAItems.TOMATO.get())
                .add(GastroAItems.CURD_BUCKET.get())
                .add(GastroAItems.CHEESE.get())
                .add(GastroAItems.TAPIOCA_BEEF_WRAP.get())
                .add(GastroAItems.TAPIOCA_CHEESE_WRAP.get())
                .add(GastroAItems.TAPIOCA_HAM_AND_CHEESE_WRAP.get())
                .add(GastroAItems.BEEF_PACOCA.get())
                .add(GastroAItems.PORK_PACOCA.get())
                .add(GastroAItems.CHICKEN_PACOCA.get())
                .add(GastroAItems.FISH_PACOCA.get())
                .add(GastroAChickensaurs.CHICKENSAUR_PACOCA.get())
                .add(GastroAItems.SWEET_BERRY_YOGURT.get())
                .add(GastroAItems.GLOW_BERRY_YOGURT.get())
                .add(GastroAItems.HONEY_CARROT_YOGURT.get())
                .add(GastroAItems.CHORUS_FRUIT_YOGURT.get());

        tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
                .add(GastroABlocks.PIZZA.asItem())
                .add(GastroABlocks.BRAZILIAN_PIZZA.asItem())
                .add(GastroABlocks.SPICY_CHIPS.asItem())
                .add(GastroABlocks.EXTRA_SPICY_CHIPS.asItem());
//        tag(ModTags.Items.TRANSFORMABLE_ITEM.TAPIOCA_CHEESE_WRAP.get())));
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
