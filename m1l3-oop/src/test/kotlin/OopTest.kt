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

private interface SecondInterface: FirstInterface {

}

private data class FirstClass(override val sv1: String = "1", override val sv2: String = "2"): SecondInterface

private abstract class FirstAbstract() {
    val sv1: String = ""
    val sv2: String = ""

    // it can't interface
    override fun toString(): String {
        return super.toString()
    }

    // it can't interface
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    // it can't interface
    override fun hashCode(): Int {
        return super.hashCode()
    }
}

private class FirstChildren: FirstAbstract()

class OopTest {
    @Test
    fun test(){
        FirstClass().voice1()
        FirstClass().voice2()
    }
}