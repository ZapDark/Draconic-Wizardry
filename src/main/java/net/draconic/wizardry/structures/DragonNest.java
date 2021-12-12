package net.draconic.wizardry.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.telepathicgrunt.structure_tutorial.StructureTutorialMain;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.apache.logging.log4j.Level;

import java.util.List;

public class DragonNestStructure extends StructureFeature<DefaultFeatureConfig>
{
  public DragonNestStructure(Codec<DefaultFeatureConfig> codec)
  {
    super(codec);
  }
  
  @Override
  public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory()
  {
    return DragonNestStructure.Start::new;
  }
  
   /**
     * || ONLY WORKS IN FORGE 34.1.12+ ||
     *
     * This method allows us to have mobs that spawn naturally over time in our structure.
     * No other mobs will spawn in the structure of the same entity classification.
     * The reason you want to match the classifications is so that your structure's mob
     * will contribute to that classification's cap. Otherwise, it may cause a runaway
     * spawning of the mob that will never stop.
     *
     * NOTE: getDefaultSpawnList is for monsters only and getDefaultCreatureSpawnList is
     *       for creatures only. If you want to add entities of another classification,
     *       use the StructureSpawnListGatherEvent to add water_creatures, water_ambient,
     *       ambient, or misc mobs. Use that event to add/remove mobs from structures
     *       that are not your own.
     */
   /*
   Examples:
   private static final List<spawnSettings.SpawnEntry> STRUCTURE_MONSTERS = ImmutableList.of
      (
      new SpawnSettings.SpawnEntry(EntityType.ILLUSIONER, 100, 4, 9)
      );
   @Override
   public Lists<SpawnSettings.SpawnEntry> getMonsterSpawns()
      {
        return STRUCTURE_MONSTERS;
      }
   private static final Lists<SpawnSettings.SpawnEntry> STRUCTURE_CREATURES = ImmutablesList.of
      (
      new SpawnSettings.SpawnEntry(EntityType.SHEEP, 30, 10, 15)
      );
      @Override
      public List<SpawnSettings.SpawnEntry> getCreatureSpawns()
        {
          return STRUCTURE_CREATURES;
        }
   */
   
   /*
     * This is where extra checks can be done to determine if the structure can spawn here.
     * This only needs to be overridden if you're adding additional spawn conditions.
     *
     * Fun fact, if you set your structure separation/spacing to be 0/1, you can use
     * shouldStartAt to return true only if certain chunk coordinates are passed in
     * which allows you to spawn structures only at certain coordinates in the world.
     *
     * Notice how the biome is also passed in. Though, you are not going to do any biome
     * checking here as you should've added this structure to the biomes you
     * wanted already with the biome load event.
     * 
     * Basically, this method is used for determining if the land is at a suitable height,
     * if certain other structures are too close or not, or some other restrictive condition.
     *
     * For example, Pillager Outposts added a check to make sure it cannot spawn within 10 chunk of a Village.
     * (Bedrock Edition seems to not have the same check)
     * 
     * 
     * Also, please for the love of god, do not do dimension checking here.
     * If you do and another mod's dimension is trying to spawn your structure,
     * the locate command will make minecraft hang forever and break the game.
     *
     * Instead, use the removeStructureSpawningFromSelectedDimension method in
     * StructureTutorialMain class. If you check for the dimension there and do not add your
     * structure's spacing into the chunk generator, the structure will not spawn in that dimension!
     */
     @Override
     protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed, ChunkRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, DefaultFeatureConfig featureConfig)
     {
        BlockPos centerOfChunk = new BlockPos((chunkX << 4) + 7, 0, (chunkZ << 4) + 7);
        int landHeight = chunkGenerator.getHeightInGround(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG);
        BlockView columnOfBlocks = chunkGenerator.getColumnSample(centerOfChunk.getX(), centerOfChunk.getZ());
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.up(landHeight));
        return topBlock.getFluidState().isEmpty() //landHeight > 100;
     }
     
     // Handles calling up the structure's pieces class and height that structure will spawn at.
    public static class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureIn, int chunkX, int chunkZ, BlockBox blockBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, blockBox, referenceIn, seedIn);
        }
        @Override
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, int chunkX, intchunkZ, Biome biome, DefaultFeatureConfig defaultFeatureConfig)
        {
          //Turns the chunk coordinates into actual coordinates we can use. (Gets center of that chunk)
          int x = (chunkX << 4) + 7;
          int z = (chunkZ << 4) + 7;
          
          
             /* 
             * We pass this into method_30419 to tell it where to generate the structure.
             * If method_30419's last parameter is true, blockpos's Y value is ignored and the
             * structure will spawn at terrain height instead. Set that parameter to false to
             * force the structure to spawn at blockpos's Y value instead. You got options here!
             */
             
            BlockPos.Mutable blockpos = new BlockPos.Mutable(x, 0, z);

            
             /* 
             * If you are doing Nether structures, you'll probably want to spawn your structure on top of ledges.
             * Best way to do that is to use getColumnSample to grab a column of blocks at the structure's x/z position.
             * Then loop through it and look for land with air above it and set blockpos's Y value to it.
             * Make sure to set the final boolean in StructurePoolBasedGenerator.method_30419 to false so
             * that the structure spawns at blockpos's y value instead of placing the structure on the Bedrock roof!
             */
             
            //BlockView blockView = chunkGenerator.getColumnSample(blockpos.getX(), blockpos.getZ());

            // All a structure has to do is call this method to turn it into a jigsaw based structure!
            StructurePoolBasedGenerator.method_30419(
                    dynamicRegistryManager,
                    new StructurePoolFeatureConfig(() -> dynamicRegistryManager.get(Registry.TEMPLATE_POOL_WORLDGEN)
                            // The path to the starting Template Pool JSON file to read.
                            //
                            // Note, this is "structure_tutorial:run_down_house/start_pool" which means
                            // the game will automatically look into the following path for the template pool:
                            // "resources/data/structure_tutorial/worldgen/template_pool/run_down_house/start_pool.json"
                            // This is why your pool files must be in "data/<modid>/worldgen/template_pool/<the path to the pool here>"
                            // because the game automatically will check in worldgen/template_pool for the pools.
                            .get(new Identifier(DraconicWizardryMain.modID, "dragon_nest/start_pool")),

                            // How many pieces outward from center can a recursive jigsaw structure spawn.
                            // Our structure is only 1 piece outward and isn't recursive so any value of 1 or more doesn't change anything.
                            // However, I recommend you keep this a decent value like 10 so people can use datapacks to add additional pieces to your structure easily.
                            // But don't make it too large for recursive structures like villages or you'll crash server due to hundreds of pieces attempting to generate!
                            10),
                    PoolStructurePiece::new,
                    chunkGenerator,
                    structureManager,
                    blockpos, //Position of the structure. Y value is ignored if last parameter is set to true.
                    this.children, //The list that will be populated with the jigsaw pieces after this method.
                    this.random,
                    false, //Special boundary adjustments for villages. It's... hard to explain. Keep this false and make your pieces not be partially intersecting.
                           //Either not intersecting or fully contained will make children pieces spawn just fine. It's easier that way.
                    true); //Place at heightmap (top land). Set this to false for structure to be place at the passed in blockpos's Y value instead.
                           //Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.
