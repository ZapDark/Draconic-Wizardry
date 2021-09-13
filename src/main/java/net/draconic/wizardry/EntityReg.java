package net.draconic.wizardry;


import net.draconic.wizardry.entities.RedPandaEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityReg {
    public static final String MOD_ID = "dw";

    public static final EntityType<RedPandaEntity> RED_PANDA = Registry.register(
    Registry.ENTITY_TYPE,
    new Identifier("daw", "red_panda"),
    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedPandaEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());


}
