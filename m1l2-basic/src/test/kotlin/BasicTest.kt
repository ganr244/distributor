package ru.otus.otuskotlin.distributor.m1l2.basic

import kotlin.reflect.KClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BasicTest {
    @Test // "testAs as? String" not equals "testAs as String?"
    fun testAsIntString(){

        val testAs: Int? = 1
        assertEquals(
            expected = testAs as? String,
            actual = null
        )

        /* ERROR class java.lang.Integer cannot be cast to class java.lang.String
        assertEquals(
            expected = testAs as String?,
            actual = null
        )
        */
    }

    @Test // class java.lang.Double != class java.lang.Integer
    fun testAssertType() {
        assertType<Int>(3)

        /* ERROR class java.lang.Double != class java.lang.Integer
        assertType<Int>(3.0)
        */
    }

    private inline fun <reified T> assertType(v: Any) {

        // lambda
        assertTrue(
            message = "${v::class.java} != ${T::class.java}"
        ){
            v::class.java == T::class.java
        }

        // boolean
        /*
        assertTrue(
            actual = v::class.java == T::class.java,
            message = "${v::class.java} != ${T::class.java}"
        )
        */
    }

    @Test
    fun testOperator(){

        println(ComplexNumber(x = 1, y = 1) + ComplexNumber(x = 2, y = 2))

    }

    private data class ComplexNumber(
        val x: Int,
        val y: Int,
    )
    {
        override fun toString(): String =
            "(x = ${this.x}, y = ${this.y})"
        operator fun plus(other: ComplexNumber):ComplexNumber =
            ComplexNumber(
                x = this.x + other.x,
                y = this.y + other.y
            )
    }

    @Test
    fun testKCLass() {

        isKClass<String>(String::class)
    }

    private fun <T : Any> isKClass(v: KClass<T>) {
        println("isKClass = ${v.simpleName}")
    }

    @Test // ERROR java.lang.Exception: My test Nothing
    fun testNothing (){
        //myTestNothing()
    }

    private fun myTestNothing(): Nothing = throw Exception("My test Nothing")
}