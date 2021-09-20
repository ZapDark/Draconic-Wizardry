package net.draconic.wizardry.client.renderers;

import net.draconic.wizardry.DraconicWizardryClient;
import net.draconic.wizardry.client.models.RedPandaEntityModel;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RedPandaRenderer extends MobEntityRenderer<RedPandaEntity, RedPandaEntityModel<RedPandaEntity>>
{
    private static final Identifier TEXTURE = new Identifier("dw", "textures/entities/red_panda.png");

    public RedPandaRenderer(EntityRendererFactory.Context context)
    {
        super(context, new RedPandaEntityModel<>(context.getPart(DraconicWizardryClient.MODEL_RED_PANDA_LAYER)),0.5F);

    }
    @Override
    public Identifier getTexture(RedPandaEntity redPanda)
    {
        return TEXTURE;
    }
}
   


