package com.example.demo;


import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ListController extends MainController{
    @FXML
    private VBox VBox1;

    @FXML
    public void initialize() {
        countryList = SCVnm("111");




        int n;
        if (countryList.size() < 5) n = countryList.size();
        else n = 5;
        for(int i = 0; i<n; i++){
            AnchorPane pane = new AnchorPane();
            pane.setPrefHeight(200);
            Label label1 = new Label();
            AnchorPane.setLeftAnchor(label1,30.0);
            if (countryList.get(i).names.contains(";")) label1.setText(countryList.get(i).names.substring(0, countryList.get(i).names.indexOf(';')));
            else label1.setText(countryList.get(i).names);
            int finalI = i;
            label1.setOnMouseClicked(e -> {
                Stage stage = new Stage();
                FXMLLoader root = new FXMLLoader(getClass().getResource("View.fxml"));
                View controller1 = new View(countryList.get(finalI).names, countryList.get(finalI).capitals, countryList.get(finalI).largestCity, countryList.get(finalI).neighbours, countryList.get(finalI).flag);
                root.setController(controller1);
                AnchorPane splitPane = null;
                try {
                    splitPane = root.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                Scene scene = new Scene(splitPane, 800, 600);
                stage.setScene(scene);
                stage.setTitle("List");
                stage.setScene(scene);
                stage.show();


            });
            VBox1.getChildren().add(pane);
            pane.getChildren().add(label1);








        }


    }


}
