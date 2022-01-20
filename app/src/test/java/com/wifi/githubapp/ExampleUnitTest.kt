package com.wifi.githubapp

import org.junit.Test

class ExampleUnitTest {
    class InfoProp : AbsProperties("info.properties") {
        var name: String by prop
        var age: Int by prop
        var email: String by prop
        var student: Boolean by prop
        var point: Float by prop
//        name=张杰
//        age=32
//        email=3185017028@qq.com
//        student=false
//        point=4.9
    }

    @Test
    fun testProperties() {
        InfoProp().let {
            println(it.name)
            //println(it.age)
            println(it.email)
            println(it.student)

            it.name = "许嵩"
            it.name = "50"

            println("修改后=========")
            println(it.name)
            //println(it.age)
        }
    }

    @Test
    fun test() {

    }
}