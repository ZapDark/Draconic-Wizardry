package net.draconic.wizardry;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.util.Hand;

public class DraconicWand extends Item{

    public DraconicWand(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        return null;      
    }
}
