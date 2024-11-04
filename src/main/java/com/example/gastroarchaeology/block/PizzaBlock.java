package com.example.gastroarchaeology.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PizzaBlock extends PlaceableFoodBlock {

	public static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);

	int fullness;
	float saturation;

	public PizzaBlock(Properties properties, int fullness, float saturation) {
		super(properties);
		this.fullness = fullness;
		this.saturation = saturation;
	}

	@Override
	public int getMaxBites() {
		return 3;
	}

	@Override
	public boolean canAlwaysEat() {
		return false;
	}

	/**
	 * How many hunger bars a bite of this food fills. Max is 20.
	 */
	@Override
	public int getBiteFullness() {
		return fullness;
	}

	@Override
	public float getBiteSaturation() {
		return saturation;
	}

	@Override
	public SoundEvent getEatSound() {
		return SoundEvents.GENERIC_EAT;
	}

	//TODO: make a shapes array and choose the shape according to bite.
	@Override
	public VoxelShape getShapeByBite(BlockState state) {
//		return Shapes.block();
		return SHAPE;
	}
}
