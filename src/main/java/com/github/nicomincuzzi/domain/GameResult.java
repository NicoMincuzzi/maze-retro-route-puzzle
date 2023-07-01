package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.domain.fsm.InsertState;
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
        logger.info("+----+-------------+--------------------+");
        logger.info("| ID | Room        | Object Collected   |");
        logger.info("+----+-------------+--------------------+");

        for (String idStepRoute : foundItems.keySet()) {
            String items = null;

            for (String item : foundItems.get(idStepRoute).getItems()) {
                items = removeLastComma(item.concat(","));
            }

            logger.info("| " + foundItems.get(idStepRoute).getId() +
                    "  | " + foundItems.get(idStepRoute).getRoom() +
                    " | " + items + "|");
        }
        logger.info("+----+-------------+--------------------+");
    }

    private static String removeLastComma(String listWords) {
        return listWords.substring(0, listWords.lastIndexOf(","));
    }
}
