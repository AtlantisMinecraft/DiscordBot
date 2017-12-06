package net.atlantis.discordbot.api

import net.atlantis.discordbot.Constants
import net.atlantis.discordbot.DiscordBot
import org.bukkit.entity.Player

class Messenger(private val service: DiscordService) {
    fun send(player: Player, message: String, plugin: DiscordBot) {
        val name = player.name
        val image = "https://www.minecraftskinstealer.com/face.php?u=${player.name}"
        val id = plugin.config.getString(Constants.WEBHOOK_ID)
        val token = plugin.config.getString(Constants.WEBHOOK_TOKEN)

        service.send(id, token, message, name, image).subscribe()
    }
}