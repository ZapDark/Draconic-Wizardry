package net.draconic.wizardry;

import net.fabricmc.api.Environment;
import net.draconic.wizardry.client.models.RedPandaEntityModel;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class EntityRenderer extends GeoEntityRenderer<RedPandaEntity>  {

    public EntityRenderer(Context entityRenderDispatcher) {
        super(entityRenderDispatcher, new RedPandaEntityModel());
        this.shadowRadius = 0.5F;
    }
}
   
