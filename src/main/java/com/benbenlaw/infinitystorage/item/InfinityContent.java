package com.benbenlaw.infinitystorage.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidStackTemplate;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.item.ItemResource;

public class InfinityContent {

    private final ItemStackTemplate infinityStack;
    private final FluidStackTemplate fluidStack;

    public InfinityContent(ItemStackTemplate infinityStack, FluidStackTemplate fluidStack) {
        this.infinityStack = infinityStack;
        this.fluidStack = fluidStack;
    }

    public static InfinityContent of (ItemStackTemplate stack) {
        return new InfinityContent(stack, null);
    }

    public static InfinityContent of (FluidStackTemplate stack) {
        return new InfinityContent(null, stack);
    }

    public boolean isItem() {
        return infinityStack != null && fluidStack == null;
    }

    public boolean isFluid() {
        return fluidStack != null && infinityStack == null;
    }


    public ItemStack getInfinityStack() {
        return infinityStack.create();
    }

    public FluidStack getInfinityFluidStack() {
        return fluidStack.create();
    }
}
