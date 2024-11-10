package com.example.gastroarchaeology.compat;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.example.gastroarchaeology.effect.GastroAMobEffects;
import com.example.gastroarchaeology.item.RecipeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GastroAMineconRuins {
    public static final DeferredRegister.Items MINECON_RUINS_ITEMS = DeferredRegister.createItems(Gastroarchaeology.MOD_ID);

    public static final DeferredItem<Item> MINECON_RECIPE = MINECON_RUINS_ITEMS.register(
            "minecon_recipe", RecipeItem::new
    );

    public static final DeferredItem<Item> MINECON_BURGUER = MINECON_RUINS_ITEMS.register(
            "minecon_burguer", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.6F)
                            .build())
            )
    );

    public static final DeferredItem<Item> MINECON_TACO = MINECON_RUINS_ITEMS.register(
            "minecon_taco", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.6F)
                            .build())
            )
    );

    public static final DeferredItem<Item> MINECON_PIZZA_SLICE = MINECON_RUINS_ITEMS.register(
            "minecon_pizza_slice", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.6F)
                            .build())
            )
    );

    public static final DeferredItem<Item> MINECON_HOT_WINGS = MINECON_RUINS_ITEMS.register(
            "minecon_hot_wings", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.6F)
                            .effect(() -> new MobEffectInstance(GastroAMobEffects.BURNING, 19, 1), 1F)
                            .build())
            )
    );

    public static final DeferredItem<Item> MINECON_WAFFLE = MINECON_RUINS_ITEMS.register(
            "minecon_waffle", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.6F)
                            .build())
            )
    );

    public static void register(IEventBus eventBus) {
        MINECON_RUINS_ITEMS.register(eventBus);
    }
}
