package com.example.hrmanagementmilan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class employeeController {
    public TextField uid;
    public TextField uname;
    public TextField uadress;
    public TextField unum;
    public Button updatebutton;
    @FXML
    private TableColumn<admin, Integer> id;
    @FXML
    private TableColumn<admin, String> name;
    @FXML
    private TableColumn<admin, String> adress;
    @FXML
    private TableColumn<admin, Integer> num;
    @FXML
    private TableView<admin> tableview;
    @FXML
    private Button fetchbutton;

    private ObservableList<admin> admin = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize the table columns
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        num.setCellValueFactory(new PropertyValueFactory<>("num"));

        // Set the tableview items
        tableview.setItems(admin);
    }

    public void fetchdata(ActionEvent actionEvent) {
        populateTable();
    }

    public void populateTable() {
        admin.clear(); // Clear the current data

        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String adress = resultSet.getString("adress");
                int num = resultSet.getInt("num");
                admin.add(new admin(id, name, adress, num));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertdata(ActionEvent actionEvent) {
        String name = uname.getText();
        String adress = uadress.getText();
        int num = Integer.parseInt(unum.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to insert data into the database
            String query = "INSERT INTO employee (name, adress, num) VALUES ('" + name + "', '" + adress + "', " + num + ")";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletedata(ActionEvent actionEvent) {
        int id = Integer.parseInt(uid.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to delete data from the database
            String query = "DELETE FROM employee WHERE id=" + id;
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatedata(ActionEvent actionEvent) {
        int id = Integer.parseInt(uid.getText());
        String name = uname.getText();
        String adress = uadress.getText();
        int num = Integer.parseInt(unum.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to update data in the database
            String query = "UPDATE admin SET name='" + name + "', adress='" + adress + "', num=" + num + " WHERE id=" + id;
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
