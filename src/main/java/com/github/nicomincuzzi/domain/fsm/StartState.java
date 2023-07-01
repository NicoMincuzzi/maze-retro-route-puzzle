package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.ManagerMaze;
import com.github.nicomincuzzi.domain.MazeMap;

import java.util.Scanner;

public class StartState implements MazeState<ManagerMaze> {

    private ManagerMaze maze;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void enter(ManagerMaze maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        MazeMap mazeMap = MazeMap.byJsonFile();

        maze.changeStateMazeFsm(new InsertState(scanner, mazeMap));
    }

}
