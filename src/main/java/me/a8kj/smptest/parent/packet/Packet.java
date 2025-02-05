package me.a8kj.smptest.parent.packet;

/**
 * Represents a packet in the SMP environment.
 * Implementations of this interface define the packet type and the method for
 * retrieving the packet that will be sent.
 */
public interface Packet {

    /**
     * Retrieves the name of the packet.
     * The packet name can be used for logging, debugging, or identifying the packet
     * type.
     * 
     * @return the name of the packet
     */
    String getName();

    /**
     * Retrieves the corresponding Bukkit (or NMS) packet.
     * The packet returned should be in a format compatible with the server's
     * version.
     * 
     * @return the corresponding packet
     */
    default Object getBukkitPacket() {
        return null;
    }
}