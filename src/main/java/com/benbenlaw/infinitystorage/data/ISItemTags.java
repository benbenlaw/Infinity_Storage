package com.benbenlaw.infinitystorage.data;

import com.benbenlaw.infinitystorage.InfinityStorage;
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


    }

    @Override
    public @NotNull String getName() {
        return InfinityStorage.MOD_ID + " Item Tags";
    }
}
