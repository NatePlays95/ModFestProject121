package com.example.gastroarchaeology.item;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.effect.GastroAMobEffects;
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
                                    .effect(() -> new MobEffectInstance(GastroAMobEffects.BURNING, 60, 1), 1F)
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
    public static final DeferredItem<Item> CASSAVA_FLOUR = ITEMS.register(
            "cassava_flour", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(1)
                            .fast()
                            .build())
            )
    );
    public static final DeferredItem<Item> BEEF_PACOCA = ITEMS.register(
            "beef_pacoca", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.8F)
                            .fast()
                            .build())
            )
    );
    public static final DeferredItem<Item> PORK_PACOCA = ITEMS.register(
            "pork_pacoca", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.8F)
                            .fast()
                            .build())
            )
    );
    public static final DeferredItem<Item> CHICKEN_PACOCA = ITEMS.register(
            "chicken_pacoca", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationModifier(0.6F)
                            .fast()
                            .build())
            )
    );
    public static final DeferredItem<Item> FISH_PACOCA = ITEMS.register(
            "fish_pacoca", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationModifier(0.5F)
                            .fast()
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
                            .nutrition(6)
                            .saturationModifier(0.5f)
                            .build())
            )
    );
    public static final DeferredItem<Item> TAPIOCA_BEEF_WRAP = ITEMS.register(
            "tapioca_beef_wrap", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(8)
                            .saturationModifier(1.0f)
                            .build())
            )
    );
    public static final DeferredItem<Item> TAPIOCA_HAM_AND_CHEESE_WRAP = ITEMS.register(
            "tapioca_ham_and_cheese_wrap", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(9)
                            .saturationModifier(1.0f)
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
                            .craftRemainder(GastroAItems.CASSAVA_DOUGH.get())
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

    public static final DeferredItem<Item> PACOCA_RECIPE = ITEMS.register(
            "pacoca_recipe", RecipeItem::new
    );

    //cheese wheel, placeable, itemnameblockitem
    //pizza, placeable, itemnameblockitem

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
