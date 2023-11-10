package sample;

public class Deal {
    private int deal_id;
    private String Type_posting;
    private String Type_object;
    private String Price;
    private String Address;
    private String Square;
    private String Number_rooms;
    private String Owner;
    private String Phone_owner;
    public Deal(int deal_id, String typePosting, String typeObject, String Price, String Address, String square, String numberRooms,String owner,String phoneOwner) {
        this.deal_id = deal_id;
        this.Type_posting = typePosting;
        this.Type_object = typeObject;
        this.Price = Price;
        this.Address = Address;
        this.Square = square;
        this.Number_rooms = numberRooms;
        this.Owner = owner;
        this.Phone_owner = phoneOwner;
    }
    public int getDeal_id() {
        return deal_id;
    }
    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }
    public String getType_posting() {
        return Type_posting;
    }
    public void setType_posting(String type_posting) {
        Type_posting = type_posting;
    }
    public String getType_object() {
        return Type_object;
    }
    public void setType_object(String type_object) {
        Type_object = type_object;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        Price = price;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getSquare() {
        return Square;
    }
    public void setSquare(String square) {
        Square = square;
    }
    public String getNumber_rooms() {
        return Number_rooms;
    }
    public void setNumber_rooms(String number_rooms) {
        Number_rooms = number_rooms;
    }
    public String getOwner() {
        return Owner;
    }
    public void setOwner(String owner) {
        Owner = owner;
    }
    public String getPhone_owner() {
        return Phone_owner;
    }
    public void setPhone_owner(String phone_owner) {
        Phone_owner = phone_owner;
    }
}
