package net.atlantis.discordbot

import net.atlantis.discordbot.di.DaggerPluginComponent
import net.atlantis.discordbot.di.PluginComponent
import net.atlantis.discordbot.listener.DiscordListener
import org.bukkit.plugin.java.JavaPlugin

class DiscordBot : JavaPlugin() {
    lateinit var component: PluginComponent

    override fun onEnable() {
        component = DaggerPluginComponent.builder().application(this).build()
        DiscordListener(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
