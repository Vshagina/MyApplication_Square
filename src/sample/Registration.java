package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;
public class Registration {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button admin_reg;
    @FXML
    private Button client_reg;
    @FXML
    private Button exit;
    @FXML
    private ImageView image;
    @FXML
    private Button realtor_reg;
    @FXML
    private Stage primaryStage;
    @FXML
    void initialize() {
        client_reg.setOnAction(this::clientRegistration);
        realtor_reg.setOnAction(this::realtorRegistration);
        exit.setOnAction(event -> returnAuthorization(event)); }
    private void clientRegistration(ActionEvent event) {
        primaryStage = (Stage) client_reg.getScene().getWindow();
        primaryStage.setResizable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/client_register.fxml"));
            Parent root = loader.load();
            ClientRegistrationController controller = loader.getController();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            primaryStage.close(); } catch (IOException e) { e.printStackTrace(); } }
    private void realtorRegistration(ActionEvent event) {
        primaryStage = (Stage) realtor_reg.getScene().getWindow();
        primaryStage.setResizable(false);
        try { FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/realtor_register.fxml"));
            Parent root = loader.load();
            RealtorRegistrationController controller = loader.getController();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            primaryStage.close(); } catch (IOException e) {
            e.printStackTrace(); } }
    private void returnAuthorization(ActionEvent event) {
        primaryStage = (Stage) exit.getScene().getWindow();
        primaryStage.setResizable(false);
        try { FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Authorization.fxml"));
            Parent root = loader.load();
            Authorization controller = loader.getController();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            primaryStage.close(); } catch (IOException e) { e.printStackTrace(); } }}