package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.infrastructure.CommandLineTable;
import com.github.nicomincuzzi.usecase.InsertState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GameResult {
    private static final Logger logger = LoggerFactory.getLogger(InsertState.class);

    private int id;
    private String room;
    private Utensils items;

    public GameResult(int id, String room, Utensils items) {
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

    public Utensils getItems() {
        return items;
    }

    public static void show(Map<String, GameResult> foundItems) {
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("ID", "Room", "Object Collected");

        for (String idStepRoute : foundItems.keySet()) {
            String items = "None";

            for(Utensil item : foundItems.get(idStepRoute).getItems().getUtensils()) {
                items = removeLastComma(item.getName().concat(","));
            }

            st.addRow(String.valueOf(foundItems.get(idStepRoute).getId()), foundItems.get(idStepRoute).getRoom(), items);
        }
        st.print();
    }

    private static String removeLastComma(String listWords) {
        return listWords.substring(0, listWords.lastIndexOf(","));
    }
}
