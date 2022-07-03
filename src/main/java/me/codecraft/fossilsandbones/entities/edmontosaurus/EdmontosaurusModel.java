package me.codecraft.fossilsandbones.entities.edmontosaurus;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * The type Edmontosaurus model.
 */
public class EdmontosaurusModel extends AnimatedGeoModel<EdmontosaurusEntity> {
    @Override
    public Identifier getModelResource(EdmontosaurusEntity object) {
        return new Identifier(Fossil.MOD_ID,"geo/edmontosaurus_annectens.geo.json");
    }

    @Override
    public Identifier getTextureResource(EdmontosaurusEntity object) {
        return new Identifier(Fossil.MOD_ID,"texture/entity/edmontosaurus/edmontosaurus_variant_1.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(EdmontosaurusEntity animatable) {
        return new Identifier(Fossil.MOD_ID,"animations/edmontosaurus.animation.json");
    }
}
