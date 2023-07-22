package com.github.nicomincuzzi.usecase;

import com.github.nicomincuzzi.domain.GameResult;
import com.github.nicomincuzzi.domain.MazeMap;
import com.github.nicomincuzzi.domain.MazeRetroRoute;
import com.github.nicomincuzzi.domain.Navigation;
import com.github.nicomincuzzi.domain.Room;
import com.github.nicomincuzzi.domain.Utensil;
import com.github.nicomincuzzi.domain.Utensils;

import java.util.Map;

public class PlayState implements MazeState<MazeRetroRoute> {

    private final Navigation navigation;
    private MazeRetroRoute maze;
    private final Room roomMaze;

    public PlayState(Navigation navigation, Room roomMaze) {
        this.navigation = navigation;
        this.roomMaze = roomMaze;
    }

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        Map<String, GameResult> foundItems = navigation.searchItemsMaze(roomMaze);

        MazeState<MazeRetroRoute> state = isFoundItem(foundItems) ? new WinState() : new LoseState();

        GameResult.show(foundItems);

        maze.changeStateMazeFsm(state);
    }

    private boolean isFoundItem(Map<String, GameResult> resultOutput) {
        for (String idStepRoute : resultOutput.keySet()) {
            for (Utensil item : resultOutput.get(idStepRoute).getItems().getUtensils()) {
                if (!item.getName().equals("None"))
                    return true;
            }
        }
        return false;
    }
}