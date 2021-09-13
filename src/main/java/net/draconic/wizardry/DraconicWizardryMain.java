package net.draconic.wizardry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import software.bernie.geckolib3.GeckoLib;

public class DraconicWizardryMain implements ModInitializer {

   

    @Override
    public void onInitialize() {

        GeckoLib.initialize();

        new EntityReg();

        FabricDefaultAttributeRegistry.register(EntityReg.RED_PANDA, 
        DefEntityAttributes.generateDefaultAttributes());
    
    }
}
