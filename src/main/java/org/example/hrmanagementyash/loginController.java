package org.example.hrmanagementyash;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class loginController {

    public PasswordField pd;
    public TextField em;
    public Button lgbutton;
    public Label msg;

    public void loginClick(ActionEvent actionEvent) {
        String iemail= em.getText();

        String ipassword= pd.getText();
        if (iemail.isEmpty()&& ipassword.isEmpty()) {
            msg.setText("Please enter your email or password");
        }
        else{
            String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab3yash";
            String dbUser = "root";
            String dbPassword = "";
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                    dbPassword)) {
                // Execute a SQL query to retrieve data from the database
                String query = "SELECT * FROM admin WHERE email='"+iemail+"'AND password='"+ipassword+"'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    try {


                        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                        Parent secondScene = loader.load();

                        Stage secondStage = new Stage();

                        secondStage.setTitle("User Scene");

                        secondStage.setScene(new Scene(secondScene));

                        // Access the controller of the second scene
                        HelloController HelloController = loader.getController();
                        // Set the data in the controller of the second scene
                        String adminName = resultSet.getString("adminName");
                        HelloController.setData(adminName);



                        Stage firstSceneStage = (Stage) lgbutton.getScene().getWindow();
                        firstSceneStage.close();

                        secondStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    msg.setText("Invalid email or password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }}

