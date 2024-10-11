package com.example.gastroarchaeology.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BurningMobEffect extends GatroAMobEffects.GastroAMobEffect {
    public BurningMobEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void onEffectAdded(LivingEntity livingEntity, int amplifier) {
        super.onEffectAdded(livingEntity, amplifier);
        livingEntity.setRemainingFireTicks(amplifier * 20);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }
}
