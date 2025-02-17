package net.example.magik.item;

import net.minecraft.world.item.*;
import net.minecraft.sounds.SoundEvent;

import net.minecraft.world.item.crafting.Ingredient;

public class ModArmorMaterials implements ArmorMaterial{

    private static final int[] BASE_DURABILITY = {13, 15, 16, 11}; // Ботуши, клин, нагръдник, шлем
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
                      SoundEvent equipSound, float toughness, float knockbackResistance, Ingredient repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

@Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }
@Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }
@Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }
@Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
@Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
@Override
    public String getName() {
        return this.name;
    }
@Override
    public float getToughness() {
        return this.toughness;
    }
@Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

