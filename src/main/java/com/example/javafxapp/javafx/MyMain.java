package com.example.javafxapp.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");

        launch();
    }
@Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        FXMLLoader fxmlLoader = new FXMLLoader(MyMain.class.getResource("app_layout.fxml"));

        VBox rootNode=fxmlLoader.load();
        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar); //VBox ke 0 index pr MenuBar

        Scene scene = new Scene(rootNode);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private  MenuBar createMenu(){
        //file Menu
        Menu fileMenu=new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");
        newMenuItem.setOnAction(actionEvent -> {
            System.out.println("new MenuItem");


        });
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        //help menu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutMenuItem=new MenuItem("About");
        MenuItem aboutDevMenuItem=new MenuItem("About Developer");
        aboutMenuItem.setOnAction(actionEvent -> aboutApp());
        aboutDevMenuItem.setOnAction(actionEvent -> aboutDevMenuItem());
        helpMenu.getItems().addAll(aboutMenuItem,aboutDevMenuItem);



//menu bar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutDevMenuItem() {
        Alert alertDialog=new Alert(Alert.AlertType.CONFIRMATION);
        alertDialog.setTitle("About Developer");
        alertDialog.setHeaderText("Md.Abdullah");

        alertDialog.setContentText("Contact : abdulgour29@gmail.com");
        alertDialog.show();
    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.CONFIRMATION);
        alertDialog.setTitle("About Temperature Converter");
        alertDialog.setHeaderText("Temperature Converter Tool");
        alertDialog.setContentText("Formulas for temperature conversion :\nCelsius to Fahrenheit Conversion: °F = (9/5) × (°C) + 32\nFahrenheit to Celsius Conversion: °C = (5/9) × (°F − 32)\nCelsius to Kelvin Conversion: K = °C + 273.15\nFahrenheit to Kelvin Conversion: K = °F + 457.87.");
        ButtonType yesButton=new ButtonType("Yes");
        ButtonType noButton =new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesButton,noButton);

        //visible to the user :alertDialog.show();
        //It Shows which user entered button and return it:alertDialog.showAndWait();
        //Optional :is a container that is Contains the another obj

        Optional<ButtonType> clickedButton =alertDialog.showAndWait();
        if(clickedButton.get()==yesButton){
            System.out.println("yes button clicked");
         }
        else{
            System.out.println("no button clicked");
        }



    }
}