package com.github.nicomincuzzi.usecase;

import com.github.nicomincuzzi.domain.MazeRetroRoute;

import java.util.Scanner;

public class LeaveState implements MazeState<MazeRetroRoute> {
    private MazeRetroRoute maze;
    private Scanner scanner;

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
        scanner = new Scanner(System.in);
    }

    @Override
    public void update() {
        System.out.println("Press 'R' to restart or 'E' to exit: ");
        String objToCollect = scanner.nextLine();

        if (objToCollect.equalsIgnoreCase("R"))
            maze.changeStateMazeFsm(new StartState());
        else if (objToCollect.equalsIgnoreCase("E"))
            System.exit(0);
    }

}
