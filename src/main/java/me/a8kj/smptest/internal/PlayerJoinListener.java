package me.a8kj.smptest.internal;

import lombok.RequiredArgsConstructor;
import me.a8kj.smptest.parent.effect.atrributes.Count;
import me.a8kj.smptest.parent.effect.atrributes.RGBColor;
import me.a8kj.smptest.parent.effect.atrributes.Speed;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Random;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final JavaPlugin plugin;
    private final HashMap<Player, Integer> playerColors = new HashMap<>();
    private final Random random = new Random();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        int assignedNumber = random.nextInt(8) + 1;
        playerColors.put(player, assignedNumber);

        RGBColor color = ColorCode.getColorByCode(assignedNumber);

        SpiralParticleEffect effect = new SpiralParticleEffect(
                plugin,
                new Count(0),
                color,
                new Speed(0), // btw this particle effect doesn't have speed (not implemented) you do it if u
                              // want
                0.7,
                2.6,
                0.05,
                Math.PI / 16);
        effect.spawn(player);

    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
}
