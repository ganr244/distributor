package ru.otus.otuskotlin.distributor.m1l2.basic

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
        assertType<Int>(3.0)
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
}