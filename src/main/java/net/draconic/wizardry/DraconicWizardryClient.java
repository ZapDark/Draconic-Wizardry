package net.draconic.wizardry;

import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.draconic.wizardry.client.renderers.RedPandaRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;


@Environment(EnvType.CLIENT)
public class DraconicWizardryClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() 
    {
        EntityRendererRegistry.register(EntityReg.RED_PANDA, 
        (ctx) -> new RedPandaRenderer(ctx));
    }
    
}
