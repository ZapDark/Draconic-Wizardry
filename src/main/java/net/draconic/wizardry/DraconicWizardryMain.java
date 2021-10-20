package net.draconic.wizardry;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLib;

public class DraconicWizardryMain implements ModInitializer
{
    public static final String modID = "dw";
    public static final DraconicWand DRACONIC_WAND = new DraconicWand(new DraconicWand.Settings().group(ItemGroup.COMBAT));

    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier(modID, "draconic_wand"), DRACONIC_WAND);
        GeckoLib.initialize();

    }
}
