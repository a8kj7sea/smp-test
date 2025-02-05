package me.a8kj.smptest.parent.packet;

/**
 * Represents a check that validates whether an entity can receive a packet.
 * This interface allows for customizable checks for different types of entities
 * (e.g., Player, Entity, NPC) to determine if a packet can be sent.
 *
 * @param <Entity> The type of entity to check, typically a Player or Entity.
 */
public interface PacketChecker<Entity> {

    /**
     * Checks whether the specified entity can receive the packet.
     *
     * @param entity The entity to check. This could be a Player, Entity, or other
     *               types.
     * @return true if the entity can receive the packet, false otherwise.
     */
    boolean check(Entity entity);
}
