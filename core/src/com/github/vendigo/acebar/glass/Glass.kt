package com.github.vendigo.acebar.glass

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import com.github.vendigo.acebar.draw

class Glass(val id: Int, val capacity: Int, var amount: Int) : Drawable {
    private var leftWidth = 0f
    private var rightWidth = 0f
    private var topHeight = 0f
    private var bottomHeight = 0f
    private var minWidth = 0f
    private var minHeight = 0f

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

    override fun draw(batch: Batch, x: Float, y: Float, width: Float, height: Float) {

    }

    override fun getLeftWidth(): Float {
        return leftWidth
    }

    override fun setLeftWidth(leftWidth: Float) {
        this.leftWidth = leftWidth
    }

    override fun getRightWidth(): Float {
        return rightWidth
    }

    override fun setRightWidth(rightWidth: Float) {
        this.rightWidth = rightWidth
    }

    override fun getTopHeight(): Float {
        return topHeight
    }

    override fun setTopHeight(topHeight: Float) {
        this.topHeight = topHeight
    }

    override fun getBottomHeight(): Float {
        return bottomHeight
    }

    override fun setBottomHeight(bottomHeight: Float) {
        this.bottomHeight = bottomHeight
    }

    override fun getMinWidth(): Float {
        return minWidth
    }

    override fun setMinWidth(minWidth: Float) {
        this.minWidth = minWidth
    }

    override fun getMinHeight(): Float {
        return minHeight
    }

    override fun setMinHeight(minHeight: Float) {
        this.minHeight = minHeight
    }
}