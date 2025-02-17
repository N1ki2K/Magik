package net.example.magik.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.DataGenerator;

import java.util.concurrent.CompletableFuture;

public class ModDataGenerator {
    public ModDataGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        DataGenerator generator = new DataGenerator(packOutput, lookupProvider);

        generator.addProvider(true, new ModItemModelProvider(packOutput));
        generator.addProvider(true, new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModLootTableProvider(packOutput));
    }
}
