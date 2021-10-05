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
public class OrderInfo {
    private int id;
    private String dressName;
    private String service;
    private int price;
    private int quantity;
    private int totalPrice;
    private String readyBy;
    private String time;
    private String issues;
    private String workingStatus;

    public OrderInfo() {
    }

    public OrderInfo(int id, String dressName, String service, int price, int quantity, int totalPrice) {
        this.id = id;
        this.dressName = dressName;
        this.service = service;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public OrderInfo(int id, String dressName, String service, int price, int quantity, int totalPrice, String readyBy, String time, String issues, String workingStatus) {
        this.id = id;
        this.dressName = dressName;
        this.service = service;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.readyBy = readyBy;
        this.time = time;
        this.issues = issues;
        this.workingStatus = workingStatus;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
    }

    public String getDressName() {
        return dressName;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setReadyBy(String readyBy) {
        this.readyBy = readyBy;
    }

    public String getReadyBy() {
        return readyBy;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public String getIssues() {
        return issues;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }
    
    
    
}
