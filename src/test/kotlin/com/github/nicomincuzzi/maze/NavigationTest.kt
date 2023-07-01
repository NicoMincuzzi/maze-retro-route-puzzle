package com.github.nicomincuzzi.maze

import com.github.nicomincuzzi.domain.MazeMap
import com.github.nicomincuzzi.domain.Navigation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NavigationTest {

    @Test
    fun oneItemsIsFoundWithSuccess() {
        val findingItems = listOf("Knife")
        val navigation = Navigation(findingItems, MazeMap.empty())
        val utensil = Utensil(name = "Knife")
        val roomMaze = Room(objects = listOf(utensil))

        val result = navigation.searchItemsMaze(roomMaze)
        val expectedGameResult = result.entries.iterator().next().value
        Assertions.assertTrue(expectedGameResult.items.contains("Knife"))
    }

    @Test
    fun noItemsIsFound() {
        val navigation = Navigation(emptyList(), MazeMap.empty())
        val utensil = Utensil(name = "Knife")
        val roomMaze = Room(objects = listOf(utensil))

        val result = navigation.searchItemsMaze(roomMaze)
        val expectedGameResult = result.entries.iterator().next().value
        Assertions.assertTrue(expectedGameResult.items.contains("None"))
    }
}