package me.codecraft.fossilsandbones.entities.pterosaur;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class QuetzalcoatlusEntityModel extends AnimatedGeoModel<PterosaurEntity> {
    @Override
    public Identifier getModelResource(PterosaurEntity object) {
        return new Identifier(Fossil.MOD_ID,"geo/quetzalcoatlus.geo.json");
    }

    @Override
    public Identifier getTextureResource(PterosaurEntity object) {
        return new Identifier(Fossil.MOD_ID,"textures/entity/quetzalcoatlus/quetzalcoatlus_lawsoni.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(PterosaurEntity animatable) {
        return new Identifier(Fossil.MOD_ID,"animations/quetzalcoatlus.animation.json");
    }
}
