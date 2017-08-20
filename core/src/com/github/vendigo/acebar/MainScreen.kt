package com.github.vendigo.acebar

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Stage
import com.github.vendigo.acebar.glass.Glass
import com.github.vendigo.acebar.table.Table


class MainScreen : ScreenAdapter() {
    private lateinit var stage: Stage

    override fun show() {
        stage = Stage()
        Gdx.input.inputProcessor = stage

        val table = Table(
                Glass("Glass1", 5, 4),
                Glass("Glass2", 3, 0)
        )

        stage.addActors(table.glasses)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(Color.LIGHT_GRAY)
        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, false)
    }
}