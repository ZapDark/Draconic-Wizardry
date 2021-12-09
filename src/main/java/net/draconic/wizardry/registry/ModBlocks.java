package net.draconic.wizardry.registry;


import net.draconic.wizardry.DraconicWizardryMain;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block TIN_ORE = new Block(FabricBlockSettings
        .of(Material.STONE)
        .breakByTool(FabricToolTags.PICKAXES, 1)
        .strength(3.0f, 15.0f)
        .sounds(BlockSoundGroup.METAL));
    
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(DraconicWizardryMain.modID, "tin_ore"), TIN_ORE);
    }
}
