package com.github.nicomincuzzi.maze

import com.github.nicomincuzzi.domain.MazeMap
import com.github.nicomincuzzi.domain.Navigation
import com.github.nicomincuzzi.domain.Rooms
import com.github.nicomincuzzi.domain.Utensil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NavigationTest {

    @Test
    fun oneItemsIsFoundWithSuccess() {
        val findingItems = listOf("Knife")
        val room = Room(objects = listOf(Utensil("Knife")))

        val result = Navigation(findingItems, MazeMap(Rooms(room))).searchItemsMaze(room)

        val expectedGameResult = result.entries.iterator().next().value
        Assertions.assertTrue(expectedGameResult.items.contains("Knife"))
    }

    @Test
    fun noItemsIsFound() {
        val room = Room(objects = listOf(Utensil("Knife")))

        val result = Navigation(emptyList(), MazeMap(Rooms(room))).searchItemsMaze(room)

        val expectedGameResult = result.entries.iterator().next().value
        Assertions.assertTrue(expectedGameResult.items.contains("None"))
    }
}