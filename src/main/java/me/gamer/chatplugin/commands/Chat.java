package me.gamer.chatplugin.commands;

import me.gamer.chatplugin.ChatPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Chat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("chatplugin.*")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have permission!"));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lCommands:"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a/chat &freload"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a/chat &ftoggle"));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloading the config."));
            ChatPlugin.getInstance().reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aConfig has been reloaded!"));
            return true;
        }

        if (args[0].equalsIgnoreCase("toggle")) {

            if (ChatPlugin.getInstance().getConfig().getBoolean("enabled")) {
                ChatPlugin.getInstance().getConfig().set("enabled", false);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThe chat plugin has been disabled!"));
                return true;
            }

            ChatPlugin.getInstance().getConfig().set("enabled", true);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThe chat plugin has been enabled!"));

            return true;

        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis is not an available command."));

        return false;
    }
}
