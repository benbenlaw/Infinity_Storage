package com.benbenlaw.infinitystorage.data;

import com.benbenlaw.infinitystorage.InfinityStorage;
import com.benbenlaw.infinitystorage.item.ISItems;
import com.benbenlaw.infinitystorage.util.ISTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ISItemTags extends ItemTagsProvider {

    public ISItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, InfinityStorage.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(ISTags.Items.DRIVES).add(
                ISItems.INFINITY_COBBLESTONE_DRIVE.get(),
                ISItems.INFINITY_SAND_DRIVE.get(),
                ISItems.INFINITY_LAVA_DRIVE.get(),
                ISItems.INFINITY_WATER_DRIVE.get(),
                ISItems.INFINITY_STONE_DRIVE.get(),
                ISItems.INFINITY_GRAVEL_DRIVE.get(),
                ISItems.INFINITY_DIRT_DRIVE.get()
        );

    }

    @Override
    public @NotNull String getName() {
        return InfinityStorage.MOD_ID + " Item Tags";
    }
}
