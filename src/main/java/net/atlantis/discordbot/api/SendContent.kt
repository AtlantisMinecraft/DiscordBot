package net.atlantis.discordbot.api

import net.atlantis.discordbot.DiscordBot
import net.atlantis.discordbot.model.Result
import org.bukkit.entity.Player
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SendContent(private val player: Player, private val message: String) {

    fun send(plugin: DiscordBot) {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://discordapp.com/api/webhooks/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(DiscordService::class.java)
        val name = player.name
        val image = "https://www.minecraftskinstealer.com/face.php?u=${player.name}"
        val id = plugin.config.getString("discord_webhook_id")
        val token = plugin.config.getString("discord_webhook_token")

        service.send(id, token, message, name, image).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (!response.isSuccessful) {
                    return
                }
                try {
                    val result = response.body()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(call: Call<Result>, t: Throwable) {

            }
        })
    }
}