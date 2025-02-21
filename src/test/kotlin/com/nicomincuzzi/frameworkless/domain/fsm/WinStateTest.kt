package com.github.nicomincuzzi.domain.fsm

import com.github.nicomincuzzi.domain.MazeRetroRoute
import com.github.nicomincuzzi.usecase.LeaveState
import com.github.nicomincuzzi.usecase.WinState
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

internal class WinStateTest {
    @Test
    fun executeWinState() {
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val winState = WinState()
        winState.enter(mazeRetroRoute)
        winState.update()

        val argument: ArgumentCaptor<WinState> = ArgumentCaptor.forClass(WinState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        assertTrue(argument.value is LeaveState)
    }
}