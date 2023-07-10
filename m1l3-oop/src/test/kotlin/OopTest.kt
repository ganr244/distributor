package ru.otus.otuskotlin.distributor.m1l3.oop

import kotlin.test.Test
import ru.otus.otuskotlin.distributor.m1l3.oop.FirstInterface as FirstInterface

private interface FirstInterface {
    val sv1: String
    val sv2: String

    fun voice1() {
        println("sv1 = $sv1")
    }

    fun voice2() {
        println("sv2 = $sv2")
    }
}

private data class FirstClass(override val sv1: String = "1", override val sv2: String = "2"): FirstInterface

private abstract class FirstAbstract(){
    val sv1: String = ""
    val sv2: String = ""
}

private class FirstChildren: FirstAbstract()

class OopTest {
    @Test
    fun test(){
        FirstClass().voice1()
        FirstClass().voice2()
    }
}