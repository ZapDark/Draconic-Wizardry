package net.draconic.wizardry.client.renderers;

import net.draconic.wizardry.entities.FireBallEntity;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.util.Identifier;
import static net.draconic.wizardry.DraconicWizardryMain.modID;

public class FireBallRenderer extends ProjectileEntityRenderer<FireBallEntity> {

    public FireBallRenderer(Context context) {
        super(context);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Identifier getTexture(FireBallEntity entity) {
        return new Identifier(modID, "textures/entity/projectiles/fire_ball.png");
    }
    
}
