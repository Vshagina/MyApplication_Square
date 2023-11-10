package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DataBaseHandler extends DataBase {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public boolean signUpClient(String name, String surname, String age, String address, String phone, String email, String login, String password,String role,String gender) {
        String insert = "INSERT INTO " +
                ConstClient.CLIENT_TABLE + "(" +
                ConstClient.CLIENT_NAME + "," +
                ConstClient.CLIENT_SURNAME + "," +
                ConstClient.CLIENT_AGE + "," +
                ConstClient.CLIENT_ADDRESS + "," +
                ConstClient.CLIENT_PHONE + "," +
                ConstClient.CLIENT_EMAIL + "," +
                ConstClient.CLIENT_LOGIN + "," +
                ConstClient.CLIENT_PASSWORD + "," +
                ConstClient.CLIENT_GENDER + ") VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {
            prSt.setString(1, name);
            prSt.setString(2, surname);
            prSt.setString(3, age);
            prSt.setString(4, address);
            prSt.setString(5, phone);
            prSt.setString(6, email);
            prSt.setString(7, login);
            prSt.setString(8, password);
            prSt.setString(9, gender);
            prSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); } catch (ClassNotFoundException e) {
            e.printStackTrace(); }return false; }
    public boolean getClient(String login, String password) {
        String select = "SELECT * FROM " + ConstClient.CLIENT_TABLE + " WHERE " +
                ConstClient.CLIENT_LOGIN + "=? AND " +
                ConstClient.CLIENT_PASSWORD + "=?";
        try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {
            prSt.setString(1, login);
            prSt.setString(2, password);
            ResultSet resultSet = prSt.executeQuery();
            return resultSet.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false; } }
public boolean signUpRealtor(String name, String surname, String age, String address, String phone, String email, String login, String password, String genderSelected) {
    String insert = "INSERT INTO " +
            ConstRealtor.REALTOR_TABLE + "(" +
            ConstRealtor.REALTOR_NAME + "," +
            ConstRealtor.REALTOR_SURNAME + "," +
            ConstRealtor.REALTOR_AGE + "," +
            ConstRealtor.REALTOR_ADDRESS + "," +
            ConstRealtor.REALTOR_PHONE + "," +
            ConstRealtor.REALTOR_EMAIL + "," +
            ConstRealtor.REALTOR_LOGIN + "," +
            ConstRealtor.REALTOR_PASSWORD + "," +
            ConstRealtor.REALTOR_GENDER + ") VALUES(?,?,?,?,?,?,?,?,?)";
    try (PreparedStatement prS = getDbConnection().prepareStatement(insert)) {
        prS.setString(1, name);
        prS.setString(2, surname);
        prS.setString(3, age);
        prS.setString(4, address);
        prS.setString(5, phone);
        prS.setString(6, email);
        prS.setString(7, login);
        prS.setString(8, password);
        prS.setString(9, genderSelected);
        prS.executeUpdate();
        return true;  } catch (SQLException e) {
        e.printStackTrace(); } catch (ClassNotFoundException e) {
        e.printStackTrace(); }return false; }
    public boolean getRealtor(String login, String password) {
        String sel = "SELECT * FROM " + ConstRealtor.REALTOR_TABLE + " WHERE " +
                ConstRealtor.REALTOR_LOGIN + "=? AND " +
                ConstRealtor.REALTOR_PASSWORD + "=?";
        try (PreparedStatement prS = getDbConnection().prepareStatement(sel)) {
            prS.setString(1, login);
            prS.setString(2, password);
            ResultSet resultS = prS.executeQuery();
            return resultS.next(); } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false; } }
    public boolean signUpDeal(String Type_posting, String Type_object, String Price, String Address, String Square, String Number_rooms,String Owner,String Phone_owner) {
        String insert = "INSERT INTO " +
                ConstObject.OBJECT_TABLE + "(" +
                ConstObject.OBJECT_TYPE_POSTING + "," +
                ConstObject.OBJECT_TYPE_OBJECT + "," +
                ConstObject.OBJECT_PRICE + "," +
                ConstObject.OBJECT_ADDRESS + "," +
                ConstObject.OBJECT_SQUARE + "," +
                ConstObject.OBJECT_NUMBER_ROOMS + "," +
                ConstObject.OBJECT_OWNER + "," +
                ConstObject.OBJECT_PHONE_OWNER + ") VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement prS = getDbConnection().prepareStatement(insert)) {
            prS.setString(1, Type_posting);
            prS.setString(2, Type_object);
            prS.setString(3, Price);
            prS.setString(4, Address);
            prS.setString(5, Square);
            prS.setString(6, Number_rooms);
            prS.setString(7, Owner);
            prS.setString(8, Phone_owner);
            prS.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }return false;
    }
    public boolean addNewObject(String Type_posting, String Type_object, String Price, String Address, String Square, String Number_rooms) {
        String insert = "INSERT INTO " +
                ConstAddObject.OBJECT_TABLE + "(" +
                ConstAddObject.OBJECT_TYPE_POSTING + "," +
                ConstAddObject.OBJECT_TYPE_OBJECT + "," +
                ConstAddObject.OBJECT_PRICE + "," +
                ConstAddObject.OBJECT_ADDRESS + "," +
                ConstAddObject.OBJECT_SQUARE + "," +
                ConstAddObject.OBJECT_NUMBER_ROOMS + ") VALUES(?,?,?,?,?,?)";
        try (PreparedStatement prS = getDbConnection().prepareStatement(insert)) {
            prS.setString(1, Type_posting);
            prS.setString(2, Type_object);
            prS.setString(3, Price);
            prS.setString(4, Address);
            prS.setString(5, Square);
            prS.setString(6, Number_rooms);
            prS.executeUpdate();
            return true;
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }return false; }
    public boolean addNewReport(String Report_date, String Sale_date, String Type_object, String Price, String Address, String Square, String Number_rooms, String Condition) {
        String insert = "INSERT INTO " +
                ConstAddReport.REPORT_TABLE + "(" +
                ConstAddReport.REPORT_REPORT_DATE + "," +
                ConstAddReport.REPORT_SALE_DATE + "," +
                ConstAddReport.REPORT_TYPE_OBJECT + "," +
                ConstAddReport.REPORT_PRICE + "," +
                ConstAddReport.REPORT_ADDRESS + "," +
                ConstAddReport.REPORT_SQUARE + "," +
                ConstAddReport.REPORT_NUMBER_ROOMS + "," +
                "`" + ConstAddReport.REPORT_CONDITION + "`) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement prS = getDbConnection().prepareStatement(insert)) {
            prS.setString(1, Report_date);
            prS.setString(2, Sale_date);
            prS.setString(3, Type_object);
            prS.setString(4, Price);
            prS.setString(5, Address);
            prS.setString(6, Square);
            prS.setString(7, Number_rooms);
            prS.setString(8, Condition);
            prS.executeUpdate();
            return true; } catch (SQLException e) {
            e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }return false; }}

