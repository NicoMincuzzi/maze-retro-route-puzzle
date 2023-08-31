package com.github.nicomincuzzi.usecase;

import com.github.nicomincuzzi.domain.MazeRetroRoute;

public class LoseState implements MazeState<MazeRetroRoute> {
    private MazeRetroRoute maze;

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void update() {
        System.out.println("I'm sorry! You haven't found new objects!");
        maze.changeStateMazeFsm(new LeaveState());
    }
}
