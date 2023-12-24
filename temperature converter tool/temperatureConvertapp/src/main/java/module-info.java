module com.internshalaa.example.temperatureconvertapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.internshalaa.example.temperatureconvertapp to javafx.fxml;
    exports com.internshalaa.example.temperatureconvertapp;
}