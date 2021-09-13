package net.draconic.wizardry;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;

public class DefEntityAttributes {

    public static DefaultAttributeContainer.Builder generateDefaultAttributes() {
        return PathAwareEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1)
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 10);

    }
    
}
