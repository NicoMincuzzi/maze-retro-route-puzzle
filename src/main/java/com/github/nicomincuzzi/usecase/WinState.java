package com.github.nicomincuzzi.usecase;

import com.github.nicomincuzzi.domain.MazeRetroRoute;

public class WinState implements MazeState<MazeRetroRoute> {
    private MazeRetroRoute maze;

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void update() {
        System.out.println("Cool! You have found new objects!");
        maze.changeStateMazeFsm(new LeaveState());
    }
}
