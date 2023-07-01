package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.ManagerMaze;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WinState implements MazeState<ManagerMaze> {
    private static final Logger logger = LoggerFactory.getLogger(WinState.class);
    private ManagerMaze maze;

    @Override
    public void enter(ManagerMaze maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        logger.info("Cool! You have found new objects!");
        maze.changeStateMazeFsm(new LeaveState());
    }
}
