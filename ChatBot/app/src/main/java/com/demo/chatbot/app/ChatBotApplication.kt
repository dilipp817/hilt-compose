package com.demo.chatbot.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ChatBotApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}