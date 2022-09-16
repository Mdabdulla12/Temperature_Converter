package com.example.javafxapp.javafx;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    @FXML
    public Label welcomelabel;
    @FXML
    public ChoiceBox <String>choiceBox;
    @FXML
    public TextField userinput;
    @FXML
    public Button convertButton;
    private static final String C_TO_F_TEXT="Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT="Fahrenheit to Celsius";
    private boolean isC_TO_F=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);
        choiceBox.setValue(C_TO_F_TEXT);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if(t1.equals(isC_TO_F)){
                isC_TO_F=true;
            }else{
                isC_TO_F=false;
            }
        });

        convertButton.setOnAction(actionEvent ->{
            convert();
        });
    }

    private void convert() {
        String input=userinput.getText();
        float enterTemperature=0.0f;
        try {
            enterTemperature = Float.parseFloat(input);
        }catch (Exception e){
            warnUser();
            return;
        }
        float newTemperature=0.0f;
        //float enterTemperature = 0.0f;
        if(isC_TO_F){
            newTemperature=(enterTemperature*9/5)+32;

        }
        else{
            newTemperature=(enterTemperature-32)*5/9;
        }
        display(newTemperature);
    }

    private void warnUser() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText(" Invalid Temperature Entered");
        alert.setContentText("Please Enter a valid Temperature");
        alert.show();

    }

    private void display(float newTemperature) {
        String unit=isC_TO_F?"F":"C";
        System.out.println("Temperature ="+newTemperature+" "+unit);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("Temperature ="+newTemperature+" "+unit);
        alert.show();

    }
}
