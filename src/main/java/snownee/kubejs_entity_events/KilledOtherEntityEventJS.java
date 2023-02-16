package snownee.kubejs_entity_events;

import dev.latvian.mods.kubejs.entity.EntityEventJS;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class KilledOtherEntityEventJS extends EntityEventJS {

	private final ServerLevel world;
	private final Entity entity;
	private final LivingEntity killedEntity;

	public KilledOtherEntityEventJS(ServerLevel world, Entity entity, LivingEntity killedEntity) {
		this.world = world;
		this.entity = entity;
		this.killedEntity = killedEntity;
	}

	@Override
	public Entity getEntity() {
		return entity;
	}

	@Override
	public Level getLevel() {
		return world;
	}

	public LivingEntity getKilledEntity() {
		return killedEntity;
	}

}
