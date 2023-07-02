package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.MazeRetroRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoseState implements MazeState<MazeRetroRoute> {
    private MazeRetroRoute maze;

    private static final Logger logger = LoggerFactory.getLogger(LoseState.class);

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        System.out.println("I'm sorry! You haven't found new objects!");
        maze.changeStateMazeFsm(new LeaveState());
    }
}
