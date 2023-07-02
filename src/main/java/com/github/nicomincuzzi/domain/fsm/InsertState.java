package com.github.nicomincuzzi.domain.fsm;

import com.github.nicomincuzzi.domain.MazeRetroRoute;
import com.github.nicomincuzzi.domain.MazeMap;
import com.github.nicomincuzzi.maze.Room;
import com.github.nicomincuzzi.utils.StringHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InsertState implements MazeState<MazeRetroRoute> {

    private MazeRetroRoute maze;
    private final MazeMap mazeMap;
    private final Scanner scanner;

    private final Logger logger = LoggerFactory.getLogger(InsertState.class);

    public InsertState(Scanner scanner, MazeMap mazeMap) {
        this.mazeMap = mazeMap;
        this.scanner = scanner;
    }

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        System.out.println("Input start room ID: ");
        int roomNumber = parseInt(scanner.nextLine());

        Room roomMaze = mazeMap.getRooms().getRoomById(roomNumber);

        if (roomMaze == null) {
            System.out.println("Please insert a valid room number!");
            maze.changeStateMazeFsm(new LeaveState());
        } else {
            System.out.println("Input objects to collect: ");
            String objToCollect = scanner.nextLine();
            List<String> findingItems = StringHandler.getInstance().getListInputWords(objToCollect);

            maze.changeStateMazeFsm(new PlayState(findingItems, mazeMap, roomMaze));
        }
    }
}
