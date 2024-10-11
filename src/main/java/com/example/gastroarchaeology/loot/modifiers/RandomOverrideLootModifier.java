package com.example.gastroarchaeology.loot.modifiers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class RandomOverrideLootModifier extends LootModifier {

    public static final MapCodec<RandomOverrideLootModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            // LootModifier#codecStart adds the conditions field.
            LootModifier.codecStart(inst).and(inst.group(
                    Codec.FLOAT.fieldOf("chance").forGetter(e -> e.chance),
                    BuiltInRegistries.ITEM.byNameCodec().fieldOf("replacement_item").forGetter(e -> e.replacementItem),
                    Codec.INT.fieldOf("min_count").forGetter(e -> e.minCount),
                    Codec.INT.fieldOf("max_count").forGetter(e -> e.maxCount)
            )).apply(inst, RandomOverrideLootModifier::new)
    );

    // Our extra properties.
    private final float chance;
    private final Item replacementItem;
    private final int minCount;
    private final int maxCount;

    // First constructor parameter is the list of conditions. The rest is our extra properties.
    public RandomOverrideLootModifier(LootItemCondition[] conditions, float chance, Item replacement_item, int min_count, int max_count) {
        super(conditions);
        this.chance = chance;
        this.replacementItem = replacement_item;
        this.minCount = min_count;
        this.maxCount = max_count;
    }

    // Return our codec here.
    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

    // This is where the magic happens. Use your extra properties here if needed.
    // Parameters are the existing loot, and the loot context.
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        RandomSource rn = context.getRandom();
        //if it doesn't roll for replacement
        if (rn.nextFloat() > this.chance) return generatedLoot;

        generatedLoot.clear();
        ItemStack replacementStack = new ItemStack(replacementItem);
        replacementStack.setCount(rn.nextIntBetweenInclusive(this.minCount, this.maxCount));
        generatedLoot.add(replacementStack);
        return generatedLoot;
    }

}