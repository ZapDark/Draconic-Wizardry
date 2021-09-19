package net.draconic.wizardry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.mob.MobEntity;

public class RedPandaEntity extends AnimalEntity
{
    public RedPandaEntity(EntityType<? extends AnimalEntity> entityType, World world)
    {
        super(entityType, world);

    }


    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) 
    {
        return null;
    }

    public static DefaultAttributeContainer.Builder generateRedPandaAttributes() 
    {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0D)
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D);
    }
}
