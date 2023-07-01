package com.github.nicomincuzzi;

import com.github.nicomincuzzi.domain.ManagerMaze;
import com.github.nicomincuzzi.domain.fsm.MazeFsm;

public class Main {
    public static void main(String[] args) {
        ManagerMaze mazeRoutePuzzle = new ManagerMaze(new MazeFsm<>());
        mazeRoutePuzzle.runMazeRetroRoutePuzzle();
    }
}
