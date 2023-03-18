package com.example.vocabulary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.util.Collections;

    public class HelloController {
    public TextField input;
    private ObservableList<String> vocalbery = FXCollections.observableArrayList();
    public ListView<String> output;
    private MultipleSelectionModel<String> selectionModel;

    public void btnClickedAdd(ActionEvent actionEvent) {
        if (!input.getText().trim().isEmpty()) {
            if (!checkWords(input.getText())) {
                vocalbery.add(input.getText().trim());
                showAllWords();
            }
        }
        input.clear();
    }
    private boolean checkWords(String value) {
        return vocalbery.contains(value);
    }

    public void btnClickedDel(ActionEvent actionEvent) {
        selectionModel = output.getSelectionModel();
        vocalbery.remove(selectionModel.getSelectedItem());
        showAllWords();
    }
    private void showAllWords() {
        Collections.sort(vocalbery);
        output.setItems(vocalbery);
    }
}