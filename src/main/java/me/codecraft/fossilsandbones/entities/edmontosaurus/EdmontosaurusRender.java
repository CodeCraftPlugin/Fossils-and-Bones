package me.codecraft.fossilsandbones.entities.edmontosaurus;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/**
 * The type Edmontosaurus render.
 */
public class EdmontosaurusRender extends GeoEntityRenderer<EdmontosaurusEntity> {
    /**
     * Instantiates a new Edmontosaurus render.
     *
     * @param ctx the ctx
     */
    public EdmontosaurusRender(EntityRendererFactory.Context ctx) {
        super(ctx, new EdmontosaurusModel());
    }

    @Override
    public Identifier getTextureResource(EdmontosaurusEntity instance) {
        return new Identifier(Fossil.MOD_ID,"textures/entity/edmontosaurus/edmontosaurus_variant_1.png");
    }

    @Override
    public boolean shouldRender(EdmontosaurusEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}
