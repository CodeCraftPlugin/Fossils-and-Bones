package me.codecraft.fossilsandbones;

import me.codecraft.fossilsandbones.entities.Enties;
import me.codecraft.fossilsandbones.entities.T_rex.T_rexEntity;
import me.codecraft.fossilsandbones.entities.T_rex.T_rexRender;
import me.codecraft.fossilsandbones.entities.edmontosaurus.EdmontosaurusEntity;
import me.codecraft.fossilsandbones.entities.edmontosaurus.EdmontosaurusRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;

/**
 * The type Fossil client.
 */
public class FossilClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Enties.T_REX,T_rexRender::new);
        EntityRendererRegistry.register(Enties.EDMONTOSAURUS, EdmontosaurusRender::new);
    }
}
