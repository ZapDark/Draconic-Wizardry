package net.draconic.wizardry.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.draconic.wizardry.items.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.draconic.wizardry.DraconicWizardryMain;

public class ModItems{
    public static final Item FIRE_GEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item ICE_GEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item WATER_GEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item MAGIC_GEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item EARTH_GEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final FireWand FIRE_WAND = new FireWand(new FireWand.Settings().group(ItemGroup.COMBAT));
    public static final IceWand ICE_WAND = new IceWand(new IceWand.Settings().group(ItemGroup.COMBAT));
    public static final WaterWand WATER_WAND = new WaterWand(new WaterWand.Settings().group(ItemGroup.COMBAT));
    public static final MagicWand MAGIC_WAND = new MagicWand(new MagicWand.Settings().group(ItemGroup.COMBAT));
    public static final EarthWand EARTH_WAND = new EarthWand(new EarthWand.Settings().group(ItemGroup.COMBAT));

    
    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "fire_gem"), FIRE_GEM);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "ice_gem"), ICE_GEM);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "water_gem"), WATER_GEM);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "magic_gem"), MAGIC_GEM);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "earth_gem"), EARTH_GEM);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "fire_wand"), FIRE_WAND);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "ice_wand"), ICE_WAND);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "water_wand"), WATER_WAND);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "magic_wand"), MAGIC_WAND);
        Registry.register(Registry.ITEM, new Identifier(DraconicWizardryMain.modID, "earth_wand"), EARTH_WAND);
        

    }
    
}
