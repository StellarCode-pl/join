package pl.stellarcode.test.event;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.stellarcode.test.main;


public class loghandler implements Listener {

    private static main plugin;

    static String joinmessage;
    static String quitmessage;

    public static void getwiadomosc() {
        FileConfiguration config = plugin.getConfig();
        joinmessage = config.getString("joinmessage");
        quitmessage = config.getString("quitmessage");
    }

    private String replacemsg(String msgtoreplace, Player p) {
        return msgtoreplace.replace("{player}", p.getDisplayName());
    }

    public static void setplugin(main plugin) {
        loghandler.plugin = plugin;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String wiadomosc = replacemsg(joinmessage, player);
        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', wiadomosc));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String wiadomosc = replacemsg(quitmessage, player);
        event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', wiadomosc));
    }

}
