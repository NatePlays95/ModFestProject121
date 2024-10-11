package com.example.gastroarchaeology.item;

import com.example.gastroarchaeology.ExampleMod;
import com.example.gastroarchaeology.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MOD_ID);

    public static final DeferredItem<Item> CASSAVA = ITEMS.register(
            "cassava",
            () -> new ItemNameBlockItem(
                    ModBlocks.CASSAVAS.get(),
                    new Item.Properties().food(Foods.POTATO)
            )
    );
    public static final DeferredItem<Item> PEPPER = ITEMS.register(
            "pepper",
            () -> new ItemNameBlockItem(
                    ModBlocks.PEPPERS.get(),
                    new Item.Properties().food(Foods.POTATO)
            )
    );
    public static final DeferredItem<Item> TOMATO = ITEMS.register(
            "tomato",
            () -> new ItemNameBlockItem(
                    ModBlocks.TOMATOES.get(),
                    new Item.Properties()
                            .food(Foods.POTATO)
            )
    );

//    public static final DeferredItem<Item> EARTH_CRYSTAL = ITEMS.register("earth_crystal",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> MALACHITE_CHUNK = ITEMS.register("machalite_chunk",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> MALACHITE_INGOT = ITEMS.register("machalite_ingot",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> NULBERRY = ITEMS.register("nulberry",
//            () -> new NulberryItem(new Item.Properties()) {
//                @Override
//                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//                    tooltipComponents.add(Component.literal("Eat to remove status effects.").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
//                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//                }
//            }
//
//    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
