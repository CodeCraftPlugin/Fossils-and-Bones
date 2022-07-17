package me.codecraft.fossilsandbones.utils;

import me.codecraft.fossilsandbones.entities.FossilEntities;
import me.codecraft.fossilsandbones.entities.T_rex.T_rexEntity;
import me.codecraft.fossilsandbones.entities.edmontosaurus.EdmontosaurusEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

/**
 * The type Registeries.
 */
public class Registeries {
    /**
     * Init.
     */
    public static void init(){
        registerAttributes();
    }
    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(FossilEntities.T_REX, T_rexEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(FossilEntities.EDMONTOSAURUS, EdmontosaurusEntity.setAttributes());
    }
}
