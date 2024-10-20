package pl.stellarcode.test;

import org.bukkit.plugin.java.JavaPlugin;
import pl.stellarcode.test.commands.reload;
import pl.stellarcode.test.event.loghandler;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        loghandler.setplugin(this);
        reload.setplugin(this);
        saveDefaultConfig();
        loghandler.getwiadomosc();
        getServer().getPluginManager().registerEvents(new loghandler(), this);
        getCommand("join").setExecutor(new reload());
        getLogger().info("plugin wlaczony");

    }

    @Override
    public void onDisable() {
        getLogger().info("plugin wylaczony");
    }

}
