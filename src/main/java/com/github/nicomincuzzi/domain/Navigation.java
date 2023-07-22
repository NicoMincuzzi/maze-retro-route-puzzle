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
        if (roomMaze == null) {
            return outputMaze;
        }

        Utensils foundItems = roomMaze.searchItemsMaze(findingItems);

        GameResult gameResult = new GameResult(roomMaze.getId(), roomMaze.getName(), foundItems);
        outputMaze.put(randomUUID().toString(), gameResult);

        if (!foundItems.getUtensils().isEmpty())
            counter--;

        if (counter != 0)
            mazeNavigation(roomMaze, findingItems, counter);

        return outputMaze;
    }

    private void mazeNavigation(Room roomMaze, Utensils findingItems, int counter) {
        Room room = Room.noExistingRoom();
        if (roomMaze.getNorth() != null) {
            int nextRoom = roomMaze.getNorth();
            roomMaze.setNorth(null);
            room = mazeMap.getRooms().getRoomById(nextRoom);
            searchItemsMaze(findingItems, room, counter);
        }

        if (roomMaze.getSouth() != null) {
            int nextRoom = roomMaze.getSouth();
            roomMaze.setSouth(null);
            room = mazeMap.getRooms().getRoomById(nextRoom);
            searchItemsMaze(findingItems, room, counter);
        }

        if (roomMaze.getWest() != null) {
            int nextRoom = roomMaze.getWest();
            roomMaze.setWest(null);
            room = mazeMap.getRooms().getRoomById(nextRoom);
            searchItemsMaze(findingItems, room, counter);
        }

        if (roomMaze.getEast() != null) {
            int nextRoom = roomMaze.getEast();
            roomMaze.setEast(null);
            room = mazeMap.getRooms().getRoomById(nextRoom);
            searchItemsMaze(findingItems, room, counter);
        }
    }
}
