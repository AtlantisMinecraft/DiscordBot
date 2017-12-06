package net.atlantis.discordbot.di

import dagger.BindsInstance
import dagger.Component
import net.atlantis.discordbot.DiscordBot
import org.bukkit.plugin.java.JavaPlugin

@Component(modules = [PluginModule::class])
interface PluginComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: JavaPlugin): Builder

        fun build(): PluginComponent
    }

    fun plus(listenerModule: ListenerModule): ListenerComponent

    fun inject(plugin: DiscordBot)
}