package com.example.gastroarchaeology.block;

import com.example.gastroarchaeology.effect.GatroAMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ExtraSpicyChipsBlock extends PlaceableFoodBlock{
    public static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 5.0, 15.0);

    public ExtraSpicyChipsBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxBites() {
        return 8;
    }

    @Override
    public boolean canAlwaysEat() {
        return true;
    }

    @Override
    public int getBiteFullness() {
        return 0;
    }

    @Override
    public float getBiteSaturation() {
        return 0.1f;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.GENERIC_EAT;
    }

    @Override
    public VoxelShape getShapeByBite(BlockState state) {
        return SHAPE;
    }

    @Override
    protected InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        InteractionResult result = super.eat(level, pos, state, player);
        if(result == InteractionResult.SUCCESS && level.getRandom().nextIntBetweenInclusive(10, 18) == 13)
            player.addEffect(new MobEffectInstance(GatroAMobEffects.BURNING, 400, 3));
        return result;
    }
}
