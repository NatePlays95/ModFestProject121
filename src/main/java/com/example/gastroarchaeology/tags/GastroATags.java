package com.example.gastroarchaeology.tags;

import com.example.gastroarchaeology.Gastroarchaeology;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GastroATags {
    public static class Blocks {
//        public static final TagKey<Block> NEEDS_MACHALITE_TOOL = createTag("needs_machalite_tool");
//        public static final TagKey<Block> INCORRECT_FOR_MACHALITE_TOOL = createTag("incorrect_for_machalite_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Gastroarchaeology.MOD_ID, name));
        }
    }

    public static class Items {
//        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Gastroarchaeology.MOD_ID, name));
        }
    }

    //Tags for registries without syntax sugar
//    public static class Enchantments {
//        public static final TagKey<Enchantment> HAMMER_ENCHANTMENTS = createTag("hammer_enchantments");
//
//        private static TagKey<Enchantment> createTag(String name) {
//            return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name));
//        }
//    }

}
