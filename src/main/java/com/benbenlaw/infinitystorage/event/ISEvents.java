package com.benbenlaw.infinitystorage.event;

import com.benbenlaw.infinitystorage.InfinityStorage;
import com.benbenlaw.infinitystorage.block.ISBlockEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = InfinityStorage.MOD_ID)
public class ISEvents {

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {

        event.registerBlockEntity(Capabilities.Item.BLOCK, ISBlockEntities.INFINITY_STORAGE_DRIVE_BLOCK_ENTITY.get(),
                (blockEntity, side) -> blockEntity.getItemHandler());

        event.registerBlockEntity(Capabilities.Fluid.BLOCK, ISBlockEntities.INFINITY_STORAGE_DRIVE_BLOCK_ENTITY.get(),
                (blockEntity, side) -> blockEntity.getFluidHandler());
    }
}
