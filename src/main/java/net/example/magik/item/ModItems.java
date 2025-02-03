package net.example.magik.item;

import net.example.magik.Magik;
import net.minecraft.references.Items;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Magik.MOD_ID);

    public static final RegistryObject<Item> MAGICWAND = ITEMS.register("magicwand",
    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MIDMAGICWAND = ITEMS.register("midmagicwand.json",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HIGHMAGICWAND = ITEMS.register("highmagicwand",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
