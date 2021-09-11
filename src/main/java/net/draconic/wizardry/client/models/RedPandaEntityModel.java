package net.draconic.wizardry.client.models;

import net.fabricmc.api.Environment;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@Environment(EnvType.CLIENT) 
	public class RedPandaEntityModel extends AnimatedGeoModel<RedPandaEntity>
	{
		@Override
		public Identifier getModelLocation(RedPandaEntity object)
		{
			return new Identifier(GeckoLib.ModID, "geo/jack.geo.json");
		}
	
		@Override
		public Identifier getTextureLocation(RedPandaEntity object)
		{
			return new Identifier(GeckoLib.ModID, "textures/item/jack.png");
		}
	
		@Override
		public Identifier getAnimationFileLocation(RedPandaEntity object)
		{
			return new Identifier(GeckoLib.ModID, "animations/jackinthebox.animation.json");
		}
		

	
	}





