package com.github.nicomincuzzi.usecase;

import com.github.nicomincuzzi.domain.MazeMap;
import com.github.nicomincuzzi.domain.MazeRetroRoute;

import java.util.Scanner;

public class StartState implements MazeState<MazeRetroRoute> {

    private MazeRetroRoute maze;

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void update() {
        maze.changeStateMazeFsm(new InsertState(new Scanner(System.in), MazeMap.byJsonFile()));
    }

}
