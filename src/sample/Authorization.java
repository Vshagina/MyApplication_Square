package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Authorization {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button enter_id;
    @FXML
    private TextField login_id;
    @FXML
    private TextField password_id;
    @FXML
    private Button register_id;
    @FXML
    private Stage primaryStage;
    @FXML
    private ImageView image;
    @FXML
    void initialize() {
        enter_id.setOnAction(event -> onButtonEnter(event));
        register_id.setOnAction(event -> onRegisterButton(event));
    }
    @FXML
    void onButtonEnter(ActionEvent event) {
        String login = login_id.getText().trim();
        String password = password_id.getText().trim();

        if (!login.isEmpty() && !password.isEmpty()) {
            DataBaseHandler dbHandler = new DataBaseHandler();

            if (dbHandler.getRealtor(login, password)) {
                openRealtorWindow();
            } else if (dbHandler.getClient(login, password)) {
                openClientWindow();
            } else {
                showAlert(Alert.AlertType.ERROR, "Пользователь не найден", "Пожалуйста, зарегистрируйтесь.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Логин или пароль пустые.");
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private void onRegisterButton(ActionEvent event) {
        primaryStage = (Stage) register_id.getScene().getWindow();
        primaryStage.setResizable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Сhoice.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openRealtorWindow() {
        primaryStage = (Stage) enter_id.getScene().getWindow();
        primaryStage.setResizable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/realtor_window.fxml"));
            Parent root = loader.load();
            RealtorWindowController controller = loader.getController();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openClientWindow() {
        primaryStage = (Stage) enter_id.getScene().getWindow();
        primaryStage.setResizable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/client_window.fxml"));
            Parent root = loader.load();
            ClientWindowController controller = loader.getController();
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