package com.nicomincuzzi.frameworkless.domain.fsm

import com.github.nicomincuzzi.domain.*
import com.github.nicomincuzzi.maze.Room
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
        val room = Room(objects = listOf(Utensil("Knife")))
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val playState = PlayState(Utensils(Utensil("Knife")), MazeMap(Rooms(room)), room)
        playState.enter(mazeRetroRoute)
        playState.execute()

        val argument: ArgumentCaptor<WinState> = ArgumentCaptor.forClass(WinState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        assertTrue(argument.value is WinState)
    }

    @Test
    fun loseInPlayState() {
        val room = Room(objects = listOf(Utensil("Knife")))
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val playState = PlayState(Utensils(Utensil("Fork")), MazeMap(Rooms(room)), room)
        playState.enter(mazeRetroRoute)
        playState.execute()

        val argument: ArgumentCaptor<LoseState> = ArgumentCaptor.forClass(LoseState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        assertTrue(argument.value is LoseState)
    }
}