package com.example.gastroarchaeology;

import com.example.gastroarchaeology.block.GastroABlocks;
import com.example.gastroarchaeology.effect.GatroAMobEffects;
import com.example.gastroarchaeology.item.GastroAItems;
import com.example.gastroarchaeology.loot.modifiers.GastroALootModifiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Gastroarchaeology.MOD_ID)
public class Gastroarchaeology
{
    public static final String MOD_ID = "gastroarchaeology";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GASTROARCHEOLOGY_TAB = CREATIVE_MODE_TABS.register("gastroarchaeology_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.gastroarchaeology"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> new ItemStack(GastroAItems.PEPPER.get()))
            .displayItems((parameters, output) -> {
                output.accept(new ItemStack(GastroAItems.CASSAVA.get()));
                output.accept(new ItemStack(GastroAItems.BAKED_CASSAVA.get()));
                output.accept(new ItemStack(GastroAItems.CRUSHED_CASSAVA.get()));
                output.accept(new ItemStack(GastroAItems.CASSAVA_DOUGH.get()));
                output.accept(new ItemStack(GastroAItems.TAPIOCA_DOUGH.get()));
                output.accept(new ItemStack(GastroAItems.PEPPER.get()));
                output.accept(new ItemStack(GastroAItems.TOMATO.get()));
                output.accept(new ItemStack(GastroAItems.CURD_BUCKET.get()));
                output.accept(new ItemStack(GastroAItems.CURD_MIXTURE.get()));
                output.accept(new ItemStack(GastroAItems.CHEESE.get()));
                output.accept(new ItemStack(GastroABlocks.SPICY_CHIPS.get()));
                output.accept(new ItemStack(GastroABlocks.EXTRA_SPICY_CHIPS.get()));
                output.accept(new ItemStack(GastroAItems.TAPIOCA_RECIPE.get()));
                output.accept(new ItemStack(GastroAItems.TAPIOCA_BEEF_WRAP.get()));
                output.accept(new ItemStack(GastroAItems.TAPIOCA_CHEESE_WRAP.get()));
                output.accept(new ItemStack(GastroAItems.TAPIOCA_HAM_AND_CHEESE_WRAP.get()));
                output.accept(new ItemStack(GastroAItems.YOGURT_RECIPE.get()));
                output.accept(new ItemStack(GastroAItems.SWEET_BERRY_YOGURT.get()));
                output.accept(new ItemStack(GastroAItems.GLOW_BERRY_YOGURT.get()));
                output.accept(new ItemStack(GastroAItems.HONEY_CARROT_YOGURT.get()));
                output.accept(new ItemStack(GastroAItems.CHORUS_FRUIT_YOGURT.get()));
                output.accept(new ItemStack(GastroAItems.PIZZA_RECIPE.get()));
                output.accept(new ItemStack(GastroABlocks.PIZZA.get()));
                output.accept(new ItemStack(GastroABlocks.BRAZILIAN_PIZZA.get()));
            })
            .build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Gastroarchaeology(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        CREATIVE_MODE_TABS.register(modEventBus);

        GastroAItems.register(modEventBus);
        GastroABlocks.register(modEventBus);
        GatroAMobEffects.register(modEventBus);
        GastroALootModifiers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, GastroAConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) event.accept(EXAMPLE_BLOCK_ITEM);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }

    public static ResourceLocation fromPath(String path){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
