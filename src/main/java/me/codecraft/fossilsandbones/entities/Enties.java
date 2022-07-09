package me.codecraft.fossilsandbones.entities;

import me.codecraft.fossilsandbones.Fossil;
import me.codecraft.fossilsandbones.entities.T_rex.T_rexEntity;
import me.codecraft.fossilsandbones.entities.edmontosaurus.EdmontosaurusEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * The type Enties.
 */
public class Enties {

    /**
     * The constant T_REX.
     */
    public static final EntityType<T_rexEntity> T_REX = registery("t_rex", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, T_rexEntity::new)
            .dimensions(new EntityDimensions(3.0f,3.0f,false)).trackRangeBlocks(10)
            .build());
    public static final EntityType<EdmontosaurusEntity> EDMONTOSAURUS = registery("edmontosaurus", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EdmontosaurusEntity::new)
            .dimensions(EntityDimensions.fixed(5.0f, 3.0f)).trackRangeBlocks(10)
            .build());

    private static EntityType registery(String name, EntityType entity){
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(Fossil.MOD_ID,name),entity);
    }

    /**
     * Entiesregistered.
     */
    public static void entiesregistered(){
        System.out.println("All entity registered by " + Fossil.MOD_ID);
    }
}
