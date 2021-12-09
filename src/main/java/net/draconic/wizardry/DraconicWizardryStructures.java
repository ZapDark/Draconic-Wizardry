package net.draconic.wizardry;

import net.draconic.wizardry.structures.DragonNestStructure
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class DraconicWizardryStructures
{
  public static StructureFeature<DefaultFeatureConfig> DRAGON_NEST = new DragonNestStructure(DefaultFeatureConfig.CODEC);
  //public static void setupAndRegisterStructureFeatures()
  {
    FabricStructureBuilder.create(new Identifier(DraconicWizardryMain.modID, "dragon_nest"), DRAGON_NEXT)
    .step(GenerationStep.Feature.SURFACE_STRUCTURES)
    .defaultConfig(new StructureConfig(
          100, // average distance apart in chunks between spawn attempts
          10, // minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE
          409798521 // this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique.))
    .superflatFeature(DRAGON_NEST.configure(FeatureConfig.DEFAULT))
    .adjustsSurface()
    .register();
  }
}
