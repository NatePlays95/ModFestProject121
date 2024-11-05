package com.example.gastroarchaeology.compat;

import com.example.gastroarchaeology.Gastroarchaeology;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GastroAChickensaurs {

    public static final DeferredRegister.Items CHICKENSAURS_ITEMS = DeferredRegister.createItems(Gastroarchaeology.MOD_ID);

    public static final DeferredItem<Item> CHICKENSAUR_PACOCA = CHICKENSAURS_ITEMS.register(
            "chickensaur_pacoca", () -> new Item(
                    new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.6F)
                            .fast()
                            .build())
            )
    );

    public static void register(IEventBus eventBus) {
        CHICKENSAURS_ITEMS.register(eventBus);
    }
}
