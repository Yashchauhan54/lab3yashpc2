package org.example.hrmanagementyash;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Button employee;
    public Button admin;
    public Button exit;
    public Button logout;
    public Label welcomeText;


    @FXML

    public void employee(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("employee.fxml"));

            Stage secondStage = new Stage();

            secondStage.setTitle("User Scene");

            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) employee.getScene().getWindow();
            firstSceneStage.close();

            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void admin(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("admin.fxml"));

            Stage secondStage = new Stage();

            secondStage.setTitle("User Scene");

            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) admin.getScene().getWindow();
            firstSceneStage.close();

            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void exit(ActionEvent actionEvent) {
        System.exit(0);

    }

    public void logout(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("login-view.fxml"));

            Stage secondStage = new Stage();

            secondStage.setTitle("User Scene");

            secondStage.setScene(new Scene(secondScene));

            Stage firstSceneStage = (Stage) logout.getScene().getWindow();
            firstSceneStage.close();

            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setData(String adminName) {
        welcomeText.setText(adminName);
    }

    public static int salaryperanum(int a) {

        int y = a * 12;
        return y;

    }

}
