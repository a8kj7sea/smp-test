package me.a8kj.smptest.parent.packet.impl;

import org.bukkit.entity.Player;

import me.a8kj.smptest.parent.effect.ParticleEffect;
import me.a8kj.smptest.parent.packet.Packet;

public interface ParticleEffectPacket extends Packet, ParticleEffect {

    public void spawn(Player player);

}
