package net.example.magik;

import com.mojang.logging.LogUtils;
import net.example.magik.block.ModBlocks;
import net.example.magik.item.ModItems;
import net.example.magik.item.ModitemGroup;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
// The value here should match an entry in the META-INF/mods.toml file
@Mod(Magik.MOD_ID)
public class Magik {
    public static final String MOD_ID = "magik";
    public static final Logger LOGGER = LogUtils.getLogger();


    public Magik(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModitemGroup.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

     void addCreative(BuildCreativeModeTabContentsEvent event) {
    if(event.getTabKey() == CreativeModeTabs.COMBAT){
        event.accept(ModItems.MAGICWAND);
    }
    if (event.getTabKey() == CreativeModeTabs.COMBAT){
        event.accept(ModItems.MIDMAGICWAND);
    }
    if (event.getTabKey() == CreativeModeTabs.COMBAT){
            event.accept(ModItems.HIGHMAGICWAND);
    }
    if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.MAGICORE);
    }
    if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.ENCHANTEDWOOL);
    }
    if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
             event.accept(ModItems.MAGIBOOK);
    }
    if (event.getTabKey() == CreativeModeTabs.COMBAT){
             event.accept(ModItems.MAGIHELM);
    }
    if (event.getTabKey() == CreativeModeTabs.COMBAT){
             event.accept(ModItems.MAGICHESTPLATE);
    }
    if (event.getTabKey() == CreativeModeTabs.COMBAT){
             event.accept(ModItems.MAGIPANTS);
    }
    if (event.getTabKey() == CreativeModeTabs.COMBAT){
             event.accept(ModItems.MAGIBOOTS);
    }

    if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
             event.accept(ModItems.MAGIWOOD);
    }
    if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
             event.accept(ModItems.MAGIORE);
    }
    if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
             event.accept(ModBlocks.MAGI_BLOCK);
    }

     }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
