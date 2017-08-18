package com.github.vendigo.acebar.table

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color.WHITE
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled
import com.github.vendigo.acebar.draw
import com.github.vendigo.acebar.glass.Glass

class Table(var glasses: List<Glass>) {
    val margin = 40f
    val x = 20f
    val y = 20f
    val width = Gdx.graphics.width - 2*x
    val height = 10f
    val shape = ShapeRenderer()

    fun render() {
        shape.draw(Filled) {
            color = WHITE
            rect(x, y, width, height)
        }
        placeGlasses()
        glasses.forEach(Glass::render)
    }

    private fun placeGlasses() {
        var currentPosX = x + margin

        glasses.forEach {
            it.x = currentPosX
            it.y = y + height
            currentPosX += it.width + margin
        }
    }
}