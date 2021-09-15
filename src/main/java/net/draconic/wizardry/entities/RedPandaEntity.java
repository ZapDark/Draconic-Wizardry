package net.draconic.wizardry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import net.minecraft.entity.mob.MobEntity;

public class RedPandaEntity extends AnimalEntity implements IAnimatable 
{

    private AnimationFactory manager = new AnimationFactory(this);

    public RedPandaEntity(EntityType<? extends AnimalEntity> type, World worldIn) 
    {
        super(type, worldIn);

        this.ignoreCameraFrustum = true;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
    {
        if(event.isMoving()) 
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("red_panda_walk.json", true));
            return PlayState.CONTINUE;
        }
        else
        {
            return null;
        }
    }
        
    
    @Override
    public void registerControllers(AnimationData data) 
    {
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() 
    {
        return this.manager;
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) 
    {
        return null;
    }

    public static DefaultAttributeContainer.Builder generateRedPandaAttributes() 
    {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0D)
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE,10.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D);
    }

    
    
}
