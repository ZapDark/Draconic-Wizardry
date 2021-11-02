package net.draconic.wizardry;

import net.fabricmc.api.ModInitializer;
import software.bernie.geckolib3.GeckoLib;

public class DraconicWizardryMain implements ModInitializer
{
    public static final String modID = "dw";

    @Override
    public void onInitialize()
    {
        GeckoLib.initialize();

    }
}
