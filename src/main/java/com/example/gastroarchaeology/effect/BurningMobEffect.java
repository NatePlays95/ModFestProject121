package com.example.gastroarchaeology.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BurningMobEffect extends GatroAMobEffects.GastroAMobEffect {
    public BurningMobEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (true || entity.getHealth() > 1.0F) {
            entity.hurt(entity.damageSources().onFire(), amplifier);
        }

        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount % 20 == 0;
    }
}
