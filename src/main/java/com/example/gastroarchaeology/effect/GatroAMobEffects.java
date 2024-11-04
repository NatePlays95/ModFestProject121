package com.example.gastroarchaeology.effect;

import com.example.gastroarchaeology.Gastroarchaeology;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GatroAMobEffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Gastroarchaeology.MOD_ID);

	public static final DeferredHolder<MobEffect, MobEffect> BURNING = EFFECTS.register(
			"burning", () -> new BurningMobEffect(MobEffectCategory.HARMFUL, 0xC11B17)
	);

	public static void register(IEventBus eventBus) {
		EFFECTS.register(eventBus);
	}

	public static class GastroAMobEffect extends MobEffect {
		public GastroAMobEffect(MobEffectCategory pCategory, int pColor) {
			super(pCategory, pColor);
		}
	}
}
