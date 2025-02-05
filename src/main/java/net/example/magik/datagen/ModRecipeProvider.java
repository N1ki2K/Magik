package net.example.magik.datagen;

import net.example.magik.Magik;
import net.example.magik.block.ModBlocks;
import net.example.magik.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> MAGICINGOT_SMELTABLES = List.of(ModItems.RAWMAGI.get(),ModBlocks.MAGI_ORE.get(),ModBlocks.MAGI_DEEPSLATE_ORE.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGI_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGICINGOT.get())
                .unlockedBy(getHasName(ModItems.MAGICINGOT.get()), has(ModItems.MAGICINGOT.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGICINGOT.get(),9)
                .requires(ModBlocks.MAGI_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MAGI_BLOCK.get()), has(ModBlocks.MAGI_BLOCK.get())).save(pRecipeOutput);

//        Gives an error when you try to create a output on 1 item from a couple of sorces

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGICINGOT.get(),9)
//                .requires(ModBlocks.MAGI_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.MAGI_BLOCK.get()), has(ModBlocks.MAGI_BLOCK.get())).
//                save(pRecipeOutput, Magik.MOD_ID + ":magicingot_from_example");


        oreSmelting(pRecipeOutput, MAGICINGOT_SMELTABLES, RecipeCategory.MISC, ModItems.MAGICINGOT.get(), 0.25f,200, "magicingot");
        oreBlasting(pRecipeOutput, MAGICINGOT_SMELTABLES, RecipeCategory.MISC, ModItems.MAGICINGOT.get(), 0.25f,100, "magicingot");
    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Magik.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
