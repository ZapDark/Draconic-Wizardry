package net.draconic.wizardry.client.renderers;

import net.draconic.wizardry.client.models.DWdragonEntityModel;
import net.draconic.wizardry.entities.DragonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DragonRenderer extends GeoEntityRenderer<DragonEntity> {
    public DragonRenderer(EntityRendererFactory.Context context) {
        super(context, new DWdragonEntityModel());
        this.shadowRadius = 0.5f;

    }
}