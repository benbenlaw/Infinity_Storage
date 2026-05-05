package com.benbenlaw.infinitystorage.block.entity;

import com.benbenlaw.core.block.entity.SyncableBlockEntity;
import com.benbenlaw.core.block.entity.handler.fluid.SyncableFluidHandler;
import com.benbenlaw.core.block.entity.handler.item.SyncableItemHandler;
import com.benbenlaw.infinitystorage.block.ISBlockEntities;
import com.benbenlaw.infinitystorage.item.InfinityContent;
import com.benbenlaw.infinitystorage.item.InfinityDrive;
import com.benbenlaw.infinitystorage.screen.InfinityStorageDriveMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.fluid.FluidUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfinityStorageDriveBlockEntity extends SyncableBlockEntity implements MenuProvider {

    private final SyncableItemHandler inventory = new SyncableItemHandler(this, 8,
            (i, stack) -> stack.getItem() instanceof InfinityDrive,
            i -> true
    );

    public InfinityStorageDriveBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ISBlockEntities.INFINITY_STORAGE_DRIVE_BLOCK_ENTITY.get(), blockPos, blockState);

    }

    public void tick() {

    }

    public ItemStacksResourceHandler getItemHandler() {
        SyncableItemHandler driveHandler = new SyncableItemHandler(this, 8,
                (i, stack) -> {
                    for (int j = 0; j < inventory.size(); j++) {
                        ItemStack driveStack = inventory.getResource(j).toStack();
                        if (driveStack.getItem() instanceof InfinityDrive drive && drive.getContent().isItem()) {
                            if (ItemStack.isSameItemSameComponents(stack, drive.getInfinityStack())) {
                                return true;
                            }
                        }
                    }
                    return false;
                },
                i -> true
        ) {
            @Override
            public int insert(int index, ItemResource resource, int amount, TransactionContext tx) {
                if (resource.isEmpty()) return 0;

                ItemStack incoming = resource.toStack(1);
                ItemStack stored = getResource(index).toStack();

                if (stored.isEmpty()) return 0;

                if (!ItemStack.isSameItemSameComponents(incoming, stored)) {
                    return 0;
                }

                return amount;
            }

            @Override
            public int extract(int index, ItemResource resource, int amount, TransactionContext tx) {
                if (resource.isEmpty()) return 0;

                ItemStack stored = getResource(index).toStack();

                if (stored.isEmpty()) return 0;

                if (!ItemStack.isSameItemSameComponents(stored, resource.toStack(1))) {
                    return 0;
                }

                return amount;
            }
        };

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getResource(i).toStack();
            if (stack.getItem() instanceof InfinityDrive drive && drive.getContent().isItem()) {
                driveHandler.set(i, ItemResource.of(drive.getInfinityStack()), Integer.MAX_VALUE);
            }
        }
        return driveHandler;
    }

    public FluidStacksResourceHandler getFluidHandler() {
        SyncableFluidHandler driveHandler = new SyncableFluidHandler(this, 8, Integer.MAX_VALUE,
                (i, fluidStack) -> {
                    for (int j = 0; j < inventory.size(); j++) {
                        ItemStack driveStack = inventory.getResource(j).toStack();

                        if (driveStack.getItem() instanceof InfinityDrive drive  && drive.getContent().isFluid()) {
                            if (FluidStack.isSameFluid(fluidStack, drive.getInfinityFluidStack())) {
                                return true;
                            }
                        }
                    }
                    return false;
                },
                i -> true
        ) {
            @Override

            public int insert(int index, FluidResource resource, int amount, TransactionContext tx) {
                if (resource.isEmpty()) return 0;

                FluidStack incoming = resource.toStack(1);
                FluidStack stored = FluidUtil.getStack(this, index);

                if (stored.isEmpty()) return 0;

                if (!FluidStack.isSameFluid(stored, incoming)) {
                    return 0;
                }

                return amount;
            }

            @Override
            public int extract(int index, FluidResource resource, int amount, TransactionContext tx) {
                if (resource.isEmpty()) return 0;

                FluidStack stored = FluidUtil.getStack(this, index);

                if (stored.isEmpty()) return 0;

                if (!FluidStack.isSameFluid(stored, resource.toStack(1))) {
                    return 0;
                }

                return amount;
            }
        };

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getResource(i).toStack();
            if (stack.getItem() instanceof InfinityDrive drive && drive.getContent().isFluid()) {
                driveHandler.set(i, FluidResource.of(drive.getInfinityFluidStack()), Integer.MAX_VALUE);
            }
        }
        return driveHandler;
    }

    public ItemStacksResourceHandler getDriveHandler() {
        return inventory;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int container, Inventory inventory, Player player) {
        return new InfinityStorageDriveMenu(container, inventory, this.worldPosition);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.infinitystorage.infinity_storage_drive");
    }

    @Override
    protected void saveAdditional(@NotNull ValueOutput output) {

        inventory.serialize(output.child("inventory"));

        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(@NotNull ValueInput input) {

        inventory.deserialize(input.childOrEmpty("inventory"));

        super.loadAdditional(input);
    }

    @Override
    public void preRemoveSideEffects(@NotNull BlockPos pos, @NotNull BlockState state) {
        dropInventoryContents(inventory);
    }

}
