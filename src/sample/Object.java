package sample;

public class Object {
    private int property_id;
    private String Type_posting;
    private String Type_object;
    private String Price;
    private String Address;
    private String Square;
    private String Number_rooms;
    public Object(int property_id, String typePosting, String typeObject, String Price, String Address, String square, String numberRooms) {
        this.property_id = property_id;
        this.Type_posting = typePosting;
        this.Type_object = typeObject;
        this.Price = Price;
        this.Address = Address;
        this.Square = square;
        this.Number_rooms = numberRooms;
    }
    public Object(int report_id, String sale_date, String report_date, String type_object, String price, String address, String square, String number_rooms, String condition) {
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        this.Address = address;
    }
    public String getType_posting() {
        return Type_posting;
    }
    public void setTypePosting(String typePosting) {
        this.Type_posting = typePosting;
    }
    public String getType_object() {
        return Type_object;
    }
    public void setTypeObject(String typeObject) {
        this.Type_object = typeObject;
    }
    public String getSquare() {
        return Square;
    }
    public void setSquare(String square) {
        this.Square = square;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        this.Price = price;
    }
    public String getNumber_rooms() {
        return Number_rooms;
    }
    public void setNumber_rooms(String numberRooms) {
        this.Number_rooms = numberRooms;
    }
    public int getProperty_id() {
        return property_id;
    }
    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }
}