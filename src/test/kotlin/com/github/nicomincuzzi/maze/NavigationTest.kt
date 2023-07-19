package com.github.nicomincuzzi.maze

import com.github.nicomincuzzi.domain.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NavigationTest {

    @Test
    fun oneItemsIsFoundWithSuccess() {
        val findingItems = Utensils(listOf(Utensil("Knife")))
        val room = Room(0, "ignore", null, null, null, null, Utensils(listOf(Utensil("Knife"))))

        val result = Navigation(findingItems, MazeMap(Rooms(room))).searchItemsMaze(room)

        val expectedGameResult = result.entries.iterator().next().value
        assertTrue(expectedGameResult.items.utensils[0].name == "Knife")
    }

    @Test
    fun noItemsIsFound() {
        val room = Room(0, "ignore", null, null, null, null, Utensils(listOf(Utensil("Knife"))))

        val result = Navigation(Utensils(emptyList()), MazeMap(Rooms(room))).searchItemsMaze(room)

        val expectedGameResult = result.entries.iterator().next().value
        assertTrue(expectedGameResult.items.utensils.isEmpty())
    }
}