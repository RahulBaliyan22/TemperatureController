package com.internshalaa.example.temperatureconvertapp;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;



public class HelloController implements Initializable {
    public Label welcomeLabel;
    public ChoiceBox<String> choicebox;
    public TextField userinputfield;
    public Button convertButton;

    private static final String C_to_F ="Celsius to Fahrenheit";
    private static final String F_to_C ="Fahrenheit to Celsius";
    private boolean isC_to_F = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choicebox.getItems().add(C_to_F);
        choicebox.getItems().add(F_to_C);
        choicebox.setValue(C_to_F);

        choicebox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1)-> {
            if(t1.equals(C_to_F)){
                isC_to_F=true;
            }else{
                isC_to_F=false;
            }
        });

        convertButton.setOnAction(actionEvent -> convert());

    }

    private void convert() {
        String input = userinputfield.getText();
        float enteredtemp=0.0f;
        try{
            enteredtemp = Float.parseFloat(input);
        }catch (Exception e){
            warnUser();
            return;
            //no code executed..
        }

        float newTemperature = 0.0f;
        if(isC_to_F){
            newTemperature=(enteredtemp*9/5)+32;
        }else{
            newTemperature=(enteredtemp-32)*5/9;
        }
        display(newTemperature);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Temperature");
        alert.setContentText("enter valid temperature");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit = isC_to_F?" F":" C";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText("Message");
        alert.setContentText("the new temperature is: "+newTemperature+unit);
        alert.show();
    }
}