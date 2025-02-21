package com.nicomincuzzi.frameworkless.domain.fsm

import com.github.nicomincuzzi.domain.*
import com.github.nicomincuzzi.usecase.InsertState
import com.github.nicomincuzzi.usecase.LeaveState
import com.github.nicomincuzzi.usecase.PlayState
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
        val mazeMap = MazeMap(Rooms(Room(0, "ignore", null, null, null, null, Utensils(emptyList()))))

        val insertState = InsertState(scanner, mazeMap)
        insertState.enter(mazeRetroRoute)
        insertState.update()

        val argument: ArgumentCaptor<PlayState> = ArgumentCaptor.forClass(PlayState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        Assertions.assertTrue(argument.value is PlayState)
    }

    @Test
    fun executeInsertStateWithMoreItems() {
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val scanner = mock(Scanner::class.java)
        `when`(scanner.nextLine()).thenReturn("3").thenReturn("Knife, Fork")
        val room = Room(0, "ignore", null, null, null, null, Utensils(listOf(Utensil("Knife"))))

        val insertState = InsertState(scanner, MazeMap(Rooms(room)))
        insertState.enter(mazeRetroRoute)
        insertState.update()

        val argument: ArgumentCaptor<PlayState> = ArgumentCaptor.forClass(PlayState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        Assertions.assertTrue(argument.value is PlayState)
    }

    @Test
    fun executeInsertStateWithNoValidRoomNumber() {
        val mazeRetroRoute = mock(MazeRetroRoute::class.java)

        val scanner = mock(Scanner::class.java)
        `when`(scanner.nextLine()).thenReturn("50").thenReturn("Knife, Fork")
        val mazeMap = MazeMap(Rooms(Room(0, "ignore", null, null, null, null, Utensils(emptyList()))))

        val insertState = InsertState(scanner, mazeMap)
        insertState.enter(mazeRetroRoute)
        insertState.update()

        val argument: ArgumentCaptor<LeaveState> = ArgumentCaptor.forClass(LeaveState::class.java)
        verify(mazeRetroRoute).changeStateMazeFsm(argument.capture())
        Assertions.assertTrue(argument.value is LeaveState)
    }
}