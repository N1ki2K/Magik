package net.example.magik.item;
import net.example.magik.Magik;
import net.example.magik.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModitemGroup {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Magik.MOD_ID);

    public static final RegistryObject<CreativeModeTab> wandTest = CREATIVE_MODE_TABS.register("magik",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MAGICWAND.get()))
                    .title(Component.translatable("creativetab.magik.magicwand_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MAGICWAND.get());
                        output.accept(ModItems.MIDMAGICWAND.get());
                        output.accept(ModItems.HIGHMAGICWAND.get());
                        output.accept(ModItems.ENCHANTEDWOOL.get());
                        output.accept(ModItems.MAGIBOOK.get());
                        output.accept(ModItems.MAGIORE.get());
                        output.accept(ModItems.MAGIWOOD.get());
                        output.accept(ModItems.MAGICESSENCE.get());
                        output.accept(ModItems.MAGICINGOT.get());
                        output.accept(ModItems.RAWMAGI.get());
                        output.accept(ModItems.MAGIC_WAND.get());


                        output.accept(ModBlocks.MAGI_BLOCK.get());
                        output.accept(ModBlocks.RAW_MAGI_BLOCK.get());
                        output.accept(ModBlocks.MAGI_ORE.get());
                        output.accept(ModBlocks.MAGI_DEEPSLATE_ORE.get());

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
