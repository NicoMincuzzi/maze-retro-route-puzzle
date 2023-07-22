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
    private final Utensils findingItems;
    private final Room roomMaze;
    private int counter;

    public PlayState(Navigation navigation, Utensils findingItems, Room roomMaze) {
        this.navigation = navigation;
        this.findingItems = findingItems;
        counter = findingItems.size();
        this.roomMaze = roomMaze;
    }

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        Map<String, GameResult> foundItems = navigation.searchItemsMaze(findingItems, roomMaze, counter);

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