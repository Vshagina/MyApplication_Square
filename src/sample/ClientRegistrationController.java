package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class ClientRegistrationController {
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
        registration_id.setOnAction(event -> registrationClient());
        exit.setOnAction(event -> returnAuthorization(event));
    }
    private void registrationClient() {
        String name = name_id.getText();
        String surname = surname_id.getText();
        String age = age_id.getText();
        String phone = phone_id.getText();
        String address = address_id.getText();
        String email = email_id.getText();
        String login = login1_id.getText();
        String password = password1_id.getText();
        String gender = genderComboBox.getValue();
        if (!isNameAndSurnameValid(name, surname) || !isAgeAndPhoneValid(age, phone)) {
            showAlert(Alert.AlertType.ERROR, "Некорректные данные", "Пожалуйста, введите корректные данные.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Логин или пароль пустые.");
        }
        DataBaseHandler dbHandler = new DataBaseHandler();
        boolean registrationSuccessful = dbHandler.signUpClient(name, surname, age, address, phone, email, login, password, "Клиент", gender);

        if (registrationSuccessful) {
            openClientWindow();
        }
    }
    private boolean isNameAndSurnameValid(String name, String surname) {
        return name.matches("^[а-яА-Яa-zA-Z]*$") && surname.matches("^[а-яА-Яa-zA-Z]*$");
    }
    private boolean isAgeAndPhoneValid(String age, String phone) {
        return age.matches("^[0-9]*$") && phone.matches("^[0-9]*$");
    }
    private void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    private void openClientWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/client_window.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Authorization.fxml"));
            Parent root = loader.load();
            Authorization controller = loader.getController();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}