package com.github.vendigo.acebar.entity

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Color.BLUE
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable

class Glass(val id: String, val capacity: Int, var amount: Int) : Image() {
    private val wallWidth = 10
    val freeSpace get() = capacity - amount

    init {
        if (capacity > 10) {
            throw IllegalArgumentException("Capacity cannot be greater than 10")
        }

        width = 60f * Math.sqrt(capacity.toDouble()).toFloat()
        height = width * 2f
        updateDrawable()

        addListener { event ->
            if (event is InputEvent && event.type == InputEvent.Type.touchDown) {
                Bartender.take(this)
            }
            true
        }
    }

    fun updateAmount(newAmount: Int) {
        if (amount > capacity) {
            throw IllegalArgumentException("Amount cannot be greater than capacity")
        }
        amount = newAmount
        updateDrawable()
    }

    private fun updateDrawable() {
        val liquidHeight = (height * amount / capacity).toInt()

        val pixmap = Pixmap(width.toInt(), height.toInt(), Pixmap.Format.RGBA4444)
        with(pixmap) {
            setColor(Color.BLACK)
            fillRectangle(0, 0, wallWidth, height)
            fillRectangle(width - wallWidth, 0, wallWidth, height)
            fillRectangle(0, height - wallWidth, width, wallWidth)
            setColor(BLUE)
            fillRectangle(wallWidth, height - liquidHeight - wallWidth, width - 2 * wallWidth, liquidHeight)
        }
        drawable = SpriteDrawable(Sprite(Texture(pixmap)))
    }
}