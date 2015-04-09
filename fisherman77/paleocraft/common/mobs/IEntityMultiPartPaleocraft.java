package fisherman77.paleocraft.common.mobs;

import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public interface IEntityMultiPartPaleocraft
{
    World func_82194_d();

    boolean attackEntityFromPart(EntityQuetzPart p_70965_1_, DamageSource p_70965_2_, float p_70965_3_);
}
