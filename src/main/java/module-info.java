module com.internshala.javafxapp.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxapp.javafx to javafx.fxml;
    exports com.example.javafxapp.javafx;
}