package com.benbenlaw.infinitystorage.data;

import com.benbenlaw.infinitystorage.InfinityStorage;
import com.benbenlaw.infinitystorage.block.ISBlocks;
import com.benbenlaw.infinitystorage.item.ISItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ISRecipeProvider extends RecipeProvider {


    public ISRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
            return new ISRecipeProvider(provider, recipeOutput);
        }

        @Override
        public @NotNull String getName() {
            return InfinityStorage.MOD_ID + " Recipes";
        }
    }

    @Override
    protected void buildRecipes() {

        //Drying Table
        shaped(RecipeCategory.MISC, ISBlocks.INFINITY_STORAGE_DRIVE.get())
                .pattern("AAA")
                .pattern("BCB")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_NETHERITE)
                .define('B', Tags.Items.STORAGE_BLOCKS_IRON)
                .define('C', Tags.Items.STORAGE_BLOCKS_DIAMOND)
                .group("infinity_storage")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_NETHERITE))
                .save(output);

        //Empty Infinity Drive
        shaped(RecipeCategory.MISC, ISItems.EMPTY_INFINITY_DRIVE.get())
                .pattern("AAA")
                .pattern("B B")
                .pattern("AAA")
                .define('A', Tags.Items.INGOTS_NETHERITE)
                .define('B', Items.NETHER_STAR)
                .group("infinity_storage")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_NETHERITE))
                .save(output);

        //Lava Drive
        shaped(RecipeCategory.MISC, ISItems.INFINITY_LAVA_DRIVE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.LAVA_BUCKET)
                .define('B', ISItems.EMPTY_INFINITY_DRIVE.get())
                .group("infinity_storage")
                .unlockedBy("has_item", has(ISItems.EMPTY_INFINITY_DRIVE.get()))
                .save(output);

        //Water Drive
        shaped(RecipeCategory.MISC, ISItems.INFINITY_WATER_DRIVE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.WATER_BUCKET)
                .define('B', ISItems.EMPTY_INFINITY_DRIVE.get())
                .group("infinity_storage")
                .unlockedBy("has_item", has(ISItems.EMPTY_INFINITY_DRIVE.get()))
                .save(output);

        //Cobblestone Drive
        shaped(RecipeCategory.MISC, ISItems.INFINITY_COBBLESTONE_DRIVE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.COBBLESTONE)
                .define('B', ISItems.EMPTY_INFINITY_DRIVE.get())
                .group("infinity_storage")
                .unlockedBy("has_item", has(ISItems.EMPTY_INFINITY_DRIVE.get()))
                .save(output);

        //Sand Drive
        shaped(RecipeCategory.MISC, ISItems.INFINITY_SAND_DRIVE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.SAND)
                .define('B', ISItems.EMPTY_INFINITY_DRIVE.get())
                .group("infinity_storage")
                .unlockedBy("has_item", has(ISItems.EMPTY_INFINITY_DRIVE.get()))
                .save(output);

        //Gravel Drive
        shaped(RecipeCategory.MISC, ISItems.INFINITY_GRAVEL_DRIVE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.GRAVEL)
                .define('B', ISItems.EMPTY_INFINITY_DRIVE.get())
                .group("infinity_storage")
                .unlockedBy("has_item", has(ISItems.EMPTY_INFINITY_DRIVE.get()))
                .save(output);

        //Dirt Drive
        shaped(RecipeCategory.MISC, ISItems.INFINITY_DIRT_DRIVE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.DIRT)
                .define('B', ISItems.EMPTY_INFINITY_DRIVE.get())
                .group("infinity_storage")
                .unlockedBy("has_item", has(ISItems.EMPTY_INFINITY_DRIVE.get()))
                .save(output);

        //Stone Drive
        shaped(RecipeCategory.MISC, ISItems.INFINITY_STONE_DRIVE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.STONE)
                .define('B', ISItems.EMPTY_INFINITY_DRIVE.get())
                .group("infinity_storage")
                .unlockedBy("has_item", has(ISItems.EMPTY_INFINITY_DRIVE.get()))
                .save(output);




    }
}
