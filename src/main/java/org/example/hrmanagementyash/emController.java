package org.example.hrmanagementyash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class emController implements Initializable {

    public TableView<employee> employeetable;
    public TableColumn<employee,Integer> employeeId;
    public TableColumn<employee, String> employeeName;
    public TableColumn<employee, String> phone;
    public TableColumn<employee, String> salary;
    public Label welcomeText;
    public TextField gid;
    public TextField gname;
    public TextField gphone;
    public TextField gsalary;
    public Button bt;


    ObservableList<employee> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeId.setCellValueFactory(new
                PropertyValueFactory<employee, Integer>("employeeId"));
        employeeName.setCellValueFactory(new
                PropertyValueFactory<employee, String>("employeeName"));
        phone.setCellValueFactory(new
                PropertyValueFactory<employee, String>("phone"));
        salary.setCellValueFactory(new
                PropertyValueFactory<employee, String>("salary"));
        employeetable.setItems(list);
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
        fetchdata();
    }

    private void fetchdata() {
        list.clear();
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employeeId");
                String employeeName = resultSet.getString("employeeName");
                String phone = resultSet.getString("phone");
                String salary = resultSet.getString("salary");
                employeetable.getItems().add(new employee(employeeId,employeeName, phone, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(ActionEvent actionEvent) {
        String employeeName = gname.getText();
        String phone = gphone.getText();
        String salary = gsalary.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `employee`( `employeeName`, `phone`, `salary`) VALUES ('"+employeeName+"','"+phone+"','"+salary+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();



        }


    }

    public void update(ActionEvent actionEvent) {
        String employeeId = gid.getText();
        String employeeName = gname.getText();
        String phone = gphone.getText();
        String salary = gsalary.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `employee` SET `employeeName`='"+employeeName+"',`phone`='"+phone+"',`salary`='"+salary+"' WHERE employeeId='"+employeeId+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(ActionEvent actionEvent) {
        String employeeId = gid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `employee` WHERE employeeId='"+employeeId+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loaddata(ActionEvent actionEvent) {
        String employeeId = gid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM employee WHERE employeeId='" + employeeId + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String employeeName = resultSet.getString("employeeName");
                String phone = resultSet.getString("phone");
                String salary = resultSet.getString("salary");

                gname.setText(employeeName);
                gphone.setText(phone);
                gsalary.setText(salary);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void back(ActionEvent actionEvent) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
        String dbUser = "root";
        String dbPassword = "";
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            Stage secondStage = new Stage();

            secondStage.setTitle("User Scene");

            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) bt.getScene().getWindow();
            firstSceneStage.close();

            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    }
