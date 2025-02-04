package net.example.magik.item;

import net.example.magik.Magik;
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

    public static final RegistryObject<Item> MIDMAGICWAND = ITEMS.register("midmagicwand",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HIGHMAGICWAND = ITEMS.register("highmagicwand",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGICORE = ITEMS.register("magicore",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENCHANTEDWOOL = ITEMS.register("enchantedwool",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIBOOK = ITEMS.register("magibook",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIORE = ITEMS.register("magiore",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIWOOD = ITEMS.register("magiwood",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGICESSENCE = ITEMS.register("magicessence",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGICINGOT = ITEMS.register("magicingot",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
