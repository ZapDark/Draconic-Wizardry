package net.draconic.wizardry;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DraconicWizardryClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_REDPANDA_LAYER = new EntityModelLayer(new Identifier("draconicwizardrymain", "redpanda"), "main");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(DraconicWizardryMain.REDPANDA, (context) -> {
            return new RedPandaEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_REDPANDA_LAYER, RedPandaEntityModel::getTextureModelData);
    }
    
}
