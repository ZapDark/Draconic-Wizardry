package net.draconic.wizardry.client.registry;

import net.draconic.wizardry.client.renderers.*;
import net.draconic.wizardry.entities.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


import static net.draconic.wizardry.DraconicWizardryMain.modID;


public class EntityRegistry
{
    public static final EntityType<DragonEntity> DRAGON = Registry.register(Registry.ENTITY_TYPE, new Identifier(modID,"dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DragonEntity::new).dimensions(EntityDimensions.fixed(6F,1F)).build());

    public static final EntityType<RedPandaEntity> RED_PANDA = Registry.register(Registry.ENTITY_TYPE, new Identifier(modID,"red_panda"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedPandaEntity::new).dimensions(EntityDimensions.fixed(1F,0.75F)).build());

    public static final EntityType<FireBallEntity> FIRE_BALL = register("fire_ball",SpawnGroup.MISC,EntityDimensions.changing(0.5f,0.5f),((type, world) -> new FireBallEntity(world)));

    public static void register()
    {
        //Register the Entities
        FabricDefaultAttributeRegistry.register(RED_PANDA, RedPandaEntity.generateRedPandaAttributes());
        EntityRendererRegistry.register(RED_PANDA, RedPandaRenderer::new);

        FabricDefaultAttributeRegistry.register(DRAGON, DragonEntity.dragonStats());
        EntityRendererRegistry.register(DRAGON, DragonRenderer::new);
    }

    public static <T extends Entity> EntityType<T> register(String name, SpawnGroup category, EntityDimensions size, EntityType.EntityFactory<T> factory) {
		return Registry.register(Registry.ENTITY_TYPE, new Identifier(modID, name), net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder.create(category, factory).size(size).build());
	}

}

