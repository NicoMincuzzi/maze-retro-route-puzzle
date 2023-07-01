package com.github.nicomincuzzi.maze

data class Room(
        val id: Int = 3,
        val name: String = "Kitchen",
        var north: Int? = null,
        var south: Int? = null,
        var east: Int? = null,
        var west: Int? = null,
        val objects: List<Utensil> = listOf()
){
}