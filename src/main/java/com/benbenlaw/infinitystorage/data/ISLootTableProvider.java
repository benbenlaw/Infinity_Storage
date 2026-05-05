package com.benbenlaw.infinitystorage.data;

import com.benbenlaw.infinitystorage.block.ISBlocks;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ISLootTableProvider extends VanillaBlockLoot {

    private final Set<Block> knownBlocks = new ReferenceOpenHashSet<>();

    public ISLootTableProvider(HolderLookup.Provider provider) {
        super(provider);
    }

    @Override
    protected void generate() {

        this.dropSelf(ISBlocks.INFINITY_STORAGE_DRIVE.get());

    }

    @Override
    protected void add(@NotNull Block block, @NotNull LootTable.Builder table) {
        super.add(block, table);
        knownBlocks.add(block);
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
