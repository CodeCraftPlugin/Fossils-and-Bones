package me.codecraft.fossilsandbones.entities.T_rex;

import me.codecraft.fossilsandbones.entities.edmontosaurus.EdmontosaurusEntity;
import me.codecraft.fossilsandbones.sounds.FossilSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;

/**
 * The type T rex entity.
 */
public class T_rexEntity extends AnimalEntity implements IAnimatable , Angerable {
    private int ticksUntilNextGrowl = 100;
    private static final TrackedData<Integer> ANGER_TIME;
    private static final UniformIntProvider ANGER_TIME_RANGE;
    @Nullable
    private UUID angryAt;
    private AnimationFactory factory = new AnimationFactory(this);

    /**
     * Instantiates a new T rex entity.
     *
     * @param entityType the entity type
     * @param world      the world
     */
    public T_rexEntity(EntityType<? extends T_rexEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum= true;
    }
    static {
        ANGER_TIME = DataTracker.registerData(T_rexEntity.class, TrackedDataHandlerRegistry.INTEGER);
        ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    }

    /**
     * Set attributes default attribute container . builder.
     *
     * @return the default attribute container . builder
     */
    public static DefaultAttributeContainer.Builder setAttributes(){
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE,50d)
                .add(EntityAttributes.GENERIC_MAX_HEALTH,1000.0d)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,2.0d)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.35d);}

    protected void initGoals(){
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class,1.0f));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(0,new SwimGoal(this));
        this.initCustomGoals();



    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ANGER_TIME, 0);
    }

    /**
     * Init custom goals.
     */
    protected void initCustomGoals(){
        this.goalSelector.add(3, new AttackGoal(this));
        this.goalSelector.add(0, new WanderAroundFarGoal(this, 1.0,0.5f));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal(this, EdmontosaurusEntity.class, true));


    }
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.t_rex.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.t_rex.idle", true));

        return PlayState.CONTINUE;
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if (this.hasAngerTime()) {
            return FossilSounds.TREX_ANGER;
        } else {
            return FossilSounds.TREX_IDEL;
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FossilSounds.TREX_DEATH;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public int getAngerTime() {
        return (Integer)this.dataTracker.get(ANGER_TIME);
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.dataTracker.set(ANGER_TIME, angerTime);
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

}
