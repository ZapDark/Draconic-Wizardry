package net.draconic.wizardry.client.renderers;

import net.draconic.wizardry.client.models.RedPandaEntityModel;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RedPandaRenderer extends GeoEntityRenderer<RedPandaEntity>  {

    public RedPandaRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RedPandaEntityModel());
        this.shadowRadius = 0.5F;

    }
	
}
   


