package net.example.magik.block;

import net.example.magik.Magik;
import net.example.magik.block.custom.ModFlammableRotatedPillarBlock;
import net.example.magik.datagen.tree.ModTreeGrowers;
import net.example.magik.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Magik.MOD_ID);

    public static final RegistryObject<Block> MAGI_BLOCK = registerBlock("magi_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_MAGI_BLOCK = registerBlock("raw_magi_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGI_ORE = registerBlock("magi_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGI_DEEPSLATE_ORE = registerBlock("magi_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<RotatedPillarBlock> MAGIC_WOOD = registerBlock("magic_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> MAGIC_WOOD_SAPLING = registerBlock("magic_wood_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MAGIC_WOOD,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
