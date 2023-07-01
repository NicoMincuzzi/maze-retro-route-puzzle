package com.github.nicomincuzzi.maze

class Utensil(val name: String = "") {

    fun isSameThan(item: String): Boolean {
        return item.equals(name, ignoreCase = true)
    }

    fun isSameThan(item: Utensil): Boolean {
        return item.name.equals(name, ignoreCase = true)
    }

}