package com.github.nicomincuzzi.domain.fsm

import com.github.nicomincuzzi.domain.MazeRetroRoute
import com.github.nicomincuzzi.usecase.LeaveState
import com.github.nicomincuzzi.usecase.LoseState
import com.github.nicomincuzzi.usecase.WinState
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class LoseStateTest {
    @Test
    fun executeLoseState() {
        val mazeRetroRoute = Mockito.mock(MazeRetroRoute::class.java)

        val loseState = LoseState()
        loseState.enter(mazeRetroRoute)
        loseState.execute()

        val argument: ArgumentCaptor<WinState> = ArgumentCaptor.forClass(WinState::class.java)
        Mockito.verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        Assertions.assertTrue(argument.value is LeaveState)
    }
}