package snownee.kubejs_entity_events;

import dev.latvian.mods.kubejs.entity.EntityEventJS;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class EntityWorldChangedEventJS extends EntityEventJS {

	private final Entity originalEntity;
	private final Entity newEntity;
	private final ServerLevel origin;
	private final ServerLevel destination;

	public EntityWorldChangedEventJS(Entity originalEntity, Entity newEntity, ServerLevel origin, ServerLevel destination) {
		this.originalEntity = originalEntity;
		this.newEntity = newEntity;
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public Entity getEntity() {
		return getNewEntity();
	}

	public Entity getOriginalEntity() {
		return originalEntity;
	}

	public Entity getNewEntity() {
		return newEntity;
	}

	public ServerLevel getOrigin() {
		return origin;
	}

	public ServerLevel getDestination() {
		return destination;
	}

}
