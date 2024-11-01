package com.example.gastroarchaeology.item;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.effect.GatroAMobEffects;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GastroAItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gastroarchaeology.MOD_ID);

    // Crops
    public static final DeferredItem<Item> CASSAVA = ITEMS.register(
            "cassava", () -> new ItemNameBlockItem(
                GastroABlocks.CASSAVAS.get(),
                new Item.Properties().food(new FoodProperties.Builder()
                        .nutrition(1)
                        .saturationModifier(0.3f)
                        .effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 0), 0.2F)
                        .build())
            )
    );
    public static final DeferredItem<Item> PEPPER = ITEMS.register(
            "pepper", () -> new ItemNameBlockItem(
                GastroABlocks.PEPPERS.get(),
                new Item.Properties().food(new FoodProperties.Builder()
                                    .fast()
                                    .effect(() -> new MobEffectInstance(GatroAMobEffects.BURNING, 60, 1), 1F)
                                    .build())
            )
    );
    public static final DeferredItem<Item> TOMATO = ITEMS.register(
            "tomato", () -> new ItemNameBlockItem(
                GastroABlocks.TOMATOES.get(),
                new Item.Properties().food(new FoodProperties.Builder()
                                    .nutrition(1)
                                    .saturationModifier(0.1f)
                                    .build())
            )
    );

    // Food
    public static final DeferredItem<Item> BAKED_CASSAVA = ITEMS.register(
            "baked_cassava", () -> new Item(
                new Item.Properties().food(new FoodProperties.Builder()
                        .nutrition(7)
                        .saturationModifier(0.7f)
                        .build())
            )
    );
    public static final DeferredItem<Item> CHEESE = ITEMS.register(
            "cheese", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationModifier(0.1f)
                            .build())
            )
    );
    public static final DeferredItem<Item> CURD_BUCKET = ITEMS.register(
            "curd_bucket", () -> new DrinkableItem(
                new Item.Properties()
                        .craftRemainder(Items.BUCKET)
                        .stacksTo(1)
                        .food(new FoodProperties.Builder()
                                .nutrition(2)
                                .saturationModifier(0.2f)
                                .usingConvertsTo(Items.BUCKET)
                                .build())
            )
    );
    public static final DeferredItem<Item> SWEET_BERRY_YOGURT = ITEMS.register(
            "sweet_berry_yogurt", () -> new DrinkableItem(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.3f)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .build())
            )
    );
    public static final DeferredItem<Item> GLOW_BERRY_YOGURT = ITEMS.register(
            "glow_berry_yogurt", () -> new DrinkableItem(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.3f)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .build())
            )
    );
    public static final DeferredItem<Item> HONEY_CARROT_YOGURT = ITEMS.register(
            "honey_carrot_yogurt", () -> new DrinkableItem(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(7)
                            .saturationModifier(0.7f)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .build())
            )
    );
    public static final DeferredItem<Item> CHORUS_FRUIT_YOGURT = ITEMS.register(
            "chorus_fruit_yogurt", () -> new DrinkableItem(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(6)
                            .saturationModifier(0.4f)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .build())
            )
    );
    public static final DeferredItem<Item> TAPIOCA_CHEESE_WRAP = ITEMS.register(
            "tapioca_cheese_wrap", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationModifier(0.3f)
                            .build())
            )
    );
    public static final DeferredItem<Item> TAPIOCA_BEEF_WRAP = ITEMS.register(
            "tapioca_beef_wrap", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(8)
                            .saturationModifier(0.9f)
                            .build())
            )
    );
    public static final DeferredItem<Item> TAPIOCA_HAM_AND_CHEESE_WRAP = ITEMS.register(
            "tapioca_ham_and_cheese_wrap", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(9)
                            .saturationModifier(0.9f)
                            .build())
            )
    );

    // Intermediaries
    public static final DeferredItem<Item> CURD_MIXTURE = ITEMS.register(
            "curd_mixture", () -> new Item(
                    new Item.Properties()
            )
    );
    public static final DeferredItem<Item> CASSAVA_DOUGH = ITEMS.register(
            "cassava_dough", () -> new Item(
                    new Item.Properties()
            )
    );
    public static final DeferredItem<Item> TAPIOCA_DOUGH = ITEMS.register(
            "tapioca_dough", () -> new Item(
                    new Item.Properties()
            )
    );
    public static final DeferredItem<Item> CRUSHED_CASSAVA = ITEMS.register(
            "crushed_cassava", () -> new Item(
                    new Item.Properties()
                            .craftRemainder(GastroAItems.TAPIOCA_DOUGH.get())
            )
    );

    // Recipes
    public static final DeferredItem<Item> YOGURT_RECIPE = ITEMS.register(
            "yogurt_recipe", RecipeItem::new
    );

    public static final DeferredItem<Item> PIZZA_RECIPE = ITEMS.register(
            "pizza_recipe", RecipeItem::new
    );

    public static final DeferredItem<Item> TAPIOCA_RECIPE = ITEMS.register(
            "tapioca_recipe", RecipeItem::new
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
