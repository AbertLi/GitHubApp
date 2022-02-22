package com.wifi.githubapp.reflect

import kotlin.jvm.internal.MutablePropertyReference1
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

fun main() {
    /**
     * 读取Kotlin中的成员属性，包括private修饰的。s
     */
//    val book = Book().apply { name = "倚天屠龙记" }
//    val c  = Book::class
//    c.memberProperties.forEach {
//        println(it.name)
//        println(it.returnType)
//        if ("name" == it.name){
//            println("======"+it.get(book))
//        }
//        if ("totalPage" == it.name){
//            it.isAccessible = true//去掉private的限制。
//            println("======"+it.get(book))
//        }
//    }


    /**
     * 给Kotlin赋值中的属性，包括private修饰的。
     */
//    val book = Book().apply { name = "倚天屠龙记" }
//    val c  = Book::class
//    c.memberProperties.forEach {kProperty->
//        println(kProperty.name)
//        println(kProperty.returnType)
//        if ("name" == kProperty.name){
//            println("======"+kProperty.get(book))
//        }
//        if ("totalPage" == kProperty.name){
//            kProperty.isAccessible = true//去掉private的限制。
//            (kProperty as? KMutableProperty1<Book,Int>)?.let {KMutableProperty1->
//                KMutableProperty1.set(book,121121)//如果这个属性是val修饰就不能修改。var修饰的private属性可以修改。
//            }
//        }
//    }
//    println("update result = $book")

    /**
     * 成员方法调用
     */
//    val book = Book().apply { name = "倚天屠龙记" }
//    val c = Book::class
//    c.memberFunctions.forEach { function ->
//        //println(function.name)
//        if (function.name == "test") {
//            function.call(book)
//        }
//
//        if (function.name == "test1") {
//            function.call(book, 121)
//        }
//        function.parameters.forEach { para ->//获取方法中的形式参数
//            println("name = ${para.name} para = ${para.type}")
//        }
//    }


    /**
     * 构造方法
     */
//    val book = Book().apply { name = "倚天屠龙记" }
//    val c = Book::class
//    c.constructors.forEach {kFunktion->
//        println(kFunktion)
//        if (kFunktion.parameters.isEmpty()){
//            val book1 = kFunktion.call()
//            println("book1 init = $book1")
//        }else{
//            val book2 = kFunktion.call(12345678)
//            println("book1 init = $book2")
//        }
//    }
//    c.primaryConstructor//主的构造方法

    /**
     * 使用反射实现序列化和反序列化
     * */
    val book = Book().apply { name = "倚天屠龙记" }
    val c = Book::class
    val strBui = buildString {
        c.memberProperties.forEach { kProperty ->
            kProperty.isAccessible = true
            if (!isEmpty()) append(";")
            append(kProperty.name)
            append("=")
            append(kProperty.get(book))
        }
    }
    println(strBui.toString())

    val text = "name=倚天屠龙记;totalPage=1000"
    val myBook = Book()
    text.split(";").forEach { kv ->
        val temp = kv.split("=")
        val key = temp[0]
        val value = temp[1]
        c.memberProperties.forEach { property ->
            if (property.name == key) {
                (property as? KMutableProperty1<Book, Any?>)?.let { kmProperty ->
                    kmProperty.set(myBook, value)
                }
            }
        }
    }
    println(myBook)

}