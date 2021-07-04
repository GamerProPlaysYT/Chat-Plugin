package me.gamer.chatplugin;

import me.gamer.chatplugin.commands.Chat;
import me.gamer.chatplugin.listeners.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatPlugin extends JavaPlugin {

    private static ChatPlugin instance = null;

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        getCommand("chat").setExecutor(new Chat());

        getConfig().options().copyHeader(true);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        instance = null;

        getConfig().options().copyHeader(true);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    public static ChatPlugin getInstance() {
        return instance;
    }
}
