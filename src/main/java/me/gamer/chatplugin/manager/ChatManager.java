package me.gamer.chatplugin.manager;

import me.gamer.chatplugin.ChatPlugin;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;

public class ChatManager {

    private final RegisteredServiceProvider<Chat> rsp = ChatPlugin.getInstance().getServer().getServicesManager().getRegistration(Chat.class);
    private final Chat chat = rsp.getProvider();

    public Chat getChat() {
        return chat;
    }
}
