package me.codecraft.fossilsandbones.utils;

import me.codecraft.fossilsandbones.entities.Enties;
import me.codecraft.fossilsandbones.entities.T_rex.T_rexEntity;
import me.codecraft.fossilsandbones.entities.edmontosaurus.EdmontosaurusEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class Registeries {
    public static void init(){
        registerAttributes();
    }
    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(Enties.T_REX, T_rexEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(Enties.EDMONTOSAURUS, EdmontosaurusEntity.setAttributes());
    }
}
