package com.github.vendigo.acebar.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.github.vendigo.acebar.AceBarGame

fun main(arg: Array<String>) {
    LwjglApplication(AceBarGame(), LwjglApplicationConfiguration())
}
