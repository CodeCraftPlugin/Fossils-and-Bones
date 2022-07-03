package me.codecraft.fossilsandbones.entities.T_rex;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class T_rexModel extends AnimatedGeoModel<T_rexEntity> {


    @Override
    public Identifier getModelResource(T_rexEntity object) {
        return new Identifier(Fossil.MOD_ID,"geo/tyrannosaurus_rex.geo.json");
    }

    @Override
    public Identifier getTextureResource(T_rexEntity object) {
        return new Identifier(Fossil.MOD_ID,"textures/entity/tyrannosaurus_rex/tyrannosaurus_rex.png");
    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public Identifier getAnimationResource(T_rexEntity animatable) {
        return new Identifier(Fossil.MOD_ID,"animations/tyrannosaurus.animation.json");
    }


}
