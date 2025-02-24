package net.example.magik.datagen;

import net.example.magik.Magik;
import net.example.magik.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Magik.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MAGI_BLOCK.get())
                .add(ModBlocks.RAW_MAGI_BLOCK.get())
                .add(ModBlocks.MAGI_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGI_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAGI_BLOCK.get())
                .add(ModBlocks.RAW_MAGI_BLOCK.get())
                .add(ModBlocks.MAGI_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGI_ORE.get());

//        tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add(ModBlocks.example.get())

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAGIC_WOOD.get());
    }
}
