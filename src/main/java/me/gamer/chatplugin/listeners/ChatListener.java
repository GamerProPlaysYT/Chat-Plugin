package me.gamer.chatplugin.listeners;

import me.gamer.chatplugin.ChatPlugin;
import me.gamer.chatplugin.manager.ChatManager;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final ChatManager chatManager = new ChatManager();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Chat chat = chatManager.getChat();
        Player p = e.getPlayer();
        String prefix = chat.getPlayerPrefix(p) == null ? chat.getGroupPrefix(p.getWorld(), chat.getPrimaryGroup(p)) : chat.getPlayerPrefix(p);
        String suffix = chat.getPlayerSuffix(p) == null ? chat.getGroupPrefix(p.getWorld(), chat.getPrimaryGroup(p)) : chat.getPlayerSuffix(p);

        String format = ChatPlugin.getInstance().getConfig().getString("chat-format").replace("$player", p.getName()).replace("$message", e.getMessage())
                .replace("$prefix", prefix).replace("$displayName", prefix + p.getName() + suffix).replace("$suffix", suffix);

        if (ChatPlugin.getInstance().getConfig().getBoolean("enabled")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', format));
        }

    }

}
