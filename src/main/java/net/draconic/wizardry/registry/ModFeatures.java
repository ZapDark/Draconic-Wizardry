package net.draconic.wizardry.registry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.feature.Feature;
import net.draconic.wizardry.DraconicWizardryMain;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

public class ModFeatures {

    public static ConfiguredFeature<?, ?> TIN_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.TIN_ORE.getDefaultState(), 9))
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(128))))).spreadHorizontally().repeat(20);

    public static void registerFeatures() {
        RegistryKey<ConfiguredFeature<?, ?>> tinOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(DraconicWizardryMain.modID, "tin_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tinOreOverworld.getValue() , TIN_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, tinOreOverworld);
    }
}
