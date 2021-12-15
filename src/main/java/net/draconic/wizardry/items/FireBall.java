package net.draconic.wizardry.items;

import net.draconic.wizardry.entities.FireBallEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class FireBall extends Item {
    public FireBall(Item.Settings settings) {
        super(settings);
    }

    public FireBallEntity createFireBall(World world, LivingEntity shooter) {
        FireBallEntity fireBallEntity = new FireBallEntity(world, shooter);
        return fireBallEntity;
    }
    
}
