package net.example.magik.datagen;

import net.example.magik.Magik;
import net.example.magik.worldgen.ModBiomeModifiers;
import net.example.magik.worldgen.ModConfiguredFeatures;
import net.example.magik.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
    .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
    .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
    .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);


    public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,BUILDER, Set.of(Magik.MOD_ID));
    }
}
