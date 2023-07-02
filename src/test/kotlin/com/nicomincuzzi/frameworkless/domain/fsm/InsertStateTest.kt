package com.nicomincuzzi.frameworkless.domain.fsm

import com.github.nicomincuzzi.domain.MazeRetroRoute
import com.github.nicomincuzzi.domain.MazeMap
import com.github.nicomincuzzi.domain.Rooms
import com.github.nicomincuzzi.domain.fsm.InsertState
import com.github.nicomincuzzi.domain.fsm.LeaveState
import com.github.nicomincuzzi.domain.fsm.PlayState
import com.github.nicomincuzzi.maze.Room
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*
import java.util.*

class InsertStateTest {
    @Test
    fun executeInsertStateWithOneItem() {
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val scanner = mock(Scanner::class.java)
        `when`(scanner.nextLine()).thenReturn("3").thenReturn("Knife")
        val mazeMap = MazeMap( Rooms(Room()))

        val insertState = InsertState(scanner, mazeMap)
        insertState.enter(mazeRetroRoute)
        insertState.execute()

        val argument: ArgumentCaptor<PlayState> = ArgumentCaptor.forClass(PlayState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        Assertions.assertTrue(argument.value is PlayState)
    }

    @Test
    fun executeInsertStateWithMoreItems() {
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val scanner = mock(Scanner::class.java)
        `when`(scanner.nextLine()).thenReturn("3").thenReturn("Knife, Fork")
        val mazeMap = MazeMap.empty()

        val insertState = InsertState(scanner, mazeMap)
        insertState.enter(mazeRetroRoute)
        insertState.execute()

        val argument: ArgumentCaptor<PlayState> = ArgumentCaptor.forClass(PlayState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        Assertions.assertTrue(argument.value is PlayState)
    }

    @Test
    fun executeInsertStateWithNoValidRoomNumber() {
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val scanner = mock(Scanner::class.java)
        `when`(scanner.nextLine()).thenReturn("50").thenReturn("Knife, Fork")
        val mazeMap = MazeMap( Rooms(Room()))

        val insertState = InsertState(scanner, mazeMap)
        insertState.enter(mazeRetroRoute)
        insertState.execute()

        val argument: ArgumentCaptor<LeaveState> = ArgumentCaptor.forClass(LeaveState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        Assertions.assertTrue(argument.value is LeaveState)
    }
}