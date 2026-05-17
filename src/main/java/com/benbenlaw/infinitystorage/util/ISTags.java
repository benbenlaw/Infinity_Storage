package com.benbenlaw.infinitystorage.util;

import com.benbenlaw.core.util.CoreTags;
import com.benbenlaw.infinitystorage.InfinityStorage;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ISTags {

    public static class Items extends CoreTags.Items {
        public static final TagKey<Item> DRIVES = tag(InfinityStorage.MOD_ID, "drives");
    }
}
