package com.github.nicomincuzzi.maze

import com.github.nicomincuzzi.domain.Utensil

data class Room(
        val id: Int = 3,
        val name: String = "Kitchen",
        var north: Int? = null,
        var south: Int? = null,
        var east: Int? = null,
        var west: Int? = null,
        val objects: List<Utensil> = listOf()
) {

    fun searchItemsMaze(findingItems: List<String>): List<String> {
        val foundItems: MutableList<String> = ArrayList()
        for (item in findingItems) {
            for (itemRoom in objects) {
                if (itemRoom.isSameThan(item!!)) {
                    foundItems.add(itemRoom.name)
                }
            }
        }
        if (foundItems.isEmpty()) foundItems.add("None")
        return foundItems
    }
}