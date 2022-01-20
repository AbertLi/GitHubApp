package com.wifi.githubapp

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import timber.log.Timber

private lateinit var INSTANCE: Context

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            //Timber.plant(new CrashReportingTree())
        }
    }
}

object AppContext : ContextWrapper(INSTANCE)