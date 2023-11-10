package sample;
public class Client {
    private int client_id;
    private String Name;
    private String Surname;
    private int Age;
    private String Address;
    private String Phone;
    private String Email;
    private String Login;
    private String Password;
    private String Gender;
    public Client(int client_id, String name, String surname, int age, String address, String phone, String email, String login, String password, String gender) {
        this.client_id = client_id;
        Name = name;
        Surname = surname;
        Age = age;
        Address = address;
        Phone = phone;
        Email = email;
        Login = login;
        Password = password;
        Gender = gender;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public String getLogin() {
        return Login;
    }
    public void setLogin(String login) {
        Login = login;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public int getClient_id() {
        return client_id;
    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
