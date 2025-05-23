package net.example.magik.worldgen;

import net.example.magik.Magik;
import net.example.magik.block.ModBlocks;
import net.example.magik.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_MAGI_ORE = registerKey("add_magi_ore");

    public static final ResourceKey<BiomeModifier> ADD_MAGIC_WOOD = registerKey("add_magic_tree");
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //All Biomes
        context.register(ADD_MAGI_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MAGI_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Individual Biomes
        // context.register(ADD_MAGI_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //         HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.BAMBOO_JUNGLE)),
        //         HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MAGI_ORE_PLACED_KEY)),
        //         GenerationStep.Decoration.UNDERGROUND_ORES));


         context.register(ADD_MAGIC_WOOD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                 HolderSet.direct(biomes.getOrThrow(ModBiomes.MAGIC_WOOD_SPAWN_BIOME_TEST)),
                 HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MAGIC_WOOD_PLACED_KEY)),
                 GenerationStep.Decoration.VEGETAL_DECORATION));


    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Magik.MOD_ID, name));
    }
}