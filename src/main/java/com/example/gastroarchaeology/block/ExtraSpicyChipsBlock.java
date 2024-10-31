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
    public static final VoxelShape SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 5.0, 13.0);

    public ExtraSpicyChipsBlock(Properties properties) {
        super(properties);
    }

    protected float chanceForSpicyChip() {
        return 1f/6f;
    };

    protected int spiceEffectLevel() {
        return 4;
    }

    protected int spiceEffectDuration() {
        return 150;
    }


    @Override
    public int getMaxBites() {
        return 7;
    }

    @Override
    public boolean canAlwaysEat() {
        return true;
    }

    @Override
    public int getBiteFullness() {
        return 1;
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
        if(result == InteractionResult.SUCCESS && level.getRandom().nextFloat() < this.chanceForSpicyChip())
            player.addEffect(new MobEffectInstance(GatroAMobEffects.BURNING, this.spiceEffectDuration(), this.spiceEffectLevel()));
        return result;
    }
}
