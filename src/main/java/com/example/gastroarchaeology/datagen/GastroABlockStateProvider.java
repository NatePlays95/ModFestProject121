package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.Gastroarchaeology;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class GastroABlockStateProvider extends BlockStateProvider {
    public GastroABlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Gastroarchaeology.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        blockWithItem(ModBlocks.EARTH_CRYSTAL_ORE);
//        blockWithItem(ModBlocks.MACHALITE_ORE);
//        blockWithItem(ModBlocks.MACHALITE_BLOCK);
//        blockWithItem(ModBlocks.MAGIC_BLOCK);
////        blockWithItem(ModBlocks.NULBERRY_BUSH);
//
//        stairsBlock(ModBlocks.MACHALITE_STAIRS.get(), blockTexture(ModBlocks.MACHALITE_BLOCK.get()));
//        slabBlock(ModBlocks.MACHALITE_SLAB.get(), blockTexture(ModBlocks.MACHALITE_BLOCK.get()), blockTexture(ModBlocks.MACHALITE_BLOCK.get()));
//        buttonBlock(ModBlocks.MACHALITE_BUTTON.get(), blockTexture(ModBlocks.MACHALITE_BLOCK.get()));
//        pressurePlateBlock(ModBlocks.MACHALITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MACHALITE_BLOCK.get()));
//        fenceBlock(ModBlocks.MACHALITE_FENCE.get(), blockTexture(ModBlocks.MACHALITE_BLOCK.get()));
//        fenceGateBlock(ModBlocks.MACHALITE_FENCE_GATE.get(), blockTexture(ModBlocks.MACHALITE_BLOCK.get()));
//        wallBlock(ModBlocks.MACHALITE_WALL.get(), modLoc("block/machalite_block"));
//
//        doorBlockWithRenderType(ModBlocks.MACHALITE_DOOR.get(),
//                modLoc("block/machalite_door_bottom"), modLoc("block/machalite_door_top"), "cutout");
//        trapdoorBlockWithRenderType(ModBlocks.MACHALITE_TRAPDOOR.get(),
//                modLoc("block/machalite_trapdoor"), true, "cutout");
//
//        blockItem(ModBlocks.MACHALITE_STAIRS);
//        blockItem(ModBlocks.MACHALITE_SLAB);
//        blockItem(ModBlocks.MACHALITE_PRESSURE_PLATE);
//        blockItem(ModBlocks.MACHALITE_FENCE_GATE);
//        blockItem(ModBlocks.MACHALITE_TRAPDOOR, "_bottom");
//        blockItem(ModBlocks.MACHALITE_DOOR);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(Gastroarchaeology.MOD_ID + ":block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(Gastroarchaeology.MOD_ID + ":block/" + deferredBlock.getId().getPath() + appendix));
    }
}
