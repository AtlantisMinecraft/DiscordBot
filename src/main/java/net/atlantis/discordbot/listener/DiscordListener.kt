package net.atlantis.discordbot.listener

import net.atlantis.discordbot.DiscordBot
import net.atlantis.discordbot.api.SendContent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent


class DiscordListener(private val plugin: DiscordBot) : Listener {

    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val message = "サーバーにログインしました"
        SendContent(event.player, message).send(plugin)
    }

    @EventHandler
    fun executeCommand(event: PlayerCommandPreprocessEvent) {
        val message = "${event.message} コマンドを実行しました"
        SendContent(event.player, message).send(plugin)
    }

    @EventHandler
    fun talkPlayer(event: AsyncPlayerChatEvent) {
        val message = "「${event.message}」"
        SendContent(event.player, message).send(plugin)
    }

    @EventHandler
    fun logoutPlayer(event: PlayerQuitEvent) {
        val message = "ログアウトしました"
        SendContent(event.player, message).send(plugin)
    }
}