package net.draconic.wizardry;

import net.draconic.wizardry.client.registry.*;
import net.draconic.wizardry.registry.*;
import net.fabricmc.api.ModInitializer;
import software.bernie.geckolib3.GeckoLib;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class DraconicWizardryMain implements ModInitializer
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String modID = "dw";

    @Override
    @SuppressWarnings("deprecation")
    public void onInitialize()
    {
        ModBlocks.registerBlocks();
        ModFeatures.registerFeatures();
        EntityRegistry.register();
        SpawnInit.init();
        ModItems.registerItems();
        GeckoLib.initialize();
        DraconicWizardryStructures.setupAndRegisterStructureFeatures();
        DraconicWizardryConfiguredStructures.registerConfiguredStructures();
        BiomeModifications.create(new Identifier(modID, "dragon_nest_addition"))
            .add(
                    ModificationPhase.ADDITIONS,
                    BiomeSelectors.all(),
                    context -> {
                        context.getGenerationSettings().addBuiltInStructure(DraconicWizardryConfiguredStructures.CONFIGURED_DRAGON_NEST);
                    }
            );
    }
}
