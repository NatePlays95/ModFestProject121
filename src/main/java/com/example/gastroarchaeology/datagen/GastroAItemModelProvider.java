package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.compat.GastroAChickensaurs;
import com.example.gastroarchaeology.compat.GastroAMineconRuins;
import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class GastroAItemModelProvider extends ItemModelProvider {
    public GastroAItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Gastroarchaeology.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(GastroAItems.CASSAVA.get());
        basicItem(GastroAItems.BAKED_CASSAVA.get());
        basicItem(GastroAItems.CRUSHED_CASSAVA.get());
        basicItem(GastroAItems.CASSAVA_DOUGH.get());
        basicItem(GastroAItems.CASSAVA_FLOUR.get());
        basicItem(GastroAItems.TAPIOCA_DOUGH.get());
        basicItem(GastroAItems.PEPPER.get());
        basicItem(GastroAItems.TOMATO.get());
        basicItem(GastroAItems.CURD_BUCKET.get());
        basicItem(GastroAItems.CURD_MIXTURE.get());
        basicItem(GastroAItems.CHEESE.get());
        basicItem(GastroABlocks.SPICY_CHIPS.asItem());
        basicItem(GastroABlocks.EXTRA_SPICY_CHIPS.asItem());
        basicItem(GastroAItems.TAPIOCA_BEEF_WRAP.get());
        basicItem(GastroAItems.TAPIOCA_CHEESE_WRAP.get());
        basicItem(GastroAItems.TAPIOCA_HAM_AND_CHEESE_WRAP.get());
        basicItem(GastroAItems.BEEF_PACOCA.get());
        basicItem(GastroAItems.PORK_PACOCA.get());
        basicItem(GastroAItems.CHICKEN_PACOCA.get());
        basicItem(GastroAItems.FISH_PACOCA.get());
        basicItem(GastroAItems.SWEET_BERRY_YOGURT.get());
        basicItem(GastroAItems.GLOW_BERRY_YOGURT.get());
        basicItem(GastroAItems.HONEY_CARROT_YOGURT.get());
        basicItem(GastroAItems.CHORUS_FRUIT_YOGURT.get());
        basicItem(GastroABlocks.PIZZA.asItem());
        basicItem(GastroABlocks.BRAZILIAN_PIZZA.asItem());

        // Compat
        basicItem(GastroAChickensaurs.CHICKENSAUR_PACOCA.get());
        basicItem(GastroAMineconRuins.MINECON_BURGUER.get());
        basicItem(GastroAMineconRuins.MINECON_TACO.get());
        basicItem(GastroAMineconRuins.MINECON_PIZZA_SLICE.get());
        basicItem(GastroAMineconRuins.MINECON_HOT_WINGS.get());
        basicItem(GastroAMineconRuins.MINECON_WAFFLE.get());

//        basicItem(GastroAItems.TAPIOCA_RECIPE.get());
//        basicItem(GastroAItems.YOGURT_RECIPE.get());
//        basicItem(GastroAItems.PIZZA_RECIPE.get());


//        basicItem(ModItems.EARTH_CRYSTAL.get());
//        basicItem(ModItems.MALACHITE_CHUNK.get());
//        basicItem(ModItems.MALACHITE_INGOT.get());
//        basicItem(ModItems.NULBERRY.get());
////        basicItem(ModItems.CHISEL.get()); //custom model in assets folder
//
//        buttonItem(ModBlocks.MACHALITE_BUTTON, ModBlocks.MACHALITE_BLOCK);
//        fenceItem(ModBlocks.MACHALITE_FENCE, ModBlocks.MACHALITE_BLOCK);
//        wallItem(ModBlocks.MACHALITE_WALL, ModBlocks.MACHALITE_BLOCK);
//
//        basicItem(ModBlocks.MACHALITE_DOOR.asItem());
//
//        handheldItem(ModItems.MACHALITE_SWORD);
//
//        withExistingParent(ModItems.MOSSWINE_SPAWN_EGG.getRegisteredName(), mcLoc("item/template_spawn_egg"));


    }


    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Gastroarchaeology.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Gastroarchaeology.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Gastroarchaeology.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private void handheldItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(), ResourceLocation.parse("item/handheld"))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    private void armorItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(), ResourceLocation.parse("item/handheld"))
                .texture("layer0", modLoc("item/armor/" + item.getId().getPath()));
    }




}
