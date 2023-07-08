package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.usecase.InsertState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class GameResult {
    private int id;
    private String room;
    private List<String> items;
    private static final Logger logger = LoggerFactory.getLogger(InsertState.class);

    public GameResult(int id, String room, List<String> items) {
        this.id = id;
        this.room = room;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public List<String> getItems() {
        return items;
    }

    public static void show(Map<String, GameResult> foundItems) {
        System.out.println("+----+-------------+--------------------+");
        System.out.println("| ID | Room        | Object Collected   |");
        System.out.println("+----+-------------+--------------------+");

        for (String idStepRoute : foundItems.keySet()) {
            String items = "None";

            for (String item : foundItems.get(idStepRoute).getItems()) {
                items = removeLastComma(item.concat(","));
            }

            System.out.println("| " + foundItems.get(idStepRoute).getId() +
                    "  | " + foundItems.get(idStepRoute).getRoom() +
                    " | " + items + "|");
        }
        System.out.println("+----+-------------+--------------------+");
    }

    private static String removeLastComma(String listWords) {
        return listWords.substring(0, listWords.lastIndexOf(","));
    }
}
