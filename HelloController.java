package com.example.mesapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private TextField monthInput;

    @FXML
    private void showMonth() {
        String input = monthInput.getText().trim();

        if (!input.matches("\\d+")) {
            showAlert("Error", "Solo se permiten números enteros.");
            return;
        }

        int number = Integer.parseInt(input);
        if (number < 1 || number > 12) {
            showAlert("Error", "El número debe estar entre 1 y 12.");
            return;
        }

        String[] months = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        String monthName = months[number - 1];
        showMonthWindow(monthName);
    }

    private void showMonthWindow(String monthName) {
        Stage monthStage = new Stage();
        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().add(new Label("El mes es: " + monthName));
        Scene scene = new Scene(root, 250, 100);
        monthStage.setScene(scene);
        monthStage.setTitle("Mes");
        monthStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}