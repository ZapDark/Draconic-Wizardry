package net.draconic.wizardry.client.models;

import net.draconic.wizardry.entities..passive.RedPandaEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static net.draconic.wizardry.DraconicWizardryMain.modID;

@Environment(EnvType.CLIENT) 
	public class RedPandaEntityModel extends AnimatedGeoModel<RedPandaEntity>
	{



		@Override
		public Identifier getModelLocation(RedPandaEntity entity)
		{
			return new Identifier(modID,"geo/red_panda.geo.json");
		}

		@Override
		public Identifier getTextureLocation(RedPandaEntity entity)
		{
			return new Identifier(modID,"textures/entities/red_panda.png");
		}

		@Override
		public Identifier getAnimationFileLocation(RedPandaEntity entity)
		{
			return new Identifier(modID,"animations/red.panda.json");
		}

		@Override
		public void setLivingAnimations(RedPandaEntity entity, Integer uniqueID, AnimationEvent customPredicate)
		{
			super.setLivingAnimations(entity, uniqueID, customPredicate);
			IBone head = this.getAnimationProcessor().getBone("head");

			EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
			if (head != null) {
				head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
				head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
			}

		}
		/*public static TexturedModelData getTexturedModelData()
		{
			/*Creation and Storage of the actual model of the entity
			ModelData data = new ModelData();
			ModelPartData modelData = data.getRoot();

			ModelPartData modelBody = modelData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -8.0F, 8.0F, 5.0F, 16.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
			ModelPartData modelHead = modelBody.addChild("head", ModelPartBuilder.create().uv(19,21).cuboid(-6.0F, -6.0F, -4.0F, 3.0F, 3.0F, 1.0F).uv(0,0).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 2.0F)
					.uv(8, 12).cuboid(3.0F, -6.0F, -4.0F, 3.0F, 3.0F, 1.0F).uv(28,21).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 5.0F, 6.0F), ModelTransform.pivot(1.0F, -3.0F, -7.0F));
			ModelPartData modelFrontRightFoot = modelBody.addChild("front_right_foot", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-1.0F, 0.0F, -5.0F));
			ModelPartData modelFrontLeftFoot = modelBody.addChild("front_left_foot", ModelPartBuilder.create().uv(0, 10).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(3.0F, 0.0F, -5.0F));
			ModelPartData modelBackRightFoot = modelBody.addChild("back_right_foot", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-1.0F, 0.0F, 5.0F));
			ModelPartData modelBackLeftFoot = modelBody.addChild("back_left_foot" , ModelPartBuilder.create().uv(6, 7).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(3.0F, 0.0F, 5.0F));
			ModelPartData modelTail = modelBody.addChild("tail", ModelPartBuilder.create().uv(0, 21).cuboid(-2.0F, -3.5F, 0.0F, 4.0F, 5.0F, 9.0F), ModelTransform.pivot(1.0F, -3.5F, 8.0F));

			return TexturedModelData.of(data, 64, 64);
		}

		@Override
		public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
			matrices.translate(0,1.311, 0);
			ImmutableList.of(this.body, this.head, this.back_right_foot, this.back_left_foot, this.front_right_foot, this.front_left_foot, this.tail).forEach((modelRenderer) -> modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha));
		}

		@Override
		public void setAngles(RedPandaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

			this.back_right_foot.pitch = -0.8733046401F;
		}*/
	}




