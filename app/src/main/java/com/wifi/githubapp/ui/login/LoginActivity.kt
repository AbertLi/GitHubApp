package com.wifi.githubapp.ui.login

import android.os.Bundle
import com.wifi.githubapp.R
import com.wifi.mvp.impl.BaseActivity
import timber.log.Timber

class LoginActivity : BaseActivity<LoginPresenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    override fun onConfigurationChange(newState: Bundle) {
        Timber.e("newState = ${newState.toString()}")
    }
}