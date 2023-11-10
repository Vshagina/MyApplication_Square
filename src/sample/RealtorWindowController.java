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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class RealtorWindowController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label account;
    @FXML
    private Tab clients;
    @FXML
    private Tab deal;
    @FXML
    private Tab object;
    @FXML
    private Tab reports;
    @FXML
    private Button exit;
 //Объекты
    @FXML
    private TableView<Object> table_object;
    @FXML
    private ComboBox<String> type_pos;
    @FXML
    private ComboBox<String> type_obj;
    @FXML
    private TableColumn<Object, String> number;
    @FXML
    private TableColumn<Object, String> type_posting_obj;
    @FXML
    private TableColumn<Object, String> type_object_obj;
    @FXML
    private TableColumn<Object, String> price_obj;
    @FXML
    private TableColumn<Object, String> address_obj;
    @FXML
    private TableColumn<Object, String> square_obj;
    @FXML
    private TableColumn<Object, String> number_rooms_obj;
    //добавление
    @FXML
    private ComboBox<String> add_address;
    @FXML
    private ComboBox<String> add_condition;
    @FXML
    private ComboBox<String> add_num_room;
    @FXML
    private ComboBox<String> add_price;
    @FXML
    private ComboBox<String> add_square;
    @FXML
    private ComboBox<String> add_type_obj;
    @FXML
    private ComboBox<String> add_type_pos;
    @FXML
    private Button add_obj;
    @FXML
    private Button viewing_object;
    @FXML
    private Button full_list_object;
//Клиенты
    @FXML
    private TableView<Client> table_clients;
    @FXML
    private TableColumn<Client, String> number1;
    @FXML
    private TableColumn<Client, String> name_tab;
    @FXML
    private TableColumn<Client, String> surname_tab;
    @FXML
    private TableColumn<Client, Integer> age_tab;
    @FXML
    private TableColumn<Client, String> address_tab;
    @FXML
    private TableColumn<Client, String> phone_tab;
    @FXML
    private TableColumn<Client, String> email_tab;
    @FXML
    private TableColumn<Client, String> login_tab;
    @FXML
    private TableColumn<Client, String> password_tab;
    @FXML
    private TableColumn<Client, Enum> gender_tab;
    @FXML
    private Button viewing_clients;
 //Сделки
    @FXML
    private TableView<Deal> table_deal;
    @FXML
    private ComboBox<String> type_posting;
    @FXML
    private ComboBox<String> type_object;
    @FXML
    private TableColumn<Deal, Integer> number3;
    @FXML
    private TableColumn<Deal, String> type_posting_deal;
    @FXML
    private TableColumn<Deal, String> type_object_deal;
    @FXML
    private TableColumn<Deal, String> price_deal;
    @FXML
    private TableColumn<Deal, String> address_deal;
    @FXML
    private TableColumn<Deal, String> square_deal;
    @FXML
    private TableColumn<Deal, Integer> number_rooms_deal;
    @FXML
    private TableColumn<Deal, String> owner;
    @FXML
    private TableColumn<Deal, String> phone_owner;
    @FXML
    private Button gen_deal;
    @FXML
    private Button viewing_deal;
//Отчёты
    @FXML
    private TableView<Report> table_reports;
    @FXML
    private ComboBox<String> type_object_r;
    @FXML
    private TableColumn<Report, String> number4;
    @FXML
    private TableColumn<Report, String> report_date_rep;
    @FXML
    private TableColumn<Report, String> date_sale_rep;
    @FXML
    private TableColumn<Report, String> type_object_rep;
    @FXML
    private TableColumn<Report, String> price_rep;
    @FXML
    private TableColumn<Report, String> address_rep;
    @FXML
    private TableColumn<Report, String> square_rep;
    @FXML
    private TableColumn<Report, String> number_rooms_rep;
    @FXML
    private TableColumn<Report, String> condition_rep;
    //добавление
    @FXML
    private TextField add_date_ot;
    @FXML
    private TextField add_date_prod;
    @FXML
    private ComboBox<String> add_type_obj_ot;
    @FXML
    private ComboBox<String> add_price_ot;
    @FXML
    private ComboBox<String> add_address_ot;
    @FXML
    private ComboBox<String> add_square_ot;
    @FXML
    private ComboBox<String> add_num_room_ot;
    @FXML
    private Button add_report;
    @FXML
    private Button viewing_reports;
    @FXML
    private Button full_list_report;
    @FXML
    private Stage primaryStage;
    @FXML
    void initialize() {
        exit.setOnAction(event -> returnAuthorization(event));
//Объекты
        viewing_object.setOnAction(event -> sortingButtonObject());
        add_obj.setOnAction(event -> ButtonAddNewObject());
        full_list_object.setOnAction(event -> viewingObject());
        type_pos.getItems().addAll("Аренда", "Продажа");
        type_obj.getItems().addAll("Квартира", "Дом", "Земельный участок","Комната");
        add_type_pos.getItems().addAll("Аренда", "Продажа");
        add_type_obj.getItems().addAll("Квартира", "Дом", "Земельный участок","Комната");
        add_price.getItems().addAll("10000", "700000", "1000000", "3000000");
        add_address.getItems().addAll("Пенза", "Пензенская обл");
        add_square.getItems().addAll("40", "50", "80", "90", "100", "150");
        add_num_room.getItems().addAll("1", "2","3","4","5","6","7");
        number.setCellValueFactory(new PropertyValueFactory<>("property_id"));
        type_posting_obj.setCellValueFactory(new PropertyValueFactory<>("Type_posting"));
        type_object_obj.setCellValueFactory(new PropertyValueFactory<>("Type_object"));
        price_obj.setCellValueFactory(new PropertyValueFactory<>("Price"));
        address_obj.setCellValueFactory(new PropertyValueFactory<>("Address"));
        square_obj.setCellValueFactory(new PropertyValueFactory<>("Square"));
        number_rooms_obj.setCellValueFactory(new PropertyValueFactory<>("Number_rooms"));
//Клиенты
        viewing_clients.setOnAction(event -> viewingClient());
        number1.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        name_tab.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname_tab.setCellValueFactory(new PropertyValueFactory<>("surname"));
        age_tab.setCellValueFactory(new PropertyValueFactory<>("age"));
        address_tab.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone_tab.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email_tab.setCellValueFactory(new PropertyValueFactory<>("email"));
        login_tab.setCellValueFactory(new PropertyValueFactory<>("login"));
        password_tab.setCellValueFactory(new PropertyValueFactory<>("password"));
        gender_tab.setCellValueFactory(new PropertyValueFactory<>("gender"));

//Сделки
        viewing_deal.setOnAction(event -> sortingButtonDeal());
        gen_deal.setOnAction(event -> viewingDeal());
        type_posting.getItems().addAll("Аренда", "Продажа");
        type_object.getItems().addAll("Квартира", "Дом", "Земельный участок","Комната");
        number3.setCellValueFactory(new PropertyValueFactory<>("deal_id"));
        type_posting_deal.setCellValueFactory(new PropertyValueFactory<>("Type_posting"));
        type_object_deal.setCellValueFactory(new PropertyValueFactory<>("Type_object"));
        price_deal.setCellValueFactory(new PropertyValueFactory<>("Price"));
        address_deal.setCellValueFactory(new PropertyValueFactory<>("Address"));
        square_deal.setCellValueFactory(new PropertyValueFactory<>("Square"));
        number_rooms_deal.setCellValueFactory(new PropertyValueFactory<>("Number_rooms"));
        owner.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        phone_owner.setCellValueFactory(new PropertyValueFactory<>("Phone_owner"));
//Отчёты
        viewing_reports.setOnAction(event -> sortingButtonReport());
        add_report.setOnAction(event -> ButtonAddNewReport());
        full_list_report.setOnAction(event -> viewingReport());
        type_object_r.getItems().addAll("Квартира", "Дом", "Земельный участок","Комната");
        add_type_obj_ot.getItems().addAll("Квартира", "Дом", "Земельный участок","Комната");
        add_price_ot.getItems().addAll("10000", "700000", "1000000", "3000000");
        add_address_ot.getItems().addAll("Пенза", "Пензенская обл");
        add_square_ot.getItems().addAll("40", "50", "80", "90", "100", "150");
        add_num_room_ot.getItems().addAll("1", "2","3","4","5","6","7");
        add_condition.getItems().addAll("Продан", "Арендован");
        number4.setCellValueFactory(new PropertyValueFactory<>("report_id"));
        date_sale_rep.setCellValueFactory(new PropertyValueFactory<>("Sale_date"));
        report_date_rep.setCellValueFactory(new PropertyValueFactory<>("Report_date"));
        type_object_rep.setCellValueFactory(new PropertyValueFactory<>("Type_object"));
        price_rep.setCellValueFactory(new PropertyValueFactory<>("Price"));
        address_rep.setCellValueFactory(new PropertyValueFactory<>("Address"));
        square_rep.setCellValueFactory(new PropertyValueFactory<>("Square"));
        number_rooms_rep.setCellValueFactory(new PropertyValueFactory<>("Number_rooms"));
        condition_rep.setCellValueFactory(new PropertyValueFactory<>("Condition"));
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
    @FXML
    void viewingObject() {
        table_object.getItems().clear();
        String query = "SELECT * FROM objects_realty";
        try {
            Connection connection = new DataBaseHandler().getDbConnection();
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
                Object object = new Object(property_id,Type_posting, Type_object, Price, Address, Square, Number_rooms);
                table_object.getItems().add(object);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void sortingButtonObject() {
        String Type_posting = type_pos.getValue();
        String Type_object = type_obj.getValue();
        if (Type_posting == null || Type_posting.isEmpty() ||
                !type_pos.getItems().contains(Type_posting)) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Type_object == null || Type_object.isEmpty() ||
                !type_obj.getItems().contains(Type_object)) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        String query = "SELECT * FROM real_estate_services.objects_realty WHERE 1=1";
        if (Type_posting != null && !Type_posting.isEmpty()) {
            query += " AND Type_posting = '" + Type_posting + "'";
        }
        if (Type_object != null && !Type_object.isEmpty()) {
            query += " AND Type_object = '" + Type_object + "'";
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
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
    private void ButtonAddNewObject() {
        String Type_posting = add_type_pos.getValue();
        String Type_object = add_type_obj.getValue();
        String Price = add_price.getEditor().getText();
        String Address = add_address.getEditor().getText();
        String Square = add_square.getEditor().getText();
        String Number_rooms = add_num_room.getEditor().getText();
        if (Type_posting == null || Type_posting.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Type_object == null || Type_object.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Price == null || Price.isEmpty() || !Price.matches("\\d+") || Double.parseDouble(Price) <= 0) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Address == null || Address.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Square == null || Square.isEmpty() || !Square.matches("\\d+") || Double.parseDouble(Square) <= 0) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Number_rooms == null || Number_rooms.isEmpty() || !Number_rooms.matches("\\d+") || Integer.parseInt(Number_rooms) <= 0) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        DataBaseHandler dbHandler = new DataBaseHandler();
        boolean registrationSuccessful = dbHandler.addNewObject(Type_posting, Type_object, Price, Address, Square, Number_rooms);
        if (registrationSuccessful) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успешно добавлено");
            alert.setHeaderText(null);
            alert.setContentText("Новый объект недвижимости добавлен");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Проверьте введённые данные.");
            alert.showAndWait();
        }
    }
    @FXML
    void viewingClient() {
        table_clients.getItems().clear();
        String query = "SELECT * FROM clients";
        try {
            Connection connection = new DataBaseHandler().getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int client_id = resultSet.getInt("client_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                Client clients = new Client(client_id, name, surname, age, address, phone, email, login, password, gender);
                table_clients.getItems().add(clients);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void viewingDeal() {
        table_deal.getItems().clear();
        String query = "SELECT * FROM deal";
        try {
            Connection connection = new DataBaseHandler().getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int deal_id = resultSet.getInt("deal_id");
                String Type_posting = resultSet.getString("Type_posting");
                String Type_object = resultSet.getString("Type_object");
                String Price = resultSet.getString("Price");
                String Address = resultSet.getString("Address");
                String Square = resultSet.getString("Square");
                String Number_rooms = resultSet.getString("Number_rooms");
                String Owner = resultSet.getString("Owner");
                String Phone_owner = resultSet.getString("Phone_owner");
                Deal deal = new Deal(deal_id,Type_posting, Type_object, Price, Address, Square, Number_rooms,Owner,Phone_owner);
                table_deal.getItems().add(deal);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void sortingButtonDeal() {
        String Type_posting = type_posting.getValue();
        String Type_object = type_object.getValue();
        if (Type_posting == null || Type_posting.isEmpty() ||
                !type_posting.getItems().contains(Type_posting)) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Type_object == null || Type_object.isEmpty() ||
                !type_object.getItems().contains(Type_object)) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        String query = "SELECT * FROM real_estate_services.deal WHERE 1=1";
        if (Type_posting != null && !Type_posting.isEmpty()) {
            query += " AND Type_posting = '" + Type_posting + "'";
        }
        if (Type_object != null && !Type_object.isEmpty()) {
            query += " AND Type_object = '" + Type_object + "'";
        }
        ArrayList<Deal> queryResults = executeQuery1(query);
        ObservableList<Deal> data = table_deal.getItems();
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
    private ArrayList<Deal> executeQuery1(String query) {
        ArrayList<Deal> results = new ArrayList<>();
        try {
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            Connection connection = dataBaseHandler.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int deal_id = resultSet.getInt("deal_id");
                String Type_posting = resultSet.getString("Type_posting");
                String Type_object = resultSet.getString("Type_object");
                String Price = resultSet.getString("Price");
                String Address = resultSet.getString("Address");
                String Square = resultSet.getString("Square");
                String Number_rooms = resultSet.getString("Number_rooms");
                String Owner = resultSet.getString("Owner");
                String Phone_owner = resultSet.getString("Phone_owner");
                Deal tableDeal = new Deal(deal_id,Type_posting, Type_object, Price, Address, Square, Number_rooms,Owner,Phone_owner);
                results.add(tableDeal);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }
    @FXML
    void viewingReport() {
        table_reports.getItems().clear();
        String query = "SELECT * FROM real_estate_reports";
        try {
            Connection connection = new DataBaseHandler().getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int report_id = resultSet.getInt("report_id");
                String Sale_date = resultSet.getString("Sale_date");
                String Report_date = resultSet.getString("Report_date");
                String Type_object = resultSet.getString("Type_object");
                String Price = resultSet.getString("Price");
                String Address = resultSet.getString("Address");
                String Square = resultSet.getString("Square");
                String Number_rooms = resultSet.getString("Number_rooms");
                String Condition = resultSet.getString("Condition");
                Report report = new Report(report_id,Sale_date,Report_date, Type_object, Price, Address, Square, Number_rooms,Condition);
                table_reports.getItems().add(report);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void sortingButtonReport() {
        String Type_object = type_object_r.getValue();
        if (Type_object == null || Type_object.isEmpty() ||
                !type_object_r.getItems().contains(Type_object)) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        String query = "SELECT * FROM real_estate_services.real_estate_reports WHERE 1=1";
        if (Type_object != null && !Type_object.isEmpty()) {
            query += " AND Type_object = '" + Type_object + "'";
        }
        ArrayList<Report> queryResults = executeQuery2(query);
        ObservableList<Report> data = table_reports.getItems();
        data.clear();
        data.addAll(queryResults);
        if (queryResults.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Результат поиска");
            alert.setHeaderText(null);
            alert.setContentText("Отчёты не найдены.Проверьте данные.");
            alert.showAndWait();
        }
    }
    private ArrayList<Report> executeQuery2(String query) {
        ArrayList<Report> results = new ArrayList<>();
        try {
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            Connection connection = dataBaseHandler.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int report_id = resultSet.getInt("report_id");
                String Sale_date = resultSet.getString("Sale_date");
                String Report_date = resultSet.getString("Report_date");
                String Type_object = resultSet.getString("Type_object");
                String Price = resultSet.getString("Price");
                String Address = resultSet.getString("Address");
                String Square = resultSet.getString("Square");
                String Number_rooms = resultSet.getString("Number_rooms");
                String Condition = resultSet.getString("Condition");
                Report tableReport = new Report(report_id,Sale_date,Report_date, Type_object, Price, Address, Square, Number_rooms,Condition);
                results.add(tableReport);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }
    private void ButtonAddNewReport() {
        String Report_date = add_date_ot.getText();
        String Sale_date = add_date_prod.getText();
        String Type_object = add_type_obj_ot.getValue();
        String Price = add_price_ot.getValue();
        String Address = add_address_ot.getValue();
        String Square = add_square_ot.getValue();
        String Number_rooms = add_num_room_ot.getValue();
        String Condition = add_condition.getValue();
        if (Report_date == null || Report_date.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Sale_date == null || Sale_date.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Type_object == null || Type_object.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        try {
            double parsedPrice = Double.parseDouble(Price);
            if (parsedPrice <= 0) {
                showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
                return;
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Address == null || Address.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        try {
            double parsedSquare = Double.parseDouble(Square);
            if (parsedSquare <= 0) {
                showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
                return;
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        try {
            int parsedNumberRooms = Integer.parseInt(Number_rooms);
            if (parsedNumberRooms <= 0) {
                showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
                return;
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        if (Condition == null || Condition.isEmpty()) {
            showErrorMessage("Что-то пошло не так...проверьте ваш запрос");
            return;
        }
        DataBaseHandler dbHandler = new DataBaseHandler();
        boolean registrationSuccessful = dbHandler.addNewReport(Report_date, Sale_date, Type_object, Price, Address, Square, Number_rooms, Condition);
        if (registrationSuccessful) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успешно добавлено");
            alert.setHeaderText(null);
            alert.setContentText("Отчёт успешно оформлен!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Проверьте введённые данные.");
            alert.showAndWait();
        }
    }
}