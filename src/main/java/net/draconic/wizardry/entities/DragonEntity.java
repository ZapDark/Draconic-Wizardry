package net.draconic.wizardry.entities;

import net.draconic.wizardry.client.registry.EntityRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;

public class DragonEntity extends HostileEntity implements IAnimatable
{
    AnimationFactory factory = new AnimationFactory(this);
    public boolean DragonCanSpawn = true;

    public DragonEntity(EntityType<? extends HostileEntity> entityType, World world)
    {
        super(entityType, world);
        this.moveControl = new DragonFlyingMovementController(this, 8,false);
    }

    public static DefaultAttributeContainer.Builder dragonStats()
    {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED,2D);
    }

    @Override
    public void initGoals()
    {
        super.initGoals();
        this.goalSelector.add(0, new WanderAroundGoal(this, 0.5D));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(4, new AttackGoal(this));

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

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource)
    {
        return false;
    }

    public int getLimitPerChunk()
    {
        return 1;
    }

    @Override
    public boolean canSpawn(WorldView view)
    {
        BlockPos blockUnderEntity = new BlockPos(this.getX(), this.getY()-1, this.getZ());
        BlockPos posEntity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this) && this.world.isNight() && !world.containsFluid(this.getBoundingBox())
                && this.world.getBlockState(posEntity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockUnderEntity).allowsSpawning(view, blockUnderEntity, EntityRegistry.DRAGON)
                && DragonCanSpawn;
    }

}
