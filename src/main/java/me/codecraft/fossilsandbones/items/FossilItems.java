package me.codecraft.fossilsandbones.items;

import me.codecraft.fossilsandbones.Fossil;
import me.codecraft.fossilsandbones.entities.Enties;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FossilItems {
    public static final Item T_REX_SPAWNEGG = registerItems("t_rex_spawnegg",new SpawnEggItem(Enties.T_REX,9177610,
            3015427,new FabricItemSettings().group(FossilItemGroups.FOSSIL_AND_BONES)));

    private static Item registerItems(String name,Item item){
        return Registry.register(Registry.ITEM,new Identifier(Fossil.MOD_ID,name),item);
    }

    public static void registeredFossilItems() {
        System.out.println("THE Items has been registered by the "+ Fossil.MOD_ID);
    }

}
