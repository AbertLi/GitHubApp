package com.wifi.githubapp.ui.kotlin

import android.content.Context
import com.wifi.githubapp.AppContext
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/*
（1）
1, BoolenExt<out T> 为什么是Out。
2, sealed 这个关键字在什么时候可以使用。   当可以使用枚举但是又是有可变的枚举中的value的时候就可以使用这个关键字修饰类了。
3，Kotlin或者java可以同时实现一个接口和一个抽象类。里面的抽象方法名字是一样的。



 */

/**
 * 1，sealed ,inline 扩展方法，泛型学习
 */
sealed class BoolenExt<out T>
object Otherwise : BoolenExt<Nothing>()
class WithDate<T>(val data: T) : BoolenExt<T>()

inline fun <T> Boolean.yes(block: () -> T) = when {
    this -> {
        WithDate(block())
    }
    else -> {
        Otherwise
    }
}

inline fun <T> BoolenExt<T>.otherwise(block: () -> T) = when (this) {
    is Otherwise -> block()
    is WithDate -> this.data
}


fun test() {
    /**
     * 1，test
     */
    var random = (Math.random() * 10).toInt()
    var boo = random == 1

    println("random=$random")
    var result = boo.yes {
        1
    }.otherwise {
        2
    }
    print("result=$result")
}

/**
 * 2, SharedPreferences 扩展
 */

class Preferences<T>(
    val context: Context,
    val keyName: String,
    val default: T,
    val spName: String = "Default"
) : ReadWriteProperty<Any?, T> {
    private val sp by lazy {
        context.getSharedPreferences(spName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getValue(keyName)
    }

    private fun getValue(key: String): T {
        return when (default) {
            is Long -> sp.getLong(key, default)
            is Int -> sp.getInt(key, default)
            is Boolean -> sp.getBoolean(key, default)
            is Float -> sp.getFloat(key, default)
            is String -> sp.getString(key, default)
            else -> throw IllegalArgumentException("Unsupported type")
        } as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        setValue(keyName, value)
    }

    private fun setValue(key: String, t: T) {
        with(sp.edit()) {
            when (t) {
                is Long -> this.putLong(key, t)
                is Int -> this.putInt(key, t)
                is Boolean -> this.putBoolean(key, t)
                is Float -> this.putFloat(key, t)
                is String -> this.putString(key, t)
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }.apply()
    }

}

/**
 * 2，test
 */
//object AccountSetting {
//    var email: String by Preferences<String>(AppContext,"email","","LoginSpFile")
//    var password: String by Preferences<String>(AppContext,"password","","LoginSpFile")
//}

/**
 * 3, Properties扩展 kotlin反射。（实现属性代理。用到java反射。）
 */







fun main() {
}