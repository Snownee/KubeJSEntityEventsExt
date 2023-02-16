package snownee.kubejs_entity_events;

import dev.latvian.mods.kubejs.entity.LivingEntityEventJS;
import net.minecraft.world.entity.LivingEntity;

public class AllowElytraFlightEventJS extends LivingEntityEventJS {

	private final LivingEntity entity;

	public AllowElytraFlightEventJS(LivingEntity entity) {
		this.entity = entity;
	}

	@Override
	public LivingEntity getEntity() {
		return entity;
	}

}
