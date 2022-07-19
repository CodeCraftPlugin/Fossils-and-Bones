package me.codecraft.fossilsandbones;

import me.codecraft.fossilsandbones.entities.FossilEntities;
import me.codecraft.fossilsandbones.entities.T_rex.T_rexRender;
import me.codecraft.fossilsandbones.entities.edmontosaurus.EdmontosaurusRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

/**
 * The type Fossil client.
 */
public class FossilClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(FossilEntities.T_REX,T_rexRender::new);
        EntityRendererRegistry.register(FossilEntities.EDMONTOSAURUS, EdmontosaurusRender::new);
        EntityRendererRegistry.register(FossilEntities.EDMONTOSAURUS, EdmontosaurusRender::new);
    }
}
