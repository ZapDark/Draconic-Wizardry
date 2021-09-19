package net.draconic.wizardry.client.models;

import com.google.common.collect.ImmutableList;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT) 
	public class RedPandaEntityModel<R extends AnimalEntity> extends EntityModel<RedPandaEntity>
	{
		private final ModelPart body;
		private final ModelPart front_right_foot;
		private final ModelPart back_right_foot;
		private final ModelPart front_left_foot;
		private final ModelPart back_left_foot;
		private final ModelPart head;
		private final ModelPart tail;

		public RedPandaEntityModel(ModelPart root) {

			this.body = root.getChild("body");
			this.head = body.getChild("head");
			this.front_right_foot = body.getChild("front_right_foot");
			this.back_right_foot = body.getChild("back_right_foot");
			this.front_left_foot = body.getChild("front_left_foot");
			this.back_left_foot = body.getChild("back_left_foot");
			this.tail = body.getChild("tail");
		}
		public static TexturedModelData getTexturedModelData()
		{
			/*Creation and Storage of the actual model of the entity*/
			ModelData data = new ModelData();
			ModelPartData modelData = data.getRoot();

			ModelPartData modelBody = modelData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -8.0F, 8.0F, 5.0F, 16.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
			ModelPartData modelHead = modelBody.addChild("head", ModelPartBuilder.create().uv(19,21).cuboid(-6.0F, -6.0F, -4.0F, 3.0F, 3.0F, 1.0F).uv(0,0).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 2.0F)
					.uv(8, 12).cuboid(3.0F, -6.0F, -4.0F, 3.0F, 3.0F, 1.0F).uv(28,21).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 5.0F, 6.0F), ModelTransform.pivot(1.0F, -3.0F, -7.0F));
			ModelPartData modelFrontRightFoot = modelBody.addChild("front_right_foot", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-1.0F, 0.0F, -5.0F));
			ModelPartData modelFrontLeftFoot = modelBody.addChild("front_left_foot", ModelPartBuilder.create().uv(0, 10).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(3.0F, 0.0F, -5.0F));
			ModelPartData modelBackRightFoot = modelBody.addChild("back_right_foot", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-1.0F, 0.0F, 5.0F));
			ModelPartData modelBackLeftFoot = modelBody.addChild("back_left_foot" , ModelPartBuilder.create().uv(0, 10).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(3.0F, 0.0F, 5.0F));
			ModelPartData modelTail = modelBody.addChild("tail", ModelPartBuilder.create().uv(0, 21).cuboid(-2.0F, -3.5F, 0.0F, 4.0F, 5.0F, 9.0F), ModelTransform.pivot(1.0F, -3.5F, 8.0F));

			return TexturedModelData.of(data, 64, 64);
		}

		@Override
		public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
			ImmutableList.of(this.body, this.head, this.back_right_foot, this.back_left_foot, this.front_right_foot, this.front_left_foot, this.tail).forEach((modelRenderer) -> modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha));
		}

		@Override
		public void setAngles(RedPandaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

		}
	}





