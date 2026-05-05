package com.benbenlaw.infinitystorage.item;

import com.benbenlaw.infinitystorage.InfinityStorage;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidStackTemplate;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ISItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(InfinityStorage.MOD_ID);

    public static final DeferredItem<Item> EMPTY_INFINITY_DRIVE = ITEMS.registerSimpleItem("empty_infinity_drive");

    public static final DeferredItem<Item> INFINITY_COBBLESTONE_DRIVE = ITEMS.registerItem("infinity_cobblestone_drive",
            (properties -> new InfinityDrive(properties, InfinityContent.of(new ItemStackTemplate(Items.COBBLESTONE)))));

    public static final DeferredItem<Item> INFINITY_SAND_DRIVE = ITEMS.registerItem("infinity_sand_drive",
            (properties -> new InfinityDrive(properties, InfinityContent.of(new ItemStackTemplate(Items.SAND)))));

    public static final DeferredItem<Item> INFINITY_DIRT_DRIVE = ITEMS.registerItem("infinity_dirt_drive",
            (properties -> new InfinityDrive(properties, InfinityContent.of(new ItemStackTemplate(Items.DIRT)))));

    public static final DeferredItem<Item> INFINITY_GRAVEL_DRIVE = ITEMS.registerItem("infinity_gravel_drive",
            (properties -> new InfinityDrive(properties, InfinityContent.of(new ItemStackTemplate(Items.GRAVEL)))));

    public static final DeferredItem<Item> INFINITY_STONE_DRIVE = ITEMS.registerItem("infinity_stone_drive",
            (properties -> new InfinityDrive(properties, InfinityContent.of(new ItemStackTemplate(Items.STONE)))));

    public static final DeferredItem<Item> INFINITY_WATER_DRIVE = ITEMS.registerItem("infinity_water_drive",
            (properties -> new InfinityDrive(properties, InfinityContent.of(new FluidStackTemplate(Fluids.WATER, 1000)))));

    public static final DeferredItem<Item> INFINITY_LAVA_DRIVE = ITEMS.registerItem("infinity_lava_drive",
            (properties -> new InfinityDrive(properties, InfinityContent.of(new FluidStackTemplate(Fluids.LAVA, 1000)))));



}
