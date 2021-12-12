package net.draconic.wizardry;

import net.draconic.wizardry.registry.*;
import net.fabricmc.api.ModInitializer;
import software.bernie.geckolib3.GeckoLib;

public class DraconicWizardryMain implements ModInitializer
{
    public static final String modID = "dw";

    @Override
    public void onInitialize()
    {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModFeatures.registerFeatures();
        GeckoLib.initialize();

    }
}
