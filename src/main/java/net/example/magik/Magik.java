package net.example.magik;

import com.mojang.logging.LogUtils;
import net.example.magik.item.ModItems;
import net.example.magik.item.ModitemGroup;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
        ModitemGroup.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
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
