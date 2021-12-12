package net.draconic.wizardry.items;

import net.draconic.wizardry.entities.FireBallEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FireBall extends Item {
    public FireBall(Item.Settings settings) {
        super(settings);
    }

    public FireBallEntity createFireBall(World world, ItemStack stack, LivingEntity shooter) {
        FireBallEntity fireBall = new FireBallEntity(world, shooter);
        return fireBall;
    }
    
}
