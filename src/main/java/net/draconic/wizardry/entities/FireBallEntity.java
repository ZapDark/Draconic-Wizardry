package net.draconic.wizardry.entities;

import net.draconic.wizardry.DraconicWizardryClient;
import net.draconic.wizardry.client.registry.EntityRegistry;
import net.draconic.wizardry.client.registry.EntitySpawnPacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class FireBallEntity extends PersistentProjectileEntity{
    
    //called by FireBallItem
    public FireBallEntity(World world, LivingEntity owner) {
		super(EntityRegistry.FIRE_BALL, owner, world);
	}

    public FireBallEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
		this.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
	}

	public FireBallEntity(EntityType<? extends PersistentProjectileEntity> type, double x, double y, double z, World world) {
		this(type, world);
		this.setPosition(x, y, z);
	}

	public FireBallEntity(EntityType<? extends PersistentProjectileEntity> type, LivingEntity owner, World world) {
		this(type, owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ(), world);
		this.setOwner(owner);
		if (owner instanceof PlayerEntity) {
			this.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
		}

	}

    public FireBallEntity(World world)
    {
        super(EntityRegistry.FIRE_BALL, world);
    }

    @Override
    public void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.world.isClient) {
            Entity entity = entityHitResult.getEntity();
            entity.damage(DamageSource.MAGIC, 7.0f);
            Explosion.DestructionType destructionType = this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
			this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, destructionType);
            if (!entity.isFireImmune()) {
				entity.setOnFireFor(5);
			}
			this.discard();
        }
    }

    @Override
    public void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.world.isClient) {
            Explosion.DestructionType destructionType = this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
			this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, destructionType);
			this.discard();
        }
    }

    @Override
    protected ItemStack asItemStack() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Packet createSpawnPacket() {
        return EntitySpawnPacket.create(this, DraconicWizardryClient.PacketID);
    }
    
}
