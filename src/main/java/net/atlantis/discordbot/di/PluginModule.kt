package net.atlantis.discordbot.di

import dagger.Module
import dagger.Provides
import net.atlantis.discordbot.Constants
import net.atlantis.discordbot.api.DiscordService
import net.atlantis.discordbot.api.Messenger
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class PluginModule {

    @Provides
    fun provideRetrofit() = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    fun provideDiscordService(retrofit: Retrofit) = retrofit.create(DiscordService::class.java)

    @Provides
    fun provideMessenger(discordService: DiscordService) = Messenger(discordService)
}