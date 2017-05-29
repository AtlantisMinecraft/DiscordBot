package net.atlantis.discordbot

import net.atlantis.discordbot.listener.DiscordListener
import org.bukkit.plugin.java.JavaPlugin

class DiscordBot : JavaPlugin() {

    override fun onEnable() {
        DiscordListener(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
