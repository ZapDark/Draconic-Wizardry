package net.draconic.wizardry.client.models;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class practice extends EntityModel<Entity> {
	private final ModelRenderer root;
	private final ModelRenderer body;
	private final ModelRenderer front_right_foot;
	private final ModelRenderer back_right_foot;
	private final ModelRenderer front_left_foot;
	private final ModelRenderer back_left_foot;
	private final ModelRenderer head;
	private final ModelRenderer tail;
	private final ModelRenderer tail_r1;

	public practice() {
		textureWidth = 64;
		textureHeight = 64;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 21.0F, 0.0F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(body);
		body.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -8.0F, 8.0F, 5.0F, 16.0F, 0.0F, false);

		front_right_foot = new ModelRenderer(this);
		front_right_foot.setRotationPoint(-1.0F, 0.0F, -5.0F);
		body.addChild(front_right_foot);
		front_right_foot.setTextureOffset(0, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		back_right_foot = new ModelRenderer(this);
		back_right_foot.setRotationPoint(-1.0F, 0.0F, 5.0F);
		body.addChild(back_right_foot);
		back_right_foot.setTextureOffset(0, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		front_left_foot = new ModelRenderer(this);
		front_left_foot.setRotationPoint(3.0F, 0.0F, -5.0F);
		body.addChild(front_left_foot);
		front_left_foot.setTextureOffset(0, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		back_left_foot = new ModelRenderer(this);
		back_left_foot.setRotationPoint(3.0F, 0.0F, 5.0F);
		body.addChild(back_left_foot);
		back_left_foot.setTextureOffset(6, 7).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(1.0F, -3.0F, -7.0F);
		root.addChild(head);
		head.setTextureOffset(19, 21).addBox(-6.0F, -6.0F, -4.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(8, 12).addBox(3.0F, -6.0F, -4.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(28, 21).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 5.0F, 6.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(tail);
		

		tail_r1 = new ModelRenderer(this);
		tail_r1.setRotationPoint(1.0F, -3.5F, 8.0F);
		tail.addChild(tail_r1);
		setRotationAngle(tail_r1, 0.2182F, 0.0F, 0.0F);
		tail_r1.setTextureOffset(0, 21).addBox(-2.0F, -3.5F, 0.0F, 4.0F, 5.0F, 9.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		root.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
            float headPitch) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
            float blue, float alpha) {
        // TODO Auto-generated method stub
        
    }
}