package me.codecraft.fossilsandbones.utils;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FossilTag {
    public class Items{

        public static final TagKey<Item> EDMON_BREAD = createTag("edmon_bread");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(Fossil.MOD_ID,name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY,new Identifier("c", name));
        }
    }
}

