package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.MazeRetroRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LeaveState implements MazeState<MazeRetroRoute> {

    private static final Logger logger = LoggerFactory.getLogger(LeaveState.class);

    private MazeRetroRoute maze;
    private Scanner scanner;

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        logger.info("Press 'R' to restart or 'E' to exit: ");
        String objToCollect = scanner.nextLine();

        if (objToCollect.equalsIgnoreCase("R"))
            maze.changeStateMazeFsm(new StartState());
        else if (objToCollect.equalsIgnoreCase("E"))
            System.exit(0);
    }

}
