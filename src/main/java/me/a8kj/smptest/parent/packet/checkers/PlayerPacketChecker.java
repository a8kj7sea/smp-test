package me.a8kj.smptest.parent.packet.checkers;

import org.bukkit.entity.Player;

import me.a8kj.smptest.parent.packet.PacketChecker;

/**
 * A concrete implementation of the {@link PacketChecker} interface for checking
 * whether a {@link Player} can receive a packet.
 * This implementation checks if the player is online and valid.
 */
public class PlayerPacketChecker implements PacketChecker<Player> {

    /**
     * Checks if the specified player can receive the packet.
     * This implementation returns true if the player is online and valid.
     *
     * @param player The player to check.
     * @return true if the player is online and valid, false otherwise.
     */
    @Override
    public boolean check(Player player) {
        return player.isOnline() && player.isValid();
    }
}
