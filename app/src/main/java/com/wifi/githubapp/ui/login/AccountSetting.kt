package com.wifi.githubapp.ui.login;

import com.wifi.githubapp.AppContext
import com.wifi.githubapp.ui.kotlin.Preferences

object AccountSetting {
    var email: String by Preferences<String>(AppContext,"email","","LoginSpFile")
    var password: String by Preferences<String>(AppContext,"password","","LoginSpFile")
}
