package me.codecraft.fossilsandbones.entities.T_rex;

import me.codecraft.fossilsandbones.FossilSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class T_rexEntity extends HostileEntity implements IAnimatable {
    private int ticksUntilNextGrowl = 100;
    private AnimationFactory factory = new AnimationFactory(this);
    public T_rexEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum= true;
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE,50d)
                .add(EntityAttributes.GENERIC_MAX_HEALTH,200f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,1.0d)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,.25d);}

    protected void initGoals(){
        this.goalSelector.add(0, new LookAtEntityGoal(this, LivingEntity.class,9.0f));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(3,new SwimGoal(this));
        this.initCustomGoals();



    }
    protected void initCustomGoals(){
        this.goalSelector.add(3, new AttackGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, .25d,1.0f));
        this.targetSelector.add(0, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal(this, T_rexEntity.class, true));

    }
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<T_rexEntity> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.t_rex.moving",true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.t_rex.idle", true));
        return PlayState.CONTINUE;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return FossilSounds.TREX_ROAR;
    }
}
