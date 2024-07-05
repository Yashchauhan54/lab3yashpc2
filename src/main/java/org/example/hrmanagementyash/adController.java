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

public class adController implements Initializable {

    public TableView<admin> admintable;
    public TableColumn<admin,Integer> adminId;
    public TableColumn<admin, String> adminName;
    public TableColumn<admin, String> email;
    public TableColumn<admin, String> password;
    public Label welcomeText;
    public TextField eid;
    public TextField ename;
    public TextField eem;
    public TextField epd;
    public Button btt;


    ObservableList<admin> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminId.setCellValueFactory(new
                PropertyValueFactory<admin, Integer>("adminId"));
        adminName.setCellValueFactory(new
                PropertyValueFactory<admin, String>("adminName"));
        email.setCellValueFactory(new
                PropertyValueFactory<admin, String>("email"));
        password.setCellValueFactory(new
                PropertyValueFactory<admin, String>("password"));
        admintable.setItems(list);
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
            String query = "SELECT * FROM admin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int adminId = resultSet.getInt("adminId");
                String adminName = resultSet.getString("adminName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                admintable.getItems().add(new admin(adminId,adminName, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(ActionEvent actionEvent) {
        String adminName = ename.getText();
        String email = eem.getText();
        String password = epd.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `admin`( `adminName`, `email`, `password`) VALUES ('"+adminName+"','"+email+"','"+password+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();



        }


    }

    public void update(ActionEvent actionEvent) {
        String adminId = eid.getText();
        String adminName = ename.getText();
        String email = eem.getText();
        String password = epd.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `admin` SET `adminName`='"+adminName+"',`email`='"+email+"',`password`='"+password+"' WHERE adminId='"+adminId+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(ActionEvent actionEvent) {
        String adminId = eid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `admin` WHERE adminId='"+adminId+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loaddata(ActionEvent actionEvent) {
        String adminId = eid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admin WHERE adminId='" + adminId + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String adminName = resultSet.getString("adminName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                ename.setText(adminName);
                eem.setText(email);
                epd.setText(password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void back(ActionEvent actionEvent) {

        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            Stage secondStage = new Stage();

            secondStage.setTitle("User Scene");

            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) btt.getScene().getWindow();
            firstSceneStage.close();

            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
