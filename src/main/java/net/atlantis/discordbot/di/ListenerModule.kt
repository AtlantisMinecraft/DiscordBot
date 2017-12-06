package net.atlantis.discordbot.di

import dagger.Module
import net.atlantis.discordbot.listener.BaseListener

@Module
class ListenerModule(val listener: BaseListener) {

}