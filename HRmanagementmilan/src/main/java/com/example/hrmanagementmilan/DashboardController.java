package com.example.hrmanagementmilan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    public Button Admin;
    public Button Employee;
    public Button Logout;
    public Button Exit;

    public void adminbutton(ActionEvent actionEvent) {
        try {

            Parent secondScene = FXMLLoader.load(getClass().getResource("admin.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("User Scene");
            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) Admin.getScene().getWindow();
            firstSceneStage.close();



            secondStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void employeebutton(ActionEvent actionEvent) {
        try {

            Parent secondScene = FXMLLoader.load(getClass().getResource("employee.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("User Scene");
            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) Employee.getScene().getWindow();
            firstSceneStage.close();



            secondStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void logout(ActionEvent actionEvent) {
    }

    public void exitbutton(ActionEvent actionEvent) {
        System.exit(0);
    }
}

