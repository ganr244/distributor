package ru.otus.otuskotlin.distributor.m1l3.oop.figure

interface Figure{
    fun area(): Int
}

fun diffArea(figure1: Figure, figure2: Figure): Int = figure1.area() - figure2.area()