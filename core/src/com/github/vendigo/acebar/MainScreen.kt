package com.github.vendigo.acebar

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.github.vendigo.acebar.glass.Glass
import com.github.vendigo.acebar.table.Table


class MainScreen : ScreenAdapter() {
    private lateinit var table: Table

    override fun show() {
        table = Table(listOf(
                Glass(id = 1, capacity =  3, amount =  1),
                Glass(id = 2, capacity =  5, amount =  3)
        ))
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(Color.BLACK)
        table.render()
    }
}