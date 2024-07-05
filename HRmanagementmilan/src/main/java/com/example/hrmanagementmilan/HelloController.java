package com.example.hrmanagementmilan;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;


import java.io.IOException;

public class HelloController {
    public Button thatbutton;
    public TextField Email;
    public PasswordField Password;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        String uemail = Email.getText();
        String upassword = Password.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM login where Email='"+uemail+"' AND Password='"+upassword+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            if (resultSet.next()) {
                try {

                    Parent secondScene = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));

                    Stage secondStage = new Stage();
                    secondStage.setTitle("Dashboard Scene");
                    secondStage.setScene(new Scene(secondScene));

                    Stage firstSceneStage = (Stage) thatbutton.getScene().getWindow();
                    firstSceneStage.close();


                    secondStage.show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } else {
                welcomeText.setText("invalid email or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

}



