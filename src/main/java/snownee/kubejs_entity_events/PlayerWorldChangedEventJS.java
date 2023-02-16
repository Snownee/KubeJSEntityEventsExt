package snownee.kubejs_entity_events;

import dev.latvian.mods.kubejs.player.PlayerEventJS;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class PlayerWorldChangedEventJS extends PlayerEventJS {

	private final Player player;
	private final ServerLevel origin;
	private final ServerLevel destination;

	public PlayerWorldChangedEventJS(ServerPlayer player, ServerLevel origin, ServerLevel destination) {
		this.player = player;
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public Player getEntity() {
		return player;
	}

	public ServerLevel getOrigin() {
		return origin;
	}

	public ServerLevel getDestination() {
		return destination;
	}

}
