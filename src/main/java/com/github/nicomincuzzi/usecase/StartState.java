package com.github.nicomincuzzi.usecase;

import com.github.nicomincuzzi.domain.MazeRetroRoute;
import com.github.nicomincuzzi.domain.MazeMap;

import java.util.Scanner;

public class StartState implements MazeState<MazeRetroRoute> {

    private MazeRetroRoute maze;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        MazeMap mazeMap = MazeMap.byJsonFile();

        maze.changeStateMazeFsm(new InsertState(scanner, mazeMap));
    }

}
