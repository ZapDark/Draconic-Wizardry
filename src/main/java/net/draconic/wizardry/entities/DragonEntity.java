package net.draconic.wizardry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DragonEntity extends HostileEntity implements IAnimatable
{
    AnimationFactory factory = new AnimationFactory(this);

    public DragonEntity(EntityType<? extends HostileEntity> entityType, World world)
    {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
    }

    public static DefaultAttributeContainer.Builder generateDragonSpecs()
    {
        return AnimalEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0D);
    }

    @Override
    public void registerControllers(AnimationData animationData)
    {

    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }
}
