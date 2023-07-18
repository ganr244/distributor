package ru.otus.otuskotlin.distributor.m1l4.dsl

import junit.framework.TestCase.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith

class SqlSelectBuilder{

    private lateinit var table: String
    private var columns: ArrayList<String>? = null

    fun select(vararg column: String){
        if (column.isEmpty()) {
            this.columns = null
        } else {
            this.columns = arrayListOf()
            column.forEach {
                columns?.add(it)
            }
        }
    }

    fun from(table: String) {
        this.table = table
    }

    fun build():String =
        "select ${
            (this.columns?: arrayListOf("*"))
                .joinToString(separator = ", ")
        } from $table"

}

fun query(block: SqlSelectBuilder.() -> Unit): SqlSelectBuilder {
    return SqlSelectBuilder().apply(block)
}

infix fun String.eq(value: Any?): String = when (value) {
    is String -> "$this = '$value'"
    is Number -> "$this  = $value"
    null ->  "$this is null"
    else -> throw Exception("Exception 0001")
}

// Реализуйте dsl для составления sql запроса, чтобы все тесты стали зелеными.
class SqlDslUnitTest {
    private fun checkSQL(expected: String, sql: SqlSelectBuilder) {
        assertEquals(expected, sql.build())
    }

    @Test
    fun `simple select all from table`() {
        val expected = "select * from table"

        val real = query {
            from("table")
        }

        checkSQL(expected, real)
    }

    @Test
    fun `check that select can't be used without table`() {
        assertFailsWith<Exception> {
            query {
                select("col_a")
            }.build()
        }
    }

    @Test
    fun `select certain columns from table`() {
        val expected = "select col_a, col_b from table"

        val real = query {
            select("col_a", "col_b")
            from("table")
        }

        checkSQL(expected, real)
    }

    @Test
    fun `select certain columns from table 1`() {
        val expected = "select col_a, col_b from table"

        val real = query {
            select("col_a", "col_b")
            from("table")
        }

        checkSQL(expected, real)
    }

    /**
     * __eq__ is "equals" function. Must be one of char:
     *  - for strings - "="
     *  - for numbers - "="
     *  - for null - "is"
     */
    @Test
    fun `select with complex where condition with one condition`() {
//        val expected = "select * from table where col_a = 'id'"
//
//        val real = query {
//            from("table")
//            where { "col_a" eq "id" }
//        }
//
//        checkSQL(expected, real)
    }

    /**
     * __nonEq__ is "non equals" function. Must be one of chars:
     *  - for strings - "!="
     *  - for numbers - "!="
     *  - for null - "!is"
     */
    @Test
    fun `select with complex where condition with two conditions`() {
//        val expected = "select * from table where col_a != 0"
//
//        val real = query {
//            from("table")
//            where {
//                "col_a" nonEq 0
//            }
//        }
//
//        checkSQL(expected, real)
    }

    @Test
    fun `when 'or' conditions are specified then they are respected`() {
//        val expected = "select * from table where (col_a = 4 or col_b !is null)"
//
//        val real = query {
//            from("table")
//            where {
//                or {
//                    "col_a" eq 4
//                    "col_b" nonEq null
//                }
//            }
//        }
//
//        checkSQL(expected, real)
    }
}
