package net.draconic.wizardry;

import net.draconic.wizardry.entities.RedPandaEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import software.bernie.example.registry.EntityRegistry;

public class EntityReg {
    public static final String MOD_ID = "dw";
        
    public static final EntityType<RedPandaEntity> RED_PANDA = EntityRegistry.buildEntity(RedPandaEntity::new, RedPandaEntity.class, 0.5F, 0.6F, SpawnGroup.CREATURE);
}
