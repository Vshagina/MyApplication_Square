package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class ClientWindowController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label account;
    @FXML
    private Tab deal;
    @FXML
    private Button exit;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private Tab selection_object;
    @FXML
    private ComboBox<String> type_posting_deal;
    @FXML
    private ComboBox<String> type_object_deal;
    @FXML
    private ComboBox<String> price_deal;
    @FXML
    private ComboBox<String> address_deal;
    @FXML
    private ComboBox<String> square_deal;
    @FXML
    private ComboBox<String> number_rooms_deal;
    @FXML
    private Button arrange_deal;
    @FXML
    private TextField owner;
    @FXML
    private TextField phone_owner;
    @FXML
    private TableView<Object> table_object;
    @FXML
    private TableColumn<Object, Integer> number;
    @FXML
    private TableColumn<Object, String> type_posting_t;
    @FXML
    private TableColumn<Object, String> type_object_t;
    @FXML
    private TableColumn<Object, String> price_t;
    @FXML
    private TableColumn<Object, String> address_t;
    @FXML
    private TableColumn<Object, String> square_t;
    @FXML
    private TableColumn<Object, String> number_rooms_t;
    @FXML
    private ComboBox<String> type_posting;
    @FXML
    private ComboBox<String> type_object;
    @FXML
    private ComboBox<String> price_obj;
    @FXML
    private ComboBox<String> address;
    @FXML
    private ComboBox<String> square_obj;
    @FXML
    private ComboBox<String> number_rooms;
    @FXML
    private Button find;
    @FXML
    private Stage primaryStage;
    @FXML
    void initialize() {
        type_posting.getItems().addAll("Аренда", "Продажа");
        type_object.getItems().addAll("Квартира", "Дом", "Земельный участок","Комната");
        price_obj.getItems().addAll("10000", "700000", "1000000", "3000000");
        address.getItems().addAll("Пенза", "Пензенская обл");
        square_obj.getItems().addAll("40", "50", "80", "90", "100", "150");
        number_rooms.getItems().addAll("1", "2","3","4","5","6","7");
        type_posting_deal.getItems().addAll("Аренда", "Продажа");
        type_object_deal.getItems().addAll("Квартира", "Дом", "Земельный участок","Комната");
        price_deal.getItems().addAll("10000", "700000", "1000000", "3000000");
        address_deal.getItems().addAll("Пенза", "Пензенская обл");
        square_deal.getItems().addAll("40", "50", "80", "90", "100", "150");
        number_rooms_deal.getItems().addAll("1", "2","3","4","5","6","7");
        number.setCellValueFactory(new PropertyValueFactory<>("property_id"));
        type_posting_t.setCellValueFactory(new PropertyValueFactory<>("Type_posting"));
        type_object_t.setCellValueFactory(new PropertyValueFactory<>("Type_object"));
        price_t.setCellValueFactory(new PropertyValueFactory<>("Price"));
        address_t.setCellValueFactory(new PropertyValueFactory<>("Address"));
        square_t.setCellValueFactory(new PropertyValueFactory<>("Square"));
        number_rooms_t.setCellValueFactory(new PropertyValueFactory<>("Number_rooms"));
        find.setOnAction(event -> viewingObject());
        arrange_deal.setOnAction(event -> ButtonAddNewDeal());
        exit.setOnAction(event -> returnAuthorization(event));

    }
    @FXML
    void viewingObject() {
        String Type_posting = type_posting.getValue();
        String Type_object = type_object.getValue();
        String Price = price_obj.getValue();
        String Address = address.getValue();
        String Square = square_obj.getValue();
        String Number_rooms = number_rooms.getValue();
        if (isNullOrEmpty(Type_posting) || isNullOrEmpty(Type_object) || isNullOrEmpty(Price) ||
                isNullOrEmpty(Address) || isNullOrEmpty(Square) || isNullOrEmpty(Number_rooms)) {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Заполните все поля перед выполнением поиска.");
            return;
        }
        String query = "SELECT * FROM real_estate_services.objects_realty WHERE 1=1";
        query += " AND Type_posting = '" + Type_posting + "'";
        query += " AND Type_object = '" + Type_object + "'";
        query += " AND Price = '" + Price + "'";
        query += " AND Address = '" + Address + "'";
        query += " AND Square = '" + Square + "'";
        query += " AND Number_rooms = '" + Number_rooms + "'";
        if (Type_posting != null && !Type_posting.isEmpty()) {
            query += " AND Type_posting = '" + Type_posting + "'";
        }
        if (Type_object != null && !Type_object.isEmpty()) {
            query += " AND Type_object = '" + Type_object + "'";
        }
        if (Price != null && !Price.isEmpty()) {
            query += " AND Price = '" + Price + "'";
        }
        if (Address != null && !Address.isEmpty()) {
            query += " AND Address = '" + Address + "'";
        }
        if (Square != null && !Square.isEmpty()) {
            query += " AND Square = '" + Square + "'";
        }
        if (Number_rooms != null && !Number_rooms.isEmpty()) {
            query += " AND Number_rooms = '" + Number_rooms + "'";
        }
        ArrayList<Object> queryResults = executeQuery(query);
        ObservableList<Object> data = table_object.getItems();
        data.clear();
        data.addAll(queryResults);
        if (queryResults.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Результат поиска");
            alert.setHeaderText(null);
            alert.setContentText("Записи не найдены.");
            alert.showAndWait();
        }
    }
    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    private ArrayList<Object> executeQuery(String query) {
        ArrayList<Object> results = new ArrayList<>();
        try {
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            Connection connection = dataBaseHandler.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int property_id = resultSet.getInt("property_id");
                String Type_posting = resultSet.getString("Type_posting");
                String Type_object = resultSet.getString("Type_object");
                String Price = resultSet.getString("Price");
                String Address = resultSet.getString("Address");
                String Square = resultSet.getString("Square");
                String Number_rooms = resultSet.getString("Number_rooms");
                Object tableObject = new Object(property_id,Type_posting, Type_object, Price, Address, Square, Number_rooms);
                results.add(tableObject);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }
    @FXML
    private void ButtonAddNewDeal() {
        String Type_posting = type_posting_deal.getValue();
        String Type_object = type_object_deal.getValue();
        String Price = price_deal.getValue();
        String Address = address_deal.getValue();
        String Square = square_deal.getValue();
        String Number_rooms = number_rooms_deal.getValue();
        String Owner = owner.getText();
        String Phone_owner = phone_owner.getText();
        if (!isOwnerValid(Owner) || !isPhoneValid(Phone_owner)) {
            showAlert(Alert.AlertType.ERROR, "Некорректные данные", "Пожалуйста, введите корректные данные.");
            return;
        }
        DataBaseHandler dbHandler = new DataBaseHandler();
        boolean registrationSuccessful = dbHandler.signUpDeal(Type_posting, Type_object, Price, Address, Square, Number_rooms,Owner,Phone_owner);
        if (registrationSuccessful) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успешно добавлено");
            alert.setHeaderText(null);
            alert.setContentText("Сделка успешно оформлена!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Проверьте введённые данные.");
            alert.showAndWait();
        }
    }
    private boolean isOwnerValid(String Owner) {
        return Owner.matches("^[а-яА-Яa-zA-Z\\s]*$");
    }
    private boolean isPhoneValid(String Phone_owner) {
        return Phone_owner.matches("^[0-9]*$");

    }
    private void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    private void returnAuthorization(ActionEvent event) {
        primaryStage = (Stage) exit.getScene().getWindow();
        primaryStage.setResizable(false);
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