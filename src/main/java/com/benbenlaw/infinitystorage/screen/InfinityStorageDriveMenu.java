package com.benbenlaw.infinitystorage.screen;

import com.benbenlaw.core.screen.SimpleAbstractContainerMenu;
import com.benbenlaw.core.screen.util.slot.InputSlot;
import com.benbenlaw.infinitystorage.block.ISBlocks;
import com.benbenlaw.infinitystorage.block.entity.InfinityStorageDriveBlockEntity;
import com.benbenlaw.infinitystorage.item.InfinityDrive;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class InfinityStorageDriveMenu extends SimpleAbstractContainerMenu {

    protected InfinityStorageDriveBlockEntity blockEntity;
    protected Level level;
    protected ContainerData data;
    protected Player player;
    protected BlockPos blockPos;

    public InfinityStorageDriveMenu(int containerID, Inventory inventory, FriendlyByteBuf extraData) {
        this(containerID, inventory, extraData.readBlockPos());
    }

    public InfinityStorageDriveMenu(int containerID, Inventory inventory, BlockPos blockPos) {
        super(ISMenuTypes.INFINITY_STORAGE_DRIVE_MENU.get(), containerID, inventory, blockPos, 8);
        this.player = inventory.player;
        this.blockPos = blockPos;
        this.level = inventory.player.level();
        this.blockEntity = (InfinityStorageDriveBlockEntity) this.level.getBlockEntity(blockPos);


        int xStart = 17;
        int yStart = 37;

        for (int i = 0; i < 8; i++) {
            this.addSlot(new InputSlot(blockEntity.getDriveHandler(), blockEntity.getDriveHandler()::set, i, xStart + i * 18, yStart) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return stack.getItem() instanceof InfinityDrive;
                }
            });
        }

    }
}