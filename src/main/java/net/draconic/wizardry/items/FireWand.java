package net.draconic.wizardry.items;

import net.draconic.wizardry.entities.FireBallEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FireWand extends Item {

    public FireWand(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack wand = player.getStackInHand(hand);
        if (!world.isClient) {
            FireBall fireBall = new FireBall(new Item.Settings().group(ItemGroup.COMBAT));
            FireBallEntity fireballEntity = fireBall.createFireBall(world, wand, player);
			fireballEntity.setProperties(player, player.getPitch(), player.getYaw(), 0.0F, 3.0F, 1.0F);
            world.spawnEntity(fireballEntity);
        }
        return TypedActionResult.pass(wand);
    }
}
        

