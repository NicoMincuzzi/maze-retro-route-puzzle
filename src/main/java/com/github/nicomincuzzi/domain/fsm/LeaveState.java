package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.ManagerMaze;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LeaveState implements MazeState<ManagerMaze> {

    private static final Logger logger = LoggerFactory.getLogger(LeaveState.class);

    private ManagerMaze maze;
    private Scanner scanner;

    @Override
    public void enter(ManagerMaze maze) {
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
