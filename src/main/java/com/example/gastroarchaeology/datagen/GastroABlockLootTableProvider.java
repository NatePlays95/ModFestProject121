package com.example.gastroarchaeology.datagen;

import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.item.GastroAItems;
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
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class GastroABlockLootTableProvider extends BlockLootSubProvider {
    protected GastroABlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //TODO: Change these to crop-like loot tables
        dropOther(GastroABlocks.CASSAVAS.get(), GastroAItems.CASSAVA);
        dropOther(GastroABlocks.TOMATOES.get(), GastroAItems.TOMATO);
        dropOther(GastroABlocks.PEPPERS.get(), GastroAItems.PEPPER);

        add(GastroABlocks.PIZZA.get(), block -> createSingleItemTable(Items.AIR));

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

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GastroABlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
