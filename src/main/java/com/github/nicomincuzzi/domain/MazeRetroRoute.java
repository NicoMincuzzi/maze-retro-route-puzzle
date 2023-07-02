package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.domain.fsm.MazeFsm;
import com.github.nicomincuzzi.domain.fsm.MazeState;
import com.github.nicomincuzzi.domain.fsm.StartState;

public class MazeRetroRoute {

    private final MazeFsm<MazeRetroRoute> mazeFsm;

    public MazeRetroRoute(MazeFsm<MazeRetroRoute> mazeFsm) {
        this.mazeFsm = mazeFsm;
    }

    public void runMazeRetroRoutePuzzle() {
        mazeFsm.startMazeRoutePuzzle(this, new StartState());
    }

    public void changeStateMazeFsm(MazeState<MazeRetroRoute> state) {
        mazeFsm.changeState(state);
    }
}
