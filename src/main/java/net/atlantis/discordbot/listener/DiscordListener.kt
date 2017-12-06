package net.atlantis.discordbot.listener

import net.atlantis.discordbot.DiscordBot
import net.atlantis.discordbot.api.Messenger
import net.atlantis.discordbot.di.ListenerModule
import org.bukkit.event.EventHandler
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import javax.inject.Inject


class DiscordListener(override val plugin: DiscordBot) : BaseListener {

    @Inject lateinit var messenger: Messenger

    val component by lazy { plugin.component.plus(ListenerModule(this)) }

    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
        component.inject(this)
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val message = "サーバーにログインしました"
        messenger.send(event.player, message, plugin)
    }

    @EventHandler
    fun executeCommand(event: PlayerCommandPreprocessEvent) {
        val message = "${event.message} コマンドを実行しました"
        messenger.send(event.player, message, plugin)
    }

    @EventHandler
    fun talkPlayer(event: AsyncPlayerChatEvent) {
        val message = "「${event.message}」"
        messenger.send(event.player, message, plugin)
    }

    @EventHandler
    fun logoutPlayer(event: PlayerQuitEvent) {
        val message = "ログアウトしました"
        messenger.send(event.player, message, plugin)
    }
}