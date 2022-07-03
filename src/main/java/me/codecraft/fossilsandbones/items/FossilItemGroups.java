package me.codecraft.fossilsandbones.items;

import me.codecraft.fossilsandbones.Fossil;
import me.codecraft.fossilsandbones.mixin.FossilMixin;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FossilItemGroups {
    public static final ItemGroup FOSSIL_AND_BONES = FabricItemGroupBuilder.build(new Identifier(Fossil.MOD_ID,"fossil_and_bones"),
            ()-> new ItemStack(FossilItems.T_REX_SPAWNEGG));
    public static void registered(){
        System.out.println("Itemgroup registed "+Fossil.MOD_ID);
    }
}
