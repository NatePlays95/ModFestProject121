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

    // Crops
    public static final DeferredBlock<CassavaBlock> CASSAVAS = registerBlock(
            "cassavas",
            () -> new CassavaBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)
            ),
            null
    );
    public static final DeferredBlock<TomatoBlock> TOMATOES = registerBlock(
            "tomatoes",
            () -> new TomatoBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)
            ),
            null
    );
    public static final DeferredBlock<PepperBlock> PEPPERS = registerBlock(
            "peppers",
            () -> new PepperBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)

            ),
            null
    );

    // Placeable foods
    public static final DeferredBlock<PizzaBlock> PIZZA = registerBlock(
            "pizza",
            () -> new PizzaBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .forceSolidOn(),
                    6, 0.3F
            ),
            new Item.Properties()
                    .stacksTo(1)
    );
    public static final DeferredBlock<PizzaBlock> BRAZILIAN_PIZZA = registerBlock(
            "brazilian_pizza",
            () -> new PizzaBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .forceSolidOn(),
                    10, 0.7F
            ),
            new Item.Properties()
                    .stacksTo(1)
    );
    public static final DeferredBlock<SpicyChipsBlock> SPICY_CHIPS = registerBlock(
            "spicy_chips",
            () -> new SpicyChipsBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .forceSolidOn()
            ),
            new Item.Properties()
                    .stacksTo(1)
    );
    public static final DeferredBlock<ExtraSpicyChipsBlock> EXTRA_SPICY_CHIPS = registerBlock(
            "extra_spicy_chips",
            () -> new ExtraSpicyChipsBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .sound(SoundType.WOOL)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .forceSolidOn()
            ),
            new Item.Properties()
                    .stacksTo(1)
    );




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (itemProperties != null) {
            registerBlockItem(name, toReturn, itemProperties);
        }
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        GastroAItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Item.Properties itemProperties) {
        GastroAItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
