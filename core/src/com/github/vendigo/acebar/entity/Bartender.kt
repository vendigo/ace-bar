package com.github.vendigo.acebar.entity

object Bartender {
    private var firstGlass: Glass? = null

    fun take(glass: Glass) {
        if (firstGlass == null || firstGlass == glass) {
            firstGlass = glass
        } else {
            pour(firstGlass!!, glass)
            firstGlass = null
        }
    }

    private fun pour(from: Glass, to: Glass) {
        if (from.amount <= to.freeSpace) {
            to.updateAmount(to.amount + from.amount)
            from.updateAmount(0)
        } else {
            from.updateAmount(from.amount - to.freeSpace)
            to.updateAmount(to.capacity)
        }
    }
}
