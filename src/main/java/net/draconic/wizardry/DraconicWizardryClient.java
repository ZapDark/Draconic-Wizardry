package net.draconic.wizardry;

import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityRendererRegistryImpl;
import net.minecraft.entity.EntityType;
import software.bernie.example.registry.EntityRegistry;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class DraconicWizardryClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() 
    {
        EntityRendererRegistry.INSTANCE.register(DraconicWizardryMain.RED_PANDA, 
        (ctx, context) -> new RedPandaRenderer(ctx));
    }
    
}
