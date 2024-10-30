package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.block.CassavaBlock;
import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.block.PepperBlock;
import com.example.gastroarchaeology.block.TomatoBlock;
import com.example.gastroarchaeology.item.GastroAItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class GastroABlockLootTableProvider extends BlockLootSubProvider {
    protected GastroABlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(GastroABlocks.PIZZA.get(), block -> createSingleItemTable(Items.AIR));
        add(GastroABlocks.BRAZILIAN_PIZZA.get(), block -> createSingleItemTable(Items.AIR));
        add(GastroABlocks.SPICY_CHIPS.get(), block -> createSingleItemTable(Items.BOWL));
        add(GastroABlocks.EXTRA_SPICY_CHIPS.get(), block -> createSingleItemTable(Items.BOWL));

        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        LootItemCondition.Builder cassavaAgeCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GastroABlocks.CASSAVAS.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CassavaBlock.AGE, 7));
        LootItemCondition.Builder pepperAgeCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GastroABlocks.PEPPERS.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PepperBlock.AGE, 7));
        LootItemCondition.Builder tomatoAgeCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GastroABlocks.TOMATOES.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoBlock.AGE, 7));

        add(GastroABlocks.CASSAVAS.get(), block -> createCropNoSeedDrops(GastroABlocks.CASSAVAS.get(), GastroAItems.CASSAVA.get(),
                cassavaAgeCondition, enchantmentRegistryLookup));
        add(GastroABlocks.PEPPERS.get(), block -> createCropNoSeedDrops(GastroABlocks.PEPPERS.get(), GastroAItems.PEPPER.get(),
                pepperAgeCondition, enchantmentRegistryLookup));
        add(GastroABlocks.TOMATOES.get(), block -> createCropNoSeedDrops(GastroABlocks.TOMATOES.get(), GastroAItems.TOMATO.get(),
                tomatoAgeCondition, enchantmentRegistryLookup));

//        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

//        dropSelf(ModBlocks.MACHALITE_BLOCK.get());

//        add(ModBlocks.MACHALITE_SLAB.get(), block -> createSlabItemTable(ModBlocks.MACHALITE_SLAB.get()));
//        add(ModBlocks.MACHALITE_DOOR.get(), block -> createDoorTable(ModBlocks.MACHALITE_DOOR.get()));

//        dropSelf(ModBlocks.MAGIC_BLOCK.get());
//        dropSelf(ModBlocks.MAGIC_LEAF.get());
//
//        add(ModBlocks.EARTH_CRYSTAL_ORE.get(),
//            block -> createMultipleOreDrops(ModBlocks.EARTH_CRYSTAL_ORE.get(), ModItems.EARTH_CRYSTAL.get(), 1.0F, 3.0F));
//        add(ModBlocks.MACHALITE_ORE.get(),
//            block -> createOreDrop(ModBlocks.MACHALITE_ORE.get(), ModItems.MALACHITE_CHUNK.get()));

//        add(ModBlocks.NULBERRY_BUSH.get(),
//            block -> this.applyExplosionDecay(block, LootTable.lootTable()
//                .withPool(
//                    LootPool.lootPool()
//                        .when(
//                            LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.NULBERRY_BUSH.get())
//                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NulberryBushBlock.AGE, 3))
//                        )
//                        .add(LootItem.lootTableItem(ModItems.NULBERRY.get()))
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
//                        .apply(ApplyBonusCount.addUniformBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))
//                )
//                .withPool(
//                    LootPool.lootPool()
//                        .when(
//                            LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.NULBERRY_BUSH.get())
//                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NulberryBushBlock.AGE, 2))
//                        )
//                        .add(LootItem.lootTableItem(ModItems.NULBERRY.get()))
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
//                        .apply(ApplyBonusCount.addUniformBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))
//                )));
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                                //.apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(ModEnchantments.MINING_MASTER.get())))
                )
        );
    }

    protected LootTable.Builder createCropNoSeedDrops(CropBlock crop, Item cropItem, LootItemCondition.Builder cropAgeConditionBuilder, HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup) {
        return this.applyExplosionDecay(
            crop,
            LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(cropItem)))
                .withPool(
                    LootPool.lootPool()
                        .when(cropAgeConditionBuilder).add(
                            LootItem.lootTableItem(cropItem)
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))
                        )
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GastroABlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
