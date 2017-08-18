package com.github.vendigo.acebar

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Pixmap.Format.RGBA4444
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image


class MainScreen : ScreenAdapter() {
    private lateinit var texture: Texture
    private lateinit var pixmap: Pixmap
    private lateinit var stage: Stage
    private val width = 200f
    private val height = 400f
    private val wallWidth = 10
    private val waterHeight = (height / 3).toInt()

    override fun show() {
        pixmap = Pixmap(width.toInt(), height.toInt(), RGBA4444)

        with(pixmap) {
            setColor(Color.BLACK)
            fillRectangle(0, 0, wallWidth, height)
            fillRectangle(width - wallWidth, 0, wallWidth, height)
            fillRectangle(0, height - wallWidth, width, wallWidth)
            setColor(Color.BLUE)
            fillRectangle(wallWidth, height - waterHeight - wallWidth, width - 2 * wallWidth, waterHeight)
        }
        texture = Texture(pixmap)
        val image = Image(texture)
        image.x = 20f
        image.y = 20f

        stage = Stage()
        Gdx.input.inputProcessor = stage
        stage.addActor(image)

        image.addListener { event ->
            if (event is InputEvent && event.type == InputEvent.Type.touchDown) {
                println("Clicked on First glass")
            }
           true
        }
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(Color.LIGHT_GRAY)
        stage.act(delta)
        stage.draw()
    }

    override fun dispose() {
        texture.dispose()
        pixmap.dispose()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, false)
    }
}