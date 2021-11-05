package net.draconic.wizardry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DragonEntity extends HostileEntity implements IAnimatable
{
    AnimationFactory factory = new AnimationFactory(this);

    protected DragonEntity(EntityType<? extends HostileEntity> entityType, World world)
    {
        super(entityType, world);
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
