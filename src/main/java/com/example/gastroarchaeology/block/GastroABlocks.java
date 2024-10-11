package com.example.gastroarchaeology.block;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GastroABlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Gastroarchaeology.MOD_ID);


//    public static final DeferredBlock<Block> MACHALITE_BLOCK = registerBlock("machalite_block",
//            () -> new Block(
//                    BlockBehaviour.Properties.of().strength(4f,2f).sound(SoundType.METAL)
//                            .requiresCorrectToolForDrops()
//            ));
//
//    public static final DeferredBlock<StairBlock> MACHALITE_STAIRS = registerBlock("machalite_stairs",
//            () -> new StairBlock(ModBlocks.MACHALITE_BLOCK.get().defaultBlockState(),
//                    BlockBehaviour.Properties.of().strength(4f,2f).sound(SoundType.METAL)
//                            .requiresCorrectToolForDrops()
//            ));


    public static final DeferredBlock<Block> CASSAVAS = registerBlock(
            "cassavas",
            () -> new CassavaBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final DeferredBlock<Block> TOMATOES = registerBlock(
            "tomatoes",
            () -> new TomatoBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final DeferredBlock<Block> PEPPERS = registerBlock(
            "peppers",
            () -> new PepperBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        GastroAItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
