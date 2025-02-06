package net.example.magik.datagen;

import net.example.magik.Magik;
import net.example.magik.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Magik.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//    blockWithItem(ModBlocks.MAGI_BLOCK);
//    blockWithItem(ModBlocks.RAW_MAGI_BLOCK);

    blockWithItem(ModBlocks.MAGI_ORE);
    blockWithItem(ModBlocks.MAGI_DEEPSLATE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
