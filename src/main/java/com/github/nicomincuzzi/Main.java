package com.github.nicomincuzzi;

import com.github.nicomincuzzi.domain.MazeMap;
import com.github.nicomincuzzi.domain.MazeRetroRoute;
import com.github.nicomincuzzi.usecase.MazeFsm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(MazeMap.class);

    public static void main(String[] args) {
        try {
            MazeRetroRoute mazeRetroRoute = new MazeRetroRoute(new MazeFsm<>());
            mazeRetroRoute.run();
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
        }
    }
}
