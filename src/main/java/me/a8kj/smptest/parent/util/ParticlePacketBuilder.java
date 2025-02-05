package me.a8kj.smptest.parent.util;

import org.bukkit.Location;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class ParticlePacketBuilder {
    private EnumParticle particleType;
    private boolean longDistance;
    private float x, y, z;
    private float red, green, blue;
    private float speed;
    private int count;

    public ParticlePacketBuilder() {
        this.particleType = EnumParticle.REDSTONE;
        this.longDistance = true;
        this.x = 0.0F;
        this.y = 0.0F;
        this.z = 0.0F;
        this.red = 0.0F;
        this.green = 0.0F;
        this.blue = 1.0F;
        this.speed = 0.1F;
        this.count = 20;
    }

    public ParticlePacketBuilder setParticleType(EnumParticle particleType) {
        this.particleType = particleType;
        return this;
    }

    public ParticlePacketBuilder setLocation(Location location) {
        this.x = (float) location.getX();
        this.y = (float) location.getY();
        this.z = (float) location.getZ();
        return this;
    }

    public ParticlePacketBuilder setColor(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        return this;
    }

    public ParticlePacketBuilder setSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    public ParticlePacketBuilder setCount(int count) {
        this.count = count;
        return this;
    }

    public ParticlePacketBuilder setLongDistance(boolean longDistance) {
        this.longDistance = longDistance;
        return this;
    }

    public PacketPlayOutWorldParticles build() {
        return new PacketPlayOutWorldParticles(
                this.particleType,
                this.longDistance,
                this.x, this.y, this.z,
                this.red, this.green, this.blue,
                this.speed,
                this.count);
    }
}
