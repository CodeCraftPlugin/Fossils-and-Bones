package me.codecraft.fossilsandbones.entities.edmontosaurus;

import me.codecraft.fossilsandbones.entities.Enties;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

/**
 * The  Edmontosaurus Dino.
 */
public class EdmontosaurusEntity extends AnimalEntity implements IAnimatable {
    /**
     * Instantiates a new Edmontosaurus entity.
     *
     * @param entityType the entity type
     * @param world      the world
     */
    public EdmontosaurusEntity(EntityType<? extends AnimalEntity> entityType, World world) {

        super(entityType, world);
    }
    private AnimationFactory factory = new AnimationFactory(this);

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.1, Ingredient.ofItems(Items.WHEAT), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity passiveEntity) {
        EdmontosaurusEntity  idk = Enties.EDMONTOSAURUS.create(world);
        return idk;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this,"edmontosaurus",1,this::predicate));

    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("edmontosaurus.animation.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("edmontosaurus.animation.idle", true));

        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    /**
     * Set attributes default attribute container for the entity
     *
     * @return the default attribute container
     */
    public static DefaultAttributeContainer.Builder setAttributes(){
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE,25)
                .add(EntityAttributes.GENERIC_MAX_HEALTH,500d)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,0.75)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.35d);}
}
