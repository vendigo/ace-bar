package com.github.vendigo.acebar.table

import com.github.vendigo.acebar.glass.Glass

class Table(val glasses: List<Glass>) {
    private val startX = 20f
    private val y = 20f
    private val margin = 20f

    constructor(vararg glasses: Glass) : this(glasses.asList())

    init {
        validateFields()
        var currentPosX = startX

        glasses.forEach {
            it.x = currentPosX
            it.y = y
            currentPosX += it.width + margin
        }
    }

    private fun validateFields() {
        if (glasses.size > 5) {
            throw IllegalArgumentException("Table cannot contain more than 5 glasses")
        }
    }
}