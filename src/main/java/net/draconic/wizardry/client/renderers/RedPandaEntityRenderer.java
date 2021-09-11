package net.draconic.wizardry.client.renderers;

import net.draconic.wizardry.DraconicWizardryMain;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.draconic.wizardry.client.models.RedPandaEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RedPandaEntityRenderer extends MobEntityRenderer<RedPandaEntity, RedPandaEntityModel> {
    private static final Identifier TEXTURE = new Identifier("dw", "textures/entities/red_panda.png")

    public RedPandaEntityRenderer(Context context) {
        super(context, new RedPandaEntityModel(context.getPart(DraconicWizardryMainClient.MODEL_RED_PANDA)), 0.5f )
    }

    @Override
    public Identifier getTexture(RedPandaEntity entity) {
        return TEXTURE;
    }
    
}
