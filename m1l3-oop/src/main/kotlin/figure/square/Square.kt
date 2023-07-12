package ru.otus.otuskotlin.distributor.m1l3.oop.figure.square

import ru.otus.otuskotlin.distributor.m1l3.oop.figure.Figure

class Square(val width: Int): Figure {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Square

        return width == other.width
    }

    override fun hashCode(): Int = area()
    override fun toString(): String = "Square(${width}x${width})"
    override fun area(): Int = width * width

}