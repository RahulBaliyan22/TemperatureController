package com.internshalaa.example.temperatureconvertapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent rootnode = fxmlLoader.load();

        BorderPane rootLayout = new BorderPane();
        MenuBar mb = createBar();
        rootLayout.setTop(mb);
        rootLayout.setCenter(rootnode);

        Scene scene = new Scene(rootLayout, 320, 240);

        stage.setTitle("Temperature Converter Tool");
        stage.setScene(scene);
        stage.show();
    }
    public MenuBar createBar(){
        //1)menu= first child class of MenuBar
        Menu File = new Menu("file");
        Menu help = new Menu("help");

        //2)MenuItems
        MenuItem open = new MenuItem("open");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem exit = new MenuItem("exit");
        MenuItem about = new MenuItem("about");

        //3)clicker action
        open.setOnAction(actionEvent -> System.out.println("Open"));
        exit.setOnAction(actionEvent -> {Platform.exit();System.exit(0);});
        about.setOnAction(actionEvent -> about());

        //4)adding MenuItems to Menus
        File.getItems().addAll(open,separator,exit);
        help.getItems().addAll(about);

        //5)adding Menus to MenuBar
        MenuBar mb = new MenuBar();
        mb.getMenus().addAll(File,help);
        return mb;
    }
    public static void about(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("First java game");
        alert.setHeaderText("Learning java");
        alert.setContentText("hello! this is my first java game I'm going to be pro in it");
        alert.show();
    }

    public static void main(String[] args) {
        launch();
    }
}