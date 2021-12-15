package net.draconic.wizardry.entities.goals;

import net.draconic.wizardry.entities.DragonEntity;
import net.minecraft.entity.ai.goal.Goal;

public class flyGoal extends Goal
{
    private final DragonEntity dragonEntity;

    public flyGoal(DragonEntity dragonEntity)
    {
        this.dragonEntity = dragonEntity;
    }

    @Override
    public boolean canStart()
    {
        return false;
    }
}
