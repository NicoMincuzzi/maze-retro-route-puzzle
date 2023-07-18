package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.maze.Room;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.UUID.randomUUID;

public class Navigation {

    private final LinkedHashMap<String, GameResult> outputMaze;
    private final Utensils findingItems;
    private final MazeMap mazeMap;
    private int counter;

    public Navigation(Utensils findingItems, MazeMap mazeMap) {
        this.findingItems = findingItems;
        this.mazeMap = mazeMap;
        counter = findingItems.size();
        outputMaze = new LinkedHashMap<>();
    }

    public Map<String, GameResult> searchItemsMaze(Room roomMaze) {
        if (roomMaze != null) {
            List<String> foundItems = roomMaze.searchItemsMaze(findingItems);

            GameResult gameResult = new GameResult(roomMaze.getId(), roomMaze.getName(), foundItems);
            outputMaze.put(randomUUID().toString(), gameResult);

            if (!foundItems.isEmpty())
                counter--;

            mazeNavigation(roomMaze);
        }
        return outputMaze;
    }

    private void mazeNavigation(Room roomMaze) {
        if (counter == 0)
            return;

        if (roomMaze.getNorth() != null) {
            int nextRoom = roomMaze.getNorth();
            roomMaze.setNorth(null);
            moveNextRoom(nextRoom);
        }

        if (roomMaze.getSouth() != null) {
            int nextRoom = roomMaze.getSouth();
            roomMaze.setSouth(null);
            moveNextRoom(nextRoom);
        }

        if (roomMaze.getWest() != null) {
            int nextRoom = roomMaze.getWest();
            roomMaze.setWest(null);
            moveNextRoom(nextRoom);
        }

        if (roomMaze.getEast() != null) {
            int nextRoom = roomMaze.getEast();
            roomMaze.setEast(null);
            moveNextRoom(nextRoom);
        }
    }

    private void moveNextRoom(int idNextRoom) {
        Room room = mazeMap.getRooms().getRoomById(idNextRoom);
        searchItemsMaze(room);
    }
}
