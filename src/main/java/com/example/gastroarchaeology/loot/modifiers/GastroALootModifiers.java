package com.example.gastroarchaeology.loot.modifiers;

import com.example.gastroarchaeology.Gastroarchaeology;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class GastroALootModifiers {

	public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS =
			DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Gastroarchaeology.MOD_ID);



	public static final Supplier<MapCodec<GastroALootModifier>> MY_LOOT_MODIFIER =
			GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("my_loot_modifier", () -> GastroALootModifier.CODEC);
	public static final Supplier<MapCodec<GastroARandomOverrideLootModifier>> RANDOM_OVERRIDE_LOOT_MODIFIER =
			GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("random_override_loot_modifier", () -> GastroARandomOverrideLootModifier.CODEC);

	public static void register(IEventBus eventBus) {
		GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(eventBus);
	}
}
