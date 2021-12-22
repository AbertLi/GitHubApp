package com.wifi.githubapp

import java.io.File
import java.io.FileInputStream
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.net.URL
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class PropertiesDelegate(private val path: String) {
    private lateinit var url: URL
    private val properties: Properties by lazy {
        val prop = Properties()
        url = try {
            javaClass.getResourceAsStream(path).use {
                prop.load(it)
            }
            javaClass.getResource(path)
        } catch (e: Exception) {
            try {
                ClassLoader.getSystemClassLoader().getResourceAsStream(path).use {
                    prop.load(it)
                }
                ClassLoader.getSystemClassLoader().getResource(path)
            } catch (e2: Exception) {
                FileInputStream(path).use {
                    prop.load(it)
                }
                URL("file://${File(path).canonicalPath}")
            }
        }

        prop
    }

    operator fun <T> setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        properties[property.name] = value.toString()
        File(url.toURI()).outputStream().use {
            properties.store(it, "comments test ...")
        }
    }

    operator fun <T> getValue(thisRef: Any?, property: KProperty<*>): T {
        val value = properties[property.name]
        val classOft = property.returnType.classifier as KClass<*>
        return when {
            Boolean::class == classOft -> value.toString().toBoolean()
//            Number::class.isSuperclassOf(classOft) ->{//待完成
//
//            }
            Int::class == classOft -> value.toString().toInt()
            Float::class == classOft -> value.toString().toFloat()
            String::class == classOft -> value.toString()
            else -> throw IllegalArgumentException("Unsupported type.")
        } as T
    }

}


abstract class AbsProperties(path: String) {
    val prop = PropertiesDelegate(path)
}