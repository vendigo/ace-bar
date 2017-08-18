package com.github.vendigo.acebar

import com.badlogic.gdx.Game

val WORLD_WIDTH = 640f
val WORLD_HEIGHT = 480f

class AceBarGame : Game() {

    override fun create() {
        setScreen(MainScreen())
    }
}
