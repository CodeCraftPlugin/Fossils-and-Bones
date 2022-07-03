package me.codecraft.fossilsandbones.entities.edmontosaurus;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EdmontosaurusRender extends GeoEntityRenderer<EdmontosaurusEntity> {
    public EdmontosaurusRender(EntityRendererFactory.Context ctx) {
        super(ctx, new EdmontosaurusModel());
    }

    @Override
    public Identifier getTextureResource(EdmontosaurusEntity instance) {
        return new Identifier(Fossil.MOD_ID,"texture/edmontosaurus_variant_1");
    }
}
