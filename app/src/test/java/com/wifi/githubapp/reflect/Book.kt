package com.wifi.githubapp.reflect

class Book() {
    var name: String = "孙子兵法"
    private var totalPage: Int = 1000

    constructor(page: Int) : this() {
        totalPage = page
    }

    fun test() {
        println("test test ")
    }

    fun test1(price: Int) {
        println("test test Price = $price")
    }

    override fun toString(): String {
        return "Book(name='$name', totalPage=$totalPage)"
    }
}