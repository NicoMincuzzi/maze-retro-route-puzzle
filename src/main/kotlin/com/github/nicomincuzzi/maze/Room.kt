package com.github.nicomincuzzi.maze

import com.github.nicomincuzzi.domain.Utensil
import com.github.nicomincuzzi.domain.Utensils

data class Room(
        val id: Int = 3,
        val name: String = "Kitchen",
        var north: Int? = null,
        var south: Int? = null,
        var east: Int? = null,
        var west: Int? = null,
        val objects: List<Utensil> = listOf()
) {

    fun searchItemsMaze(findingItems: Utensils): List<String> {
        return findingItems.matchedItems(objects)
    }
}