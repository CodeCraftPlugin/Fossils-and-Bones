package me.codecraft.fossilsandbones.entities.pterosaur;

import me.codecraft.fossilsandbones.entities.DinosaursBaseEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class PterosaurEntity extends DinosaursBaseEntity implements IAnimatable{

    public PterosaurEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    private AnimationFactory factory = new AnimationFactory(this);

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this,"main",1,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return item.isFood() && item.getFoodComponent().isMeat();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (this.isAlive()){
            if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("quetzalcoatlus.animation.walk", true));
                return PlayState.CONTINUE;
            }
            if (!this.isOnGround() && (fallDistance > 2.0f)) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("quetzalcoatlus.animation.fly", true));
                return PlayState.CONTINUE;
            }
            if(this.hasAngerTime()){
                event.getController().setAnimation(new AnimationBuilder().addAnimation("quetzalcoatlus.animation.run", true));
                return PlayState.CONTINUE;
            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("quetzalcoatlus.animation.idle", true));
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2,new AttackGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(1,new FlyGoal(this,0.5d));
    }
    public static DefaultAttributeContainer.Builder setAttributes(){
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE,30f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH,500d)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,2.0d)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.5d);
    }
}
