package com.github.nicomincuzzi.maze

import com.github.nicomincuzzi.domain.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NavigationTest {

    @Test
    fun oneItemsIsFoundWithSuccess() {
        val findingItems = Utensils(Utensil("Knife"))
        val room = Room(objects = listOf(Utensil("Knife")))

        val result = Navigation(findingItems, MazeMap(Rooms(room))).searchItemsMaze(room)

        val expectedGameResult = result.entries.iterator().next().value
        assertTrue(expectedGameResult.items.contains("Knife"))
    }

    @Test
    fun noItemsIsFound() {
        val room = Room(objects = listOf(Utensil("Knife")))

        val result = Navigation(Utensils(), MazeMap(Rooms(room))).searchItemsMaze(room)

        val expectedGameResult = result.entries.iterator().next().value
        assertTrue(expectedGameResult.items.isEmpty())
    }
}