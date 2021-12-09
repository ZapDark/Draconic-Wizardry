package net.draconic.wizardry.entities.Controllers;

import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.mob.MobEntity;

public class DragonFlyingMovementController extends FlightMoveControl
{
    public DragonFlyingMovementController(MobEntity entity, int maxPitchChange, boolean noGravity) {
        super(entity, maxPitchChange, noGravity);
    }
}
