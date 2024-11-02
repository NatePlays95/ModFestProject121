package com.example.gastroarchaeology.mixin;

import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DecoratedPotBlock.class)
public abstract class DecoratedPotBlockMixin extends BaseEntityBlock {
    protected DecoratedPotBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState blockState) {
        return true;
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(10) == 0 && !serverLevel.isClientSide()) {
            BlockEntity blockEntity = serverLevel.getBlockEntity(blockPos);
            if (blockEntity instanceof DecoratedPotBlockEntity potEntity) {
                ItemStack itemStack = potEntity.getTheItem();
                if (!itemStack.isEmpty() && itemStack.is(Items.MILK_BUCKET)) {
                    potEntity.setTheItem(itemStack.transmuteCopy(GastroAItems.CURD_BUCKET.get()));

                    Vec3 centerPos = blockPos.getCenter();
                    serverLevel.addParticle(
                            ParticleTypes.HAPPY_VILLAGER,
                            centerPos.x(), centerPos.y() + 0.6, centerPos.z(),
                            0, 0, 0
                    );
                }
            }
        }
        
        super.randomTick(blockState, serverLevel, blockPos, randomSource);
    }
}