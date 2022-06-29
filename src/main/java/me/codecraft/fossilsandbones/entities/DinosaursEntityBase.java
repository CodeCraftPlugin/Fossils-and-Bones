package me.codecraft.fossilsandbones.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.GameEventListener;
import net.minecraft.world.event.listener.VibrationListener;
import org.jetbrains.annotations.Nullable;

public class DinosaursEntityBase extends HostileEntity implements VibrationListener.Callback {
    public DinosaursEntityBase(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }


    /**
     * Returns whether the callback wants to accept this event.
     *
     * @param world
     * @param listener
     * @param pos
     * @param event
     * @param emitter
     */
    @Override
    public boolean accepts(ServerWorld world, GameEventListener listener, BlockPos pos, GameEvent event, GameEvent.Emitter emitter) {
        return false;
    }

    /**
     * Accepts a game event after delay.
     *
     * @param world
     * @param listener
     * @param pos
     * @param event
     * @param entity
     * @param sourceEntity
     * @param distance
     */
    @Override
    public void accept(ServerWorld world, GameEventListener listener, BlockPos pos, GameEvent event, @Nullable Entity entity, @Nullable Entity sourceEntity, float distance) {

    }
}
