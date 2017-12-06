package net.atlantis.discordbot.listener

import net.atlantis.discordbot.DiscordBot
import org.bukkit.event.Listener

interface BaseListener : Listener {
    val plugin: DiscordBot
}