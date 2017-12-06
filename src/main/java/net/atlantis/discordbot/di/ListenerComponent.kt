package net.atlantis.discordbot.di

import dagger.Subcomponent
import net.atlantis.discordbot.listener.DiscordListener
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ListenerModule::class])
interface ListenerComponent {
    fun inject(listener: DiscordListener)
}