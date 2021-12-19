package com.wifi.githubapp

import com.wifi.githubapp.ui.kotlin.otherwise
import com.wifi.githubapp.ui.kotlin.yes
import org.junit.Test

import org.junit.Assert.*
import java.lang.Math.random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test() {
        /**
         * 1，
         */
        var random = (random() * 10).toInt()
        var boo = random == 1

        var result = boo.yes {
            1
        }.otherwise {
            2
        }
    }
}