package me.a8kj.smptest.parent.packet.providers;

import org.bukkit.entity.Player;

import me.a8kj.smptest.parent.packet.PacketChecker;
import me.a8kj.smptest.parent.packet.PacketProvider;
import me.a8kj.smptest.parent.packet.checkers.PlayerPacketChecker;

/**
 * A specialized {@link PacketProvider} for handling packets sent to players.
 * This interface provides a default implementation for checking if a packet
 * can be sent to a specific player.
 */
public interface PlayerPacketProvider extends PacketProvider<Player> {

    /**
     * Checks whether a packet can be sent to the specified player.
     * This method utilizes {@link PlayerPacketChecker} to perform the validation.
     *
     * @param receiver the player to check
     * @return true if the packet can be sent, false otherwise
     */
    @Override
    default boolean canSend(Player receiver) {
        PacketChecker<Player> checker = new PlayerPacketChecker();
        return checker.check(receiver);
    }
}
