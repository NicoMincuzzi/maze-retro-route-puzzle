package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.GameResult;
import com.github.nicomincuzzi.domain.ManagerMaze;
import com.github.nicomincuzzi.domain.MazeMap;
import com.github.nicomincuzzi.domain.Navigation;
import com.github.nicomincuzzi.maze.Room;

import java.util.List;
import java.util.Map;

public class PlayState implements MazeState<ManagerMaze> {

    private ManagerMaze maze;
    private final List<String> findingItems;
    private final MazeMap mazeMap;
    private final Room roomMaze;

    public PlayState(List<String> findingItems, MazeMap mazeMap, Room roomMaze) {
        this.findingItems = findingItems;
        this.mazeMap = mazeMap;
        this.roomMaze = roomMaze;
    }

    @Override
    public void enter(ManagerMaze maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        Navigation navMap = new Navigation(findingItems, mazeMap);

        Map<String, GameResult> foundItems = navMap.searchItemsMaze(roomMaze);

        MazeState<ManagerMaze> state = isFoundItem(foundItems) ? new WinState() : new LoseState();

        GameResult.show(foundItems);

        maze.changeStateMazeFsm(state);
    }

    private boolean isFoundItem(Map<String, GameResult> resultOutput) {
        for (String idStepRoute : resultOutput.keySet()) {
            for (String item : resultOutput.get(idStepRoute).getItems()) {
                if (!item.equals("None"))
                    return true;
            }
        }
        return false;
    }
}