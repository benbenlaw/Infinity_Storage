package com.benbenlaw.infinitystorage.data;

import com.benbenlaw.infinitystorage.InfinityStorage;
import com.benbenlaw.infinitystorage.block.ISBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ISBlockTags extends BlockTagsProvider {

    ISBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, InfinityStorage.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //Pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ISBlocks.INFINITY_STORAGE_DRIVE.get())
        ;
    }

    @Override
    public String getName() {
        return InfinityStorage.MOD_ID + " Block Tags";
    }
}
