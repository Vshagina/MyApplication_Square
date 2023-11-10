package sample.Administrator;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Authorization;
import sample.DataBaseHandler;
import sample.Realtor;

public class AdminWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> Type_object;

    @FXML
    private Label account;

    @FXML
    private TableColumn<?, ?> address;



    @FXML
    private Tab clients;

    @FXML
    private Button exit;

    @FXML
    private Button gen_ob;



    @FXML
    private ImageView image;



    @FXML
    private TextField name_ad;


    @FXML
    private TableColumn<?, ?> number;



    @FXML
    private TableColumn<?, ?> number_rooms;

    @FXML
    private Tab object;



    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private Tab realtor;

    @FXML
    private Tab reports;

    @FXML
    private TableColumn<?, ?> square;

    @FXML
    private TextField surname_ad;



    @FXML
    private TableView<?> table_clients;

    @FXML
    private TableView<?> table_object;


    @FXML
    private TableView<?> table_reports;

    @FXML
    private ComboBox<?> type_object;

    @FXML
    private ComboBox<?> type_object1;

    @FXML
    private ComboBox<?> type_po;

    @FXML
    private ComboBox<?> type_po1;

    @FXML
    private TableColumn<?, ?> type_posting;

    @FXML
    private Button viewing_clients;

    @FXML
    private Button viewing_general;

    @FXML
    private Button viewing_object;
    @FXML
    private Button viewing_reports;





    @FXML
    private TableView<Realtor> table_realtors;
    @FXML
    private Button viewing_realtor;
    @FXML
    private TableColumn<Realtor, Enum> gender_real;
    @FXML
    private TableColumn<Realtor, String> email_real;
    @FXML
    private TableColumn<Realtor, String> password_real;
    @FXML
    private TableColumn<Realtor, String> surname_real;
    @FXML
    private TableColumn<Realtor, String> address_real;
    @FXML
    private TableColumn<Realtor, Integer> age_real;
    @FXML
    private TableColumn<Realtor, String> phone_real;
    @FXML
    private TableColumn<Realtor, String> name_real;
    @FXML
    private TableColumn<Realtor, String> login_real;
    @FXML
    private TableColumn<Realtor, Integer> number2;
    @FXML
    private Stage primaryStage;

    @FXML
    void initialize() {
        exit.setOnAction(event -> returnAuthorization(event));
        viewing_realtor.setOnAction(event -> viewingRealtors());

        number2.setCellValueFactory(new PropertyValueFactory<>("realtor_id"));
        name_real.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname_real.setCellValueFactory(new PropertyValueFactory<>("surname"));
        age_real.setCellValueFactory(new PropertyValueFactory<>("age"));
        address_real.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone_real.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email_real.setCellValueFactory(new PropertyValueFactory<>("email"));
        login_real.setCellValueFactory(new PropertyValueFactory<>("login"));
        password_real.setCellValueFactory(new PropertyValueFactory<>("password"));
        gender_real.setCellValueFactory(new PropertyValueFactory<>("gender"));


    }
    private void returnAuthorization(ActionEvent event) {
        primaryStage = (Stage) exit.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Authorization.fxml"));
            Parent root = loader.load();
            Authorization controller = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void viewingRealtors() {

        // Выполните SQL-запрос для получения данных из таблицы realtors
        String query = "SELECT * FROM realtors";  // Здесь может потребоваться дополнительный ORDER BY, если вы хотите упорядочить результаты

        try {
            // Получите соединение с базой данных
            Connection connection = new DataBaseHandler().getDbConnection();

            // Выполните SQL-запрос
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Создайте объекты модели и добавьте их в таблицу
            while (resultSet.next()) {
                int realtor_id = resultSet.getInt("realtor_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");

                // Создайте объект риэлтора (ваша модель данных)
                Realtor realtor = new Realtor(realtor_id, name, surname, age, address, phone, email, login, password, gender);

                // Добавьте риэлтора в таблицу
                table_realtors.getItems().add(realtor);
            }

            // Закройте соединение с базой данных
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
