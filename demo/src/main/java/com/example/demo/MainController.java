package com.example.demo;
import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.util.Scanner;

import java.util.LinkedList;

public class MainController {
    static LinkedList<Country> countryList;
    public static String pathCSV = "C:\\Users\\artzh\\IdeaProjects\\demo\\src\\main\\resources\\data.csv";
    public MainController() {

    }
    public static boolean addInCSV()
    {
        try (PrintWriter writer = new PrintWriter(pathCSV)){
            for (Country country : countryList) {
                String line = "";
                line +=  country.getNames() + ",";
                line +=  country.getCapitals() + ",";
                line += country.getLargestCity() + ",";
                line +=  country.getNeighbours() + ",";
                line +=  country.getFlag() + ",";
                writer.write(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }



    static LinkedList<Country> SCVnm(String path) {
        LinkedList<Country> newList = new LinkedList<Country>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File("C:\\Users\\artzh\\IdeaProjects\\demo\\src\\main\\resources\\data.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.useDelimiter(",");
        while (sc.hasNext()) {
        while (sc.hasNext()) {
            String[] columns = new String[5];
            for (int i = 0; i < 5 && sc.hasNext(); i++) {


                    columns[i] = sc.next();
                }

                Country newCountry = new Country(columns[0],columns[1] , columns[2], columns[3], columns[4]);

                newList.add(newCountry);

            }
        }

        sc.close();
        return (newList);
    }
    @FXML
    private Button listBt;
    @FXML
    private Button addBt;




    public void goToList(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) listBt.getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("List.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("List");
        stage.setScene(scene);
        stage.show();
    }

    public void goToAdd(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) addBt.getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("Add.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Add");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void initialize(){
        countryList = SCVnm("111");
    }
}




