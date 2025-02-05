package me.a8kj.smptest.parent.packet.providers;

import org.bukkit.Location;

import me.a8kj.smptest.parent.packet.Packet;
import me.a8kj.smptest.parent.packet.PacketProvider;

/**
 * Handles sending packets to a specific location.
 */
public class LocationPacketProvider implements PacketProvider<Location> {

    @Override
    public void send(Packet packet, Location receiver) {
        if (canSend(receiver)) {
            packet.getBukkitPacket();
        }
    }

    @Override
    public boolean canSend(Location receiver) {
        return receiver != null && receiver.getWorld() != null;
    }
}
