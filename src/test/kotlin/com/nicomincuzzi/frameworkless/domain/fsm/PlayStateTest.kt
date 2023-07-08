package com.nicomincuzzi.frameworkless.domain.fsm

import com.github.nicomincuzzi.domain.MazeMap
import com.github.nicomincuzzi.domain.MazeRetroRoute
import com.github.nicomincuzzi.domain.Rooms
import com.github.nicomincuzzi.maze.Room
import com.github.nicomincuzzi.maze.Utensil
import com.github.nicomincuzzi.usecase.LoseState
import com.github.nicomincuzzi.usecase.PlayState
import com.github.nicomincuzzi.usecase.WinState
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class PlayStateTest {

    @Test
    fun winInPlayState() {
        val room = Room(objects = listOf(Utensil(name = "Knife")))
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val playState = PlayState(listOf("Knife"), MazeMap(Rooms(room)), room)
        playState.enter(mazeRetroRoute)
        playState.execute()

        val argument: ArgumentCaptor<WinState> = ArgumentCaptor.forClass(WinState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        assertTrue(argument.value is WinState)
    }

    @Test
    fun loseInPlayState() {
        val room = Room(objects = listOf(Utensil(name = "Knife")))
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val playState = PlayState(listOf("Fork"), MazeMap(Rooms(room)), room)
        playState.enter(mazeRetroRoute)
        playState.execute()

        val argument: ArgumentCaptor<LoseState> = ArgumentCaptor.forClass(LoseState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        assertTrue(argument.value is LoseState)
    }
}