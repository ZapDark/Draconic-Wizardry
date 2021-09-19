package net.draconic.wizardry;

import net.draconic.wizardry.client.models.RedPandaEntityModel;
import net.draconic.wizardry.client.renderers.RedPandaRenderer;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


@Environment(EnvType.CLIENT)
public class DraconicWizardryClient implements ClientModInitializer {

    public static final EntityType<RedPandaEntity> RED_PANDA = Registry.register(Registry.ENTITY_TYPE, new Identifier("draconic_wizardry","red_panda"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedPandaEntity::new).dimensions(EntityDimensions.fixed(0.75F,0.75F)).build());
    public static final EntityModelLayer MODEL_RED_PANDA_LAYER = new EntityModelLayer(new Identifier("dw", "red_panda"), "main");
        
    @Override
    public void onInitializeClient() 
    {
        EntityRendererRegistry.register(RED_PANDA, RedPandaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_RED_PANDA_LAYER, RedPandaEntityModel::getTexturedModelData);
        FabricDefaultAttributeRegistry.register(RED_PANDA, RedPandaEntity.generateRedPandaAttributes());
    }
}
