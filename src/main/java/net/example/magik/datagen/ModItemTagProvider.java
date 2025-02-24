package net.example.magik.datagen;

import net.example.magik.Magik;
import net.example.magik.block.ModBlocks;
import net.example.magik.item.ModItems;
//import net.example.magik.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, Magik.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(ModItem.)
//    }

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAGIC_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.MAGIC_WOOD.get().asItem());
    }
}
