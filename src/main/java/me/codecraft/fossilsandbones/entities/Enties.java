package me.codecraft.fossilsandbones.entities;

import me.codecraft.fossilsandbones.Fossil;
import me.codecraft.fossilsandbones.entities.T_rex.T_rexEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Enties {

    public static final EntityType<T_rexEntity> T_REX = registery("t_rex", FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, T_rexEntity::new)
            .dimensions(EntityDimensions.fixed(5.0f, 3.0f))
            .build());

    private static EntityType registery(String name, EntityType entity){
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(Fossil.MOD_ID,name),entity);
    }
    public static void entiesregistered(){
        System.out.println("All entity registered by " + Fossil.MOD_ID);
    }
}
