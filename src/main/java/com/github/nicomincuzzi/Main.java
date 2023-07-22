package com.github.nicomincuzzi;

import com.github.nicomincuzzi.domain.MazeRetroRoute;
import com.github.nicomincuzzi.usecase.MazeFsm;

public class Main {
    public static void main(String[] args) {
        //try {
            MazeRetroRoute mazeRoutePuzzle = new MazeRetroRoute(new MazeFsm<>());
            mazeRoutePuzzle.runMazeRetroRoutePuzzle();
/*        } catch (Throwable t) {
            System.out.println(t);
        }*/
    }
}
