/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Mian Hamza Saqib
 */
public class OrderTableListForDelivered {
    private int orderNumber;
    private String customerName;
    private String phone;
    private String items;
    private int noOfdresses;
    private int price;
    private int recieved;
    private int discount;
    private String orderDate;
    private String deliverDate;

    public OrderTableListForDelivered() {
    }

    public OrderTableListForDelivered(int orderNumber, String customerName, String phone, String items, int noOfdresses, int price, int recieved, int discount, String orderDate, String deliverDate) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.items = items;
        this.noOfdresses = noOfdresses;
        this.price = price;
        this.recieved = recieved;
        this.discount = discount;
        this.orderDate = orderDate;
        this.deliverDate = deliverDate;
    }

    

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getItems() {
        return items;
    }

    public void setNoOfdresses(int noOfdresses) {
        this.noOfdresses = noOfdresses;
    }

    public int getNoOfdresses() {
        return noOfdresses;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setRecieved(int recieved) {
        this.recieved = recieved;
    }

    public int getRecieved() {
        return recieved;
    }
    
    
        
}
