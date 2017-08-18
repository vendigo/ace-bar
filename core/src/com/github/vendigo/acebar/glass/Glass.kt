package com.github.vendigo.acebar.glass

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.github.vendigo.acebar.draw

class Glass(val id: Int, val capacity: Int, var amount: Int) {
    var x: Float = 0f
    var y: Float = 0f
    val wallThickness = 4f
    val width = 60f * Math.sqrt(capacity.toDouble()).toFloat()
    val height = width * 2f
    val shape = ShapeRenderer()

    fun render() {
        val liquidHeight = height * amount / capacity

        shape.draw(ShapeRenderer.ShapeType.Filled) {
            color = Color.BLUE
            rect(x, y, width, liquidHeight)
            color = Color.WHITE
            rectLine(x, y, x, y + height, wallThickness)
            rectLine(x, y, x + width, y, wallThickness)
            rectLine(x + width, y, x + width, y + height, wallThickness)
        }
    }
}