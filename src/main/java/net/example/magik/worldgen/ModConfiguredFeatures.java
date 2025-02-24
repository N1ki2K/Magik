package net.example.magik.worldgen;

import com.jcraft.jorbis.Block;
import io.netty.util.Constant;
import net.example.magik.Magik;
import net.example.magik.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class ModConfiguredFeatures {
//    Custom Ore (Configured Feature) -> How many vains in a chunk + ecs... (Placed Feature) -> Where is going to be placed (Biome Modifires)
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MAGI_ORE_KEY = registerKey("magi_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGIC_WOOD_KEY = registerKey("magic_wood");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacebles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacebles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
//        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
//        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldMagiOres = List.of(
                OreConfiguration.target(stoneReplacebles, ModBlocks.MAGI_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacebles, ModBlocks.MAGI_DEEPSLATE_ORE.get().defaultBlockState()));

            register(context, OVERWORLD_MAGI_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMagiOres, 3));

            register(context, MAGIC_WOOD_KEY,Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.MAGIC_WOOD.get()),
                    new ForkingTrunkPlacer(4, 4,3),

                    BlockStateProvider.simple(Blocks.WARPED_WART_BLOCK),
                    new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3),3),

                    new TwoLayersFeatureSize(1,0,2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Magik.MOD_ID, name));

}
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    }