package net.draconic.wizardry;

import net.draconic.wizardry.registry.ModItems;
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
        addStructureSpawningToAllDimensions();
    }
    /*
     * This will add our structure's spacing to all dimensions so that even json defined dimensions
     * with their own json noise setting file can still spawn our structure if we add it to the
     * dimension's biomes as well.
     *
     *  If you want to do dimension based blacklisting, you will need to manually
     *  remove your structure from the chunkgenerator's structure spacing map.
     * If the spacing or our structure is not added, the structure doesn't spawn in that dimension.
     */
     public static void addStructureSpawningToAllDimensions()
     {
        ServerWorldEvents.LOAD.register((MinecraftServer minecraftServer, ServerWorld serverWorld)->{
            Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig().getStructures());
            tempMap.put(DraconicWizardryStructures.DRAGON_NEST, StructuresConfig.DEFAULT_STRUCTURES.get(DraconicWizardryStructures.DRAGON_NEST));
            ((StructuresConfigAccessor)serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig()).setStructures(tempMap);
        }
        );
     }
}
