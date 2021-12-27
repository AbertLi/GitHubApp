package com.wifi.mvp

import android.os.Bundle

interface ILifecycle {
    fun onCreate(saveInstanceState: Bundle?)
    fun onSaveInstanceState(outState: Bundle)
    fun onViewStateRestored(saveInstanceState: Bundle?)
    fun onConfigurationChange(newState: Bundle)
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}