package me.a8kj.smptest.parent.packet;

/**
 * Provides a mechanism to send packets to a receiver in the SMP environment.
 * Implementations of this interface define how packets are sent and whether
 * they can be sent to a specific receiver.
 *
 * @param <Receiver> the type of the receiver that will receive the packet
 */
public interface PacketProvider<Receiver> {

    /**
     * Sends a packet to the specified receiver.
     *
     * @param receiver the receiver to whom the packet will be sent
     */
    void send(Packet packet, Receiver receiver);

    /**
     * Determines whether a packet can be sent to the specified receiver.
     *
     * @param receiver the receiver to check
     * @return true if the packet can be sent, false otherwise
     */
    boolean canSend(Receiver receiver);
}
