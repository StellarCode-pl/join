package pl.stellarcode.test.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.stellarcode.test.event.loghandler;
import pl.stellarcode.test.main;

public class reload implements CommandExecutor {
    private static main plugin;
    public static void setplugin(main plugin) {
        reload.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("join")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GREEN + "Plugin stworzony przez Matisio (StellarCode)\nUzyj: /join reload");
                return true;

            } else {
                if (args[0].equalsIgnoreCase("reload")) {

                    if (sender.hasPermission("join.reload")) {
                        sender.sendMessage("Plugin przeladowano!");
                        plugin.reloadConfig();
                        loghandler.getwiadomosc();
                        return true;

                    } else {
                        sender.sendMessage(ChatColor.RED + "Nie masz permisji!");
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Plugin stworzony przez Matisio (StellarCode)\nUzyj: /join reload");
                    return true;
                }
            }


        }
        return false;
    }
}
