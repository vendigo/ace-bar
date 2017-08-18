package com.github.vendigo.acebar

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.utils.viewport.FitViewport


class MainScreen : ScreenAdapter() {
    private lateinit var stage: Stage

    override fun show() {
        stage = Stage(FitViewport(WORLD_WIDTH, WORLD_HEIGHT))
        Gdx.input.inputProcessor = stage

        val textStyle = LabelStyle()
        textStyle.font = BitmapFont()

        val label = Label("Welcome to Ace Bar!", textStyle)

        label.addListener { event ->
            if (event is InputEvent && event.type == InputEvent.Type.touchDown) {
                println("Clicked!")
            }
            true
        }
        stage.addActor(label)
    }

    override fun render(delta: Float) {
        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height)
    }
}