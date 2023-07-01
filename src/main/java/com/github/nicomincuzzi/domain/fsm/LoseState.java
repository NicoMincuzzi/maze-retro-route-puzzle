package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.ManagerMaze;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoseState implements MazeState<ManagerMaze> {
    private ManagerMaze maze;

    private static final Logger logger = LoggerFactory.getLogger(LoseState.class);

    @Override
    public void enter(ManagerMaze maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        logger.info("I'm sorry! You haven't found new objects!");
        maze.changeStateMazeFsm(new LeaveState());
    }
}
