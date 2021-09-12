package net.draconic.wizardry.client.models;

import net.fabricmc.api.Environment;
import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.api.EnvType;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@Environment(EnvType.CLIENT) 
	public class RedPandaEntityModel extends AnimatedGeoModel<RedPandaEntity>
	{
		@Override
		public Identifier getModelLocation(RedPandaEntity object)
		{
			return new Identifier(GeckoLib.ModID, "geo/red_panda.geo.json");
		}
	
		@Override
		public Identifier getTextureLocation(RedPandaEntity object)
		{
			return new Identifier(GeckoLib.ModID, "textures/entities/red_panda.png");
		}
	
		@Override
		public Identifier getAnimationFileLocation(RedPandaEntity object)
		{
			return new Identifier(GeckoLib.ModID, "animations/red_panda.json");
		}
		

	
	}





