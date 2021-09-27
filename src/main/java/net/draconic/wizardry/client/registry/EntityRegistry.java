package net.draconic.wizardry.client.registry;

import net.draconic.wizardry.client.renderers.RedPandaRenderer;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


import static net.draconic.wizardry.DraconicWizardryMain.modID;


public class EntityRegistry
{
    public static final EntityType<RedPandaEntity> RED_PANDA = Registry.register(Registry.ENTITY_TYPE, new Identifier(modID,"red_panda"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedPandaEntity::new).dimensions(EntityDimensions.fixed(1F,0.75F)).build());

    public static void register()
    {
        //Red Panda Register Attributes and the model
        FabricDefaultAttributeRegistry.register(RED_PANDA, RedPandaEntity.generateRedPandaAttributes());
        EntityRendererRegistry.register(RED_PANDA, RedPandaRenderer::new);
    }

}

