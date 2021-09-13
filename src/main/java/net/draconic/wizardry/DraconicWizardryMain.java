package net.draconic.wizardry;

import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.GeckoLib;

public class DraconicWizardryMain implements ModInitializer {

    public static final EntityType<RedPandaEntity> RED_PANDA = EntityRegistry.buildEntity(RedPandaEntity::new, RedPandaEntity.class, 0.5F, 0.6F, SpawnGroup.CREATURE);

    @Override
    public void onInitialize() {

        GeckoLib.initialize();
    
    }
}
