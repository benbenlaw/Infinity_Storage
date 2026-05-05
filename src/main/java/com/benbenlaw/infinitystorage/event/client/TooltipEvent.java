package com.benbenlaw.infinitystorage.event.client;

import com.benbenlaw.core.util.TooltipUtil;
import com.benbenlaw.infinitystorage.InfinityStorage;
import com.benbenlaw.infinitystorage.block.ISBlocks;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = InfinityStorage.MOD_ID)
public class TooltipEvent {

    @SubscribeEvent
    public static void onTooltipEvent(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        TooltipUtil.addShiftTooltip(stack, event, ISBlocks.INFINITY_STORAGE_DRIVE.get().asItem(), "tooltip.infinitystorage.infinity_storage_drive");

    }
}
