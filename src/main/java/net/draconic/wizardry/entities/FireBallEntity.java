package net.draconic.wizardry.entities;

import net.draconic.wizardry.registry.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FireBallEntity extends PersistentProjectileEntity{

    public FireBallEntity(EntityType<? extends PersistentProjectileEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public FireBallEntity(World world, LivingEntity shooter) {
        super(EntityType.ARROW, shooter, world);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.FIREBALL);
    }
    
}
