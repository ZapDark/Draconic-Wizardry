package net.draconic.wizardry;

import net.fabricme.api.ModInitializer;

public class DraconicWizardry implements ModInitializer
{

    //public static final Item FABRIC_ITEM = new;

    public static final Block TIN_ORE = new TinOreBlock(FabricBlockSettings.copy(Blocks.STONE));

    @Override
    public void OnInitialize(){

        Registry.register(Registry.BLOCK, new Identifier("draconicwizardry", "tin_ore"), TIN_ORE);
        Registry.register(Registry.ITEM, new Identifier("draconicwizardry","tin_ore"), new BlockItem(TIN_ORE, new Item.Settings().group(ItemGroup.BuildingBlocks)));

    }

}