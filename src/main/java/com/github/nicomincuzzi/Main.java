package com.github.nicomincuzzi;

import com.github.nicomincuzzi.domain.MazeRetroRoute;
import com.github.nicomincuzzi.domain.fsm.MazeFsm;

public class Main {
    public static void main(String[] args) {
        MazeRetroRoute mazeRoutePuzzle = new MazeRetroRoute(new MazeFsm<>());
        mazeRoutePuzzle.runMazeRetroRoutePuzzle();
    }
}
