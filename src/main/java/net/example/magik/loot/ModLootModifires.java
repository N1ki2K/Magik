package net.example.magik.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.example.magik.Magik;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifires {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Magik.MOD_ID);

        public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
                LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);



    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
