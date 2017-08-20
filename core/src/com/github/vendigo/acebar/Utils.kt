package com.github.vendigo.acebar

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage

fun Stage.addActors(actors: List<Actor>) = actors.forEach { addActor(it) }

fun SpriteBatch.draw(block: SpriteBatch.() -> Unit) {
    begin()
    block()
    end()
}

fun ShapeRenderer.draw(shapeType: ShapeRenderer.ShapeType, block: ShapeRenderer.() -> Unit) {
    begin(shapeType)
    block()
    end()
}

fun GL20.glClearColor(color: Color) {
    glClearColor(color.r, color.g, color.b, color.a)
    glClear(GL20.GL_COLOR_BUFFER_BIT)
}


