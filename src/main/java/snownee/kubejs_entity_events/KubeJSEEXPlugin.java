package snownee.kubejs_entity_events;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.bindings.event.EntityEvents;
import dev.latvian.mods.kubejs.bindings.event.PlayerEvents;
import dev.latvian.mods.kubejs.event.EventHandler;

public class KubeJSEEXPlugin extends KubeJSPlugin {

	public static EventHandler ENTITY_WORLD_CHANGED;
	public static EventHandler PLAYER_WORLD_CHANGED;
	public static EventHandler KILLED_OTHER_ENTITY;
	public static EventHandler ALLOW_ELYTRA_FLIGHT;

	@Override
	public void init() {
		KubeJSEEXMod.LOGGER.info("KubeJS Entity Events Extension is there!");
	}

	@Override
	public void registerEvents() {
		ENTITY_WORLD_CHANGED = EntityEvents.GROUP.server("worldChanged", () -> EntityWorldChangedEventJS.class).extra(EntityEvents.SUPPORTS_ENTITY_TYPE);
		PLAYER_WORLD_CHANGED = PlayerEvents.GROUP.server("worldChanged", () -> PlayerWorldChangedEventJS.class);
		KILLED_OTHER_ENTITY = EntityEvents.GROUP.server("killedOtherEntity", () -> KilledOtherEntityEventJS.class).extra(EntityEvents.SUPPORTS_ENTITY_TYPE);
		ALLOW_ELYTRA_FLIGHT = EntityEvents.GROUP.common("allowElytraFlight", () -> AllowElytraFlightEventJS.class).extra(EntityEvents.SUPPORTS_ENTITY_TYPE).hasResult();
	}

}
