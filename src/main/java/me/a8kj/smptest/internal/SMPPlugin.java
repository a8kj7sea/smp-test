package me.a8kj.smptest.internal;

import org.bukkit.plugin.java.JavaPlugin;

public class SMPPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        new PlayerJoinListener(this).register();
    }

}
