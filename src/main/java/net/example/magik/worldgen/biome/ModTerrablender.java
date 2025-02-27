package net.example.magik.worldgen.biome;

import net.example.magik.Magik;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes(){
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(Magik.MOD_ID, "overworld"),5));
    }
}
