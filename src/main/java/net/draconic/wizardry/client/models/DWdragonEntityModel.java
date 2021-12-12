package net.draconic.wizardry.client.models;

import net.draconic.wizardry.entities.DragonEntity;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static net.draconic.wizardry.DraconicWizardryMain.modID;

@Environment(EnvType.CLIENT)
public class DWdragonEntityModel extends AnimatedGeoModel<DragonEntity> {


    @Override
    public Identifier getModelLocation(DragonEntity entity) {
        return new Identifier(modID, "geo/dragon.geo.json");
    }

    @Override
    public Identifier getTextureLocation(DragonEntity entity) {
        return new Identifier(modID, "textures/entities/dragon.png");
    }

    @Override
    public Identifier getAnimationFileLocation(DragonEntity entity) {
        return new Identifier(modID, "animations/dragon.json");
    }

    /*@Override
    public void setLivingAnimations(DragonEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }*/
}