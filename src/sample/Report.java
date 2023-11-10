package sample;

public class Report {
    private int report_id;
    private String Sale_date;
    private String Report_date;
    private String Type_object;
    private String Address;
    private String Square;
    private String Price;
    private String Number_rooms;
    private String Condition;
    public Report(int report_id,String reportDate, String saleDate, String typeObject, String price, String address, String square, String numberRooms, String condition) {
        this.report_id = report_id;
        this.Report_date = reportDate;
        this.Sale_date = saleDate;
        this.Type_object = typeObject;
        this.Price = price;
        this.Address = address;
        this.Square = square;
        this.Number_rooms = numberRooms;
        this.Condition = condition;
    }
    public int getReport_id() {
        return report_id;
    }
    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }
    public String getSale_date() {
        return Sale_date;
    }
    public void setSale_date(String sale_date) {
        Sale_date = sale_date;
    }
    public String getReport_date() {
        return Report_date;
    }
    public void setReport_date(String report_date) {
        Report_date = report_date;
    }
    public String getType_object() {
        return Type_object;
    }
    public void setType_object(String type_object) {
        Type_object = type_object;
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
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        Price = price;
    }
    public String getNumber_rooms() {
        return Number_rooms;
    }
    public void setNumber_rooms(String number_rooms) {
        Number_rooms = number_rooms;
    }
    public String getCondition() {
        return Condition;
    }
    public void setCondition(String condition) {
        Condition = condition;
    }
}
