package com.github.nicomincuzzi.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.UUID.randomUUID;

public class Navigation {

    private final LinkedHashMap<String, GameResult> outputMaze;
    private final MazeMap mazeMap;

    public Navigation(MazeMap mazeMap) {
        this.mazeMap = mazeMap;
        outputMaze = new LinkedHashMap<>();
    }

    public Map<String, GameResult> searchItemsMaze(Utensils findingItems, Room roomMaze, int counter) {
        if (roomMaze != null) {
            Utensils foundItems = roomMaze.searchItemsMaze(findingItems);

            GameResult gameResult = new GameResult(roomMaze.getId(), roomMaze.getName(), foundItems);
            outputMaze.put(randomUUID().toString(), gameResult);

            if (!foundItems.getUtensils().isEmpty())
                counter--;

            mazeNavigation(roomMaze, findingItems, counter);
        }
        return outputMaze;
    }

    private void mazeNavigation(Room roomMaze, Utensils findingItems, int counter) {
        if (counter == 0)
            return;

        if (roomMaze.getNorth() != null) {
            int nextRoom = roomMaze.getNorth();
            roomMaze.setNorth(null);
            moveNextRoom(nextRoom, findingItems, counter);
        }

        if (roomMaze.getSouth() != null) {
            int nextRoom = roomMaze.getSouth();
            roomMaze.setSouth(null);
            moveNextRoom(nextRoom, findingItems, counter);
        }

        if (roomMaze.getWest() != null) {
            int nextRoom = roomMaze.getWest();
            roomMaze.setWest(null);
            moveNextRoom(nextRoom, findingItems, counter);
        }

        if (roomMaze.getEast() != null) {
            int nextRoom = roomMaze.getEast();
            roomMaze.setEast(null);
            moveNextRoom(nextRoom, findingItems, counter);
        }
    }

    private void moveNextRoom(int idNextRoom, Utensils findingItems, int counter) {
        Room room = mazeMap.getRooms().getRoomById(idNextRoom);
        searchItemsMaze(findingItems, room, counter);
    }
}
