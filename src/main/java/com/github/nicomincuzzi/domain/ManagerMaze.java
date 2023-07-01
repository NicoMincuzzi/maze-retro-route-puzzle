package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.domain.fsm.MazeFsm;
import com.github.nicomincuzzi.domain.fsm.MazeState;
import com.github.nicomincuzzi.domain.fsm.StartState;

public class ManagerMaze {

    private final MazeFsm<ManagerMaze> mazeFsm;

    public ManagerMaze(MazeFsm<ManagerMaze> mazeFsm) {
        this.mazeFsm = mazeFsm;
    }

    public void runMazeRetroRoutePuzzle() {
        mazeFsm.startMazeRoutePuzzle(this, new StartState());
    }

    public void changeStateMazeFsm(MazeState<ManagerMaze> state) {
        mazeFsm.changeState(state);
    }
}
