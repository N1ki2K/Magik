package net.example.magik.datagen.tree;

import net.example.magik.Magik;
import net.example.magik.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower MAGIC_WOOD = new TreeGrower(Magik.MOD_ID + ":magic_wood",
    Optional.empty(), Optional.of(ModConfiguredFeatures.MAGIC_WOOD_KEY), Optional.empty());
}
