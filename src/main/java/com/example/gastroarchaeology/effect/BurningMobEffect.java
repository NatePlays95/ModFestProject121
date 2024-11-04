package com.example.gastroarchaeology.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BurningMobEffect extends GatroAMobEffects.GastroAMobEffect {
	protected BurningMobEffect(MobEffectCategory pCategory, int pColor) {
		super(pCategory, pColor);
	}

	public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		float entityHealth = entity.getHealth();
		float nextHealth = entityHealth - amplifier;
		if (entityHealth > 1.0F) {
			entity.hurt(new DamageSource(entity.damageSources().damageTypes.getHolderOrThrow(DamageTypes.ON_FIRE)),
					nextHealth < 1.0F ? entityHealth - 1 : amplifier);
		}

		return true;
	}

	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return tickCount % 20 == 0;
	}
}
