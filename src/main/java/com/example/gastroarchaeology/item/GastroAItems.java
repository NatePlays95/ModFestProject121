package com.example.gastroarchaeology.item;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.effect.GatroAMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GastroAItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gastroarchaeology.MOD_ID);

    public static final DeferredItem<Item> CASSAVA = ITEMS.register(
            "cassava",
            () -> new ItemNameBlockItem(
                    GastroABlocks.CASSAVAS.get(),
                    new Item.Properties().food(new FoodProperties.Builder()
                                        .nutrition(1)
                                        .saturationModifier(0.3f)
                                        .effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 0), 0.5F)
                                        .build())
            )
    );
    public static final DeferredItem<Item> PEPPER = ITEMS.register(
            "pepper",
            () -> new ItemNameBlockItem(
                    GastroABlocks.PEPPERS.get(),
                    new Item.Properties().food(new FoodProperties.Builder()
                                        .fast()
                                        .effect(() -> new MobEffectInstance(GatroAMobEffects.BURNING, 60, 1), 1F)
                                        .build())
            )
    );
    public static final DeferredItem<Item> TOMATO = ITEMS.register(
            "tomato",
            () -> new ItemNameBlockItem(
                    GastroABlocks.TOMATOES.get(),
                    new Item.Properties().food(new FoodProperties.Builder()
                                        .nutrition(1)
                                        .saturationModifier(0.1f)
                                        .build())
            )
    );



    public static final DeferredItem<Item> CURD_BUCKET = ITEMS.register(
            "curd_bucket", () -> new Item(new Item.Properties()
                    .craftRemainder(Items.BUCKET).stacksTo(1)
            )
    );
    public static final DeferredItem<Item> CURD_MIXTURE = ITEMS.register(
            "curd_mixture", () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> CHEESE = ITEMS.register(
            "cheese", () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build())
            )
    );

    //cheese wheel, placeable, itemnameblockitem
    //pizza, placeable, itemnameblockitem

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
