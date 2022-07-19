package me.codecraft.fossilsandbones.entities.pterosaur;

import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class QuetzalcoatlusEntityRender extends GeoEntityRenderer<QuetzalcoatlusEntity> {
    public QuetzalcoatlusEntityRender(EntityRendererFactory.Context ctx) {
        super(ctx, new QuetzalcoatlusEntityModel());
    }
}
