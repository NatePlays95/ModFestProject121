package com.example.gastroarchaeology.loot.modifiers;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class GastroarchaeologyLootModifiers {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Gastroarchaeology.MOD_ID);



    public static final Supplier<MapCodec<GastroarchaeologyLootModifier>> MY_LOOT_MODIFIER =
            GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("my_loot_modifier", () -> GastroarchaeologyLootModifier.CODEC);
    public static final Supplier<MapCodec<RandomOverrideLootModifier>> RANDOM_OVERRIDE_LOOT_MODIFIER =
            GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("random_override_loot_modifier", () -> RandomOverrideLootModifier.CODEC);

    public static void register(IEventBus eventBus) {
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
