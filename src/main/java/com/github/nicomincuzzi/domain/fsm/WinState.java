package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.MazeRetroRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WinState implements MazeState<MazeRetroRoute> {
    private static final Logger logger = LoggerFactory.getLogger(WinState.class);
    private MazeRetroRoute maze;

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        logger.info("Cool! You have found new objects!");
        maze.changeStateMazeFsm(new LeaveState());
    }
}
