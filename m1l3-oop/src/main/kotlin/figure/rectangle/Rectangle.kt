package ru.otus.otuskotlin.distributor.m1l3.oop.figure.rectangle

import ru.otus.otuskotlin.distributor.m1l3.oop.figure.Figure

class Rectangle(val width: Int, val height: Int): Figure {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (width != other.width) return false
        return height == other.height
    }

    override fun hashCode(): Int = area()
    override fun toString(): String = "Rectangle(${width}x${height})"
    override fun area(): Int = width * height

}