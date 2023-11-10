package sample.Administrator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBaseHandler;
import sample.Registration;

public class AdminRegistrationController {
/*
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField address_id;

    @FXML
    private TextField age_id;

    @FXML
    private TextField email_id;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private TextField login1_id;

    @FXML
    private TextField name_id;

    @FXML
    private TextField password1_id;

    @FXML
    private TextField phone_id;

    @FXML
    private Button registration_id;

    @FXML
    private TextField surname_id;

    @FXML
    private Button exit;

    @FXML
    private Stage primaryStage;


    @FXML
    void initialize() {
        genderComboBox.getItems().addAll("Мужской", "Женский");
        registration_id.setOnAction(event -> handleRegistrationButtonAction());
        exit.setOnAction(event -> returnAuthorization(event));
    }

    private void handleRegistrationButtonAction() {

        String name = name_id.getText();
        String surname = surname_id.getText();
        String age = age_id.getText();
        String address = address_id.getText();
        String phone = phone_id.getText();
        String email = email_id.getText();
        String login = login1_id.getText();
        String password = password1_id.getText();
        String gender = genderComboBox.getValue();

        DataBaseHandler dbHandler = new DataBaseHandler();

        boolean registrationSuccessful = dbHandler.signUpAdmin(name, surname, age, address, phone, email, login, password, "Администратор", gender);

        if (registrationSuccessful) {
            openAdminWindow();
        }
    }

    private void openAdminWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Administrator/admin_window.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            registration_id.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void returnAuthorization(ActionEvent event) {
        primaryStage = (Stage) exit.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Сhoice.fxml"));
            Parent root = loader.load();
            Registration controller = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

