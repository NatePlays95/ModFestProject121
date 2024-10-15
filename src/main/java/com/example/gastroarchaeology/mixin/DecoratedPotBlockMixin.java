package com.example.gastroarchaeology.mixin;

import com.example.gastroarchaeology.item.GastroAItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(DecoratedPotBlock.class)
public abstract class DecoratedPotBlockMixin {

    private static final Logger LOGGER = LogUtils.getLogger();

    @Inject(method = "useItemOn", at = @At("HEAD"), cancellable = true)
    public void onUseItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<ItemInteractionResult> info) {
        if (!level.isClientSide()) {
            // Schedule a tick for this block
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof DecoratedPotBlockEntity potEntity) {
                if (stack.is(Items.MILK_BUCKET) && potEntity.getTheItem().isEmpty()) {
                    stack.setCount(0);
                    player.setItemInHand(hand, new ItemStack(GastroAItems.CURD_BUCKET.get()));
                    info.setReturnValue(ItemInteractionResult.CONSUME);
                }
            }
        }
    }



//    @Inject(method = "useItemOn", at = @At("HEAD"))
//    public void onUseItemOn(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving, CallbackInfo ci) {
//        if (!world.isClientSide()) {
//            // Schedule a tick for this block
//            world.scheduleTick(pos, state.getBlock(), 20);  // 20 ticks = 1 second
//        }
//    }
//
//    @Inject(method = "tick", at = @At("HEAD"))
//    public void onTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random, CallbackInfo ci) {
//        // Custom tick behavior
//        LOGGER.debug("Scheduled tick for DecoratedPotBlock at {}", pos);
//
//        // Re-schedule another tick in 20 game ticks (1 second)
//        world.scheduleTick(pos, state.getBlock(), 20);
//    }

//    private void potBlockAddCurd(DecoratedPotBlock potBlock, BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
//        // Custom logic for changing the pot's contents during a random tick
//        LOGGER.debug("b");
//        if (!level.isClientSide()) {
//            LOGGER.debug("c");
//            BlockEntity blockEntity = level.getBlockEntity(pos);
//            if (blockEntity instanceof DecoratedPotBlockEntity potEntity) {
//                LOGGER.debug("d");
//                ItemStack itemStack = potEntity.getTheItem();
//                if (!itemStack.isEmpty() && itemStack.is(Items.MILK_BUCKET)) {
//                    potEntity.setTheItem(new ItemStack(GastroAItems.CURD_BUCKET.get()));
//
//                    Vec3 centerPos = pos.getCenter();
//                    level.addParticle(
//                            ParticleTypes.HAPPY_VILLAGER,
//                            centerPos.x(), centerPos.y() + 0.6, centerPos.z(),
//                            0, 0, 0
//                    );
//                }
//            }
//        }
//    }
}