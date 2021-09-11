package net.draconic.wizardry.client.renderers;

import net.draconic.wizardry.DraconicWizardryMain;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RedPandaEntityRenderer extends MobEntityRenderer<RedPandaEntity, RedPandaEntityModel> {

    public RedPandaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RedPandaEntityModel(context.getPart(DraconicWizardryMainClient.MODEL_REDPANDA_LAYER)), 0.5f )
    }

    @Override
    public Identifier getTexture(RedPandaEntity entity) {
        // TODO Auto-generated method stub
        return new Identifier("draconicwizardrymain", );
    }
    
}
