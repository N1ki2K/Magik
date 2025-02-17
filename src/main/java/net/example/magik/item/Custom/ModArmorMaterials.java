package net.example.magik.item.Custom;

import net.example.magik.Magik;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
public class ModArmorMaterials extends ArmorMaterial {
    public static final ModArmorMaterials INSTANCE = new ModArmorMaterials();
    private static final int[] BASE_DURABILITY = {13, 15, 16, 11}; // Boot, Leggings, Chestplate, Helmet
    private static final int[] PROTECTION_VALUES = {2, 5, 6, 2};  // Protection per armor piece

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getSlot().getIndex()] * 37; // Multiplier for durability
    }

    @Override
    public int getProtectionForType(ArmorItem.Type type) {
        return PROTECTION_VALUES[type.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC.get();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY; // Change if you have a custom repair item
    }

    @Override
    public String getName() {
        return Magik.MOD_ID + ":magik";
    }

    @Override
    public float getToughness() {
        return 2.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
}
