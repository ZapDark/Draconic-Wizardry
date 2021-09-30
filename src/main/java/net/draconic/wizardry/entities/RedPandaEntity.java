package net.draconic.wizardry.entities;

import net.draconic.wizardry.client.registry.EntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class RedPandaEntity extends AnimalEntity implements IAnimatable {

    AnimationFactory factory = new AnimationFactory(this);
    private RedPandaState redPandaState = RedPandaState.idle;

    public enum RedPandaState
    {
        idle,
        moving
    }


    public RedPandaEntity(EntityType<? extends AnimalEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.ignoreCameraFrustum = true;

    }

    public static DefaultAttributeContainer.Builder generateRedPandaAttributes() 
    {
        return AnimalEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D);
    }

    @Override
    public void initGoals(){
        super.initGoals();
        this.goalSelector.add(0, new WanderAroundGoal(this, 0.5D));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(3, new SwimGoal(this));

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        //SCENARIO 1 - This is when he's not moving, and we know he is not moving
        //SCENARIO 2 - This is when he is moving, and we think he is not moving
        //SCENARIO 3 - This is when he is moving, and we think he is moving
        //SCENARIO 4 - This is when he is  not moving, and we think he is moving

        if(!event.isMoving() && redPandaState == RedPandaState.idle)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("red.panda.tailwag", true));
            return PlayState.CONTINUE;
        }
        else if(event.isMoving() && redPandaState == RedPandaState.idle)
        {
            //event.getController().setAnimation(new AnimationBuilder().addAnimation("red.panda.tailwag", true));
            redPandaState = RedPandaState.moving;
            return PlayState.STOP;
        }
        else if(event.isMoving() && redPandaState == RedPandaState.moving)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("red.panda.walk", true));
            return PlayState.CONTINUE;
        }
        else
        {
            //event.getController().setAnimation(new AnimationBuilder().addAnimation("red.panda.walk", true));
            redPandaState = RedPandaState.idle;
            return PlayState.STOP;
        }

    }

    @Override
    public void registerControllers(AnimationData animationData)
    {
        animationData.addAnimationController(new AnimationController<>(this, "controller", 1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return (PassiveEntity) EntityRegistry.RED_PANDA.create(world);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource)
    {
        return super.handleFallDamage(fallDistance, damageMultiplier, damageSource);

    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.getItem() == Items.GLOW_BERRIES;
    }
}
