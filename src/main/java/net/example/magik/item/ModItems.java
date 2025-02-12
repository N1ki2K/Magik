package net.example.magik.item;

import net.example.magik.Magik;
import net.example.magik.item.Custom.BeginnerMagicWandItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Magik.MOD_ID);


    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("beginner_magic_wand",
            () -> new BeginnerMagicWandItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MID_MAGIC_WAND = ITEMS.register("advanced_magic_wand",
            () -> new BeginnerMagicWandItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> HIGH_MAGIC_WAND = ITEMS.register("expert_magic_wand",
            () -> new BeginnerMagicWandItem(new Item.Properties().stacksTo(1)));

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

    public static final RegistryObject<Item> RAWMAGI = ITEMS.register("raw_magi",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIC_HELMET = ITEMS.register("magic_helmet",
            () -> new Item(new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));

    public static final RegistryObject<Item> MAGIC_CHESTPLATE = ITEMS.register("magic_chestplate",
            () -> new Item(new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));

    public static final RegistryObject<Item> MAGIC_LEGGINGS = ITEMS.register("magic_leggings",
            () -> new Item(new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));

    public static final RegistryObject<Item> MAGIC_BOOTS = ITEMS.register("magic_boots",
            () -> new Item(new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
