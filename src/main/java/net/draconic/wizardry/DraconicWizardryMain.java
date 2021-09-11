package net.draconic.wizardry;

import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLib;

public class DraconicWizardryMain implements ModInitializer {

    public static final EntityType<RedPandaEntity> REDPANDA = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("draconicwizardrymain", "redpanda") , 
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedPandaEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
        );

    @Override
    public void onInitialize() {

        GeckoLib.initialize();
    }
    
}
