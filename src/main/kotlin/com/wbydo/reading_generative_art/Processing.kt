/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.wbydo.reading_generative_art

import processing.core.*

class Processing : PApplet () {
    override fun settings() : Unit {
        size(800, 600)
        smooth()
    }
    override fun setup() : Unit {
        background(255f)
        strokeWeight(1f)

        val maxR = 280f
        val x0 = (width / 2).toFloat()
        val y0 = (height / 2).toFloat()

        val maxRound = 20 // 周回数
        val dTheta = 5
        var dr = maxR / (maxRound * (360 / dTheta))

        stroke(20f, 50f, 70f)
        noFill()

        var prevX = x0
        var prevY = y0
        var prevR = 0f
        for (theta in 0..(360 * maxRound) step dTheta) {
            val rad = radians(theta.toFloat())
            val x = x0 + prevR * cos(rad)
            val y = y0 + prevR * sin(rad)
            line(prevX, prevY, x, y)

            prevR = prevR + dr
            prevX = x
            prevY = y
        }
    }

    override fun draw() : Unit {
    }

    fun run(args: Array<String>) : Unit
            = PApplet.main("com.wbydo.reading_generative_art.Processing")
}

fun main(args : Array<String>) : Unit = Processing().run(args)
