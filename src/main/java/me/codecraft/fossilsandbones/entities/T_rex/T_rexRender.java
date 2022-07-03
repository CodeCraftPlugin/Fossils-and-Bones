package me.codecraft.fossilsandbones.entities.T_rex;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/**
 * The type T rex render.
 */
public class T_rexRender extends GeoEntityRenderer<T_rexEntity> {
    /**
     * Instantiates a new T rex render.
     *
     * @param ctx the ctx
     */
    public T_rexRender(EntityRendererFactory.Context ctx) {
        super(ctx, new T_rexModel());
    }

    @Override
    public Identifier getTextureResource(T_rexEntity instance) {
         return new Identifier(Fossil.MOD_ID,"textures/entity/tyrannosaurus_rex/tyrannosaurus_rex.png");
    }
}
