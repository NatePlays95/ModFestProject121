package com.example.gastroarchaeology;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class RegistryHelper {
    public static Item getItem (String stringID){
        return BuiltInRegistries.ITEM.get(ResourceLocation.parse(stringID));
    }
}
