package ru.otus.otuskotlin.distributor.m1l3.oop.figure

import kotlin.math.absoluteValue

interface Figure{
    fun area(): Int
}

fun diffArea(figure1: Figure, figure2: Figure): Int = (figure2.area() - figure1.area()).absoluteValue