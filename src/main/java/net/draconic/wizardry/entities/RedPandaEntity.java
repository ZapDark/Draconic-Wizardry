package net.draconic.wizardry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class RedPandaEntity extends AnimalEntity {

    public RedPandaEntity(EntityType<? extends RedPandaEntity> entityType, World world) {
        super(entityType, world);
        //TODO Auto-generated constructor stub
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
