package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.usecase.MazeFsm;
import com.github.nicomincuzzi.usecase.MazeState;
import com.github.nicomincuzzi.usecase.StartState;

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
