package snownee.kubejs_entity_events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;

public class KubeJSEEXMod implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("KubeJSEEE");

	@Override
	public void onInitialize() {
		ServerEntityWorldChangeEvents.AFTER_ENTITY_CHANGE_WORLD.register((originalEntity, newEntity, origin, destination) -> {
			if (KubeJSEEXPlugin.ENTITY_WORLD_CHANGED != null)
				KubeJSEEXPlugin.ENTITY_WORLD_CHANGED.post(newEntity.getType(), new EntityWorldChangedEventJS(originalEntity, newEntity, origin, destination));
		});
		ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
			if (KubeJSEEXPlugin.PLAYER_WORLD_CHANGED != null)
				KubeJSEEXPlugin.PLAYER_WORLD_CHANGED.post(new PlayerWorldChangedEventJS(player, origin, destination));
		});
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
			if (KubeJSEEXPlugin.KILLED_OTHER_ENTITY != null)
				KubeJSEEXPlugin.KILLED_OTHER_ENTITY.post(new KilledOtherEntityEventJS(world, entity, killedEntity));
		});
		EntityElytraEvents.ALLOW.register(entity -> {
			if (KubeJSEEXPlugin.ALLOW_ELYTRA_FLIGHT != null && KubeJSEEXPlugin.ALLOW_ELYTRA_FLIGHT.post(new AllowElytraFlightEventJS(entity)))
				return false;
			return true;
		});
	}

}
