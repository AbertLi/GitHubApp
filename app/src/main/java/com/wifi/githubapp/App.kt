package com.wifi.githubapp

import android.app.Application
import android.content.Context
import android.content.ContextWrapper

private lateinit var INSTANCE: Context

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

object AppContext : ContextWrapper(INSTANCE)