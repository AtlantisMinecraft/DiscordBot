# DiscordBot

Minecraft 1.12.2

# 機能

## 以下の行動をDiscordへ通知します
* ログイン
* ログアウト
* コマンドの実行
* サーバー内の発言

# 導入

## DiscordでWebhookを作成
WebHookのURLをメモします

https://discordapp.com/api/webhooks/[WebHookのID]/[WebHookのtoken]

URLは上記のような構造になっています

## plugin配置

https://github.com/AtlantisMinecraft/DiscordBot/releases

上記からjarファイルをダウンロード

## config作成
pluginフォルダにDiscordBotフォルダを作成して以下のymlファイルを入れてください
メモしたWebHookのIDとtokenを入力します

config.yml
```yml
discord_webhook_id: "WebHookのID"
discord_webhook_token: "WebHookのtoken"
```

## 以上で導入は完了です
