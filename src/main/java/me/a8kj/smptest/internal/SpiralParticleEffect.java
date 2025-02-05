package me.a8kj.smptest.internal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.smptest.parent.effect.atrributes.Count;
import me.a8kj.smptest.parent.effect.atrributes.RGBColor;
import me.a8kj.smptest.parent.effect.atrributes.Speed;
import me.a8kj.smptest.parent.packet.impl.ParticleEffectPacket;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;

@RequiredArgsConstructor
@Getter
public class SpiralParticleEffect implements ParticleEffectPacket {

    private final JavaPlugin plugin;
    private final String name = "SpiralEffect";
    private final Count count;
    private final RGBColor color;
    private final Speed speed;

    private final double radius;
    private final double height;
    private final double yStep;
    private final double angleStep;

    @Override
    public void spawn(final Player player) {
        new BukkitRunnable() {
            double angle = 0;
            double y = 0;

            @Override
            public void run() {
                if (y >= height) {
                    this.cancel();
                    return;
                }

                Location center = player.getLocation().add(0, -0.2, 0); 
                double x = radius * Math.cos(angle);
                double z = radius * Math.sin(angle);
                Location particleLocation = center.clone().add(x, y, z);

                sendParticlePacket(player, particleLocation);

                angle += angleStep;
                y += yStep;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    private void sendParticlePacket(Player player, Location location) {
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
                EnumParticle.REDSTONE,
                true,
                (float) location.getX(),
                (float) location.getY(),
                (float) location.getZ(),
                (float) (color.getRed() / 255.0),
                (float) (color.getGreen() / 255.0),
                (float) (color.getBlue() / 255.0),
                1.0f, 
                count.getValue()
        );
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
