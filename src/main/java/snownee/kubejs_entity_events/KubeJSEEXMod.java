package snownee.kubejs_entity_events;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import dev.latvian.mods.kubejs.script.ScriptType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;

public class KubeJSEEXMod implements ModInitializer {

	public static final Logger LOGGER = LogUtils.getLogger();

	@Override
	public void onInitialize() {
		ServerEntityWorldChangeEvents.AFTER_ENTITY_CHANGE_WORLD.register((originalEntity, newEntity, origin, destination) -> {
			if (KubeJSEEXPlugin.ENTITY_WORLD_CHANGED == null || !KubeJSEEXPlugin.ENTITY_WORLD_CHANGED.hasListeners())
				return;
			KubeJSEEXPlugin.ENTITY_WORLD_CHANGED.post(ScriptType.SERVER, newEntity.getType(), new EntityWorldChangedEventJS(originalEntity, newEntity, origin, destination));
		});
		ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
			if (KubeJSEEXPlugin.PLAYER_WORLD_CHANGED == null || !KubeJSEEXPlugin.PLAYER_WORLD_CHANGED.hasListeners())
				return;
			KubeJSEEXPlugin.PLAYER_WORLD_CHANGED.post(ScriptType.SERVER, new PlayerWorldChangedEventJS(player, origin, destination));
		});
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
			if (KubeJSEEXPlugin.KILLED_OTHER_ENTITY == null || !KubeJSEEXPlugin.KILLED_OTHER_ENTITY.hasListeners())
				return;
			KubeJSEEXPlugin.KILLED_OTHER_ENTITY.post(ScriptType.SERVER, new KilledOtherEntityEventJS(world, entity, killedEntity));
		});
		EntityElytraEvents.ALLOW.register(entity -> {
			if (KubeJSEEXPlugin.ALLOW_ELYTRA_FLIGHT == null || !KubeJSEEXPlugin.ALLOW_ELYTRA_FLIGHT.hasListeners())
				return true;
			return KubeJSEEXPlugin.ALLOW_ELYTRA_FLIGHT.post(ScriptType.of(entity), new AllowElytraFlightEventJS(entity)).pass();
		});
	}

}
