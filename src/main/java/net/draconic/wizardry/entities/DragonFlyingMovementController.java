package net.draconic.wizardry.entities;

import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

public class DragonFlyingMovementController extends FlightMoveControl
{
    private final int maxPitchChange;
    private final boolean noGravity;
    public DragonFlyingMovementController(MobEntity entity, int maxPitchChange, boolean noGravity)
    {
        super(entity, maxPitchChange, noGravity);
        this.maxPitchChange = maxPitchChange;
        this.noGravity = noGravity;
    }

    public void tick()
    {
        if (this.state == State.MOVE_TO)
        {
            this.state = State.WAIT;
            this.entity.setNoGravity(true);
            double d = this.targetX - this.entity.getX();
            double e = this.targetY - this.entity.getY();
            double f = this.targetZ - this.entity.getZ();
            double g = d * d + e * e + f * f;
            if (g < 2.500000277905201E-7D)
            {
                this.entity.setUpwardSpeed(0.0F);
                this.entity.setForwardSpeed(0.0F);
                return;
            }

            float h = (float)(MathHelper.atan2(f, d) * 57.2957763671875D) - 90.0F;
            this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), h, 90.0F));
            float j;
            if (this.entity.isOnGround())
            {
                j = (float)(this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
            }
            else
            {
                j = (float)(this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED));
            }

            this.entity.setMovementSpeed(j);
            double k = Math.sqrt(d * d + f * f);
            if (Math.abs(e) > 9.999999747378752E-6D || Math.abs(k) > 9.999999747378752E-6D)
            {
                float l = (float)(-(MathHelper.atan2(e, k) * 57.2957763671875D));
                this.entity.setPitch(this.wrapDegrees(this.entity.getPitch(), l, (float)this.maxPitchChange));
                this.entity.setUpwardSpeed(e > 0.0D ? j : -j);
            }
        }
        else
        {
            if (!this.noGravity)
            {
                this.entity.setNoGravity(false);
            }

            this.entity.setUpwardSpeed(0.0F);
            this.entity.setForwardSpeed(0.0F);
        }

    }
}
