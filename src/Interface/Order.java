/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DataBaseConnectivity.DataBaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Mian Hamza Saqib
 */
public class Order {
    private int orderNumber;
    private String orderDate;
    private String deliverdate;
    private String paymentStatus;
    private int cashRecieved;
    private Customer customer;
    private OrderInfoArrayList orderInfoArrayList;

    public Order() {
        
    }

    
    public Order(int orderNumber, String orderDate, String deliverdate, String paymentStatus, int cashRecieved, Customer customer, OrderInfoArrayList orderInfoArrayList) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.deliverdate = deliverdate;
        this.paymentStatus = paymentStatus;
        this.cashRecieved = cashRecieved;
        this.customer = customer;
        this.orderInfoArrayList = orderInfoArrayList;
    }

    public void setCashRecieved(int cashRecieved) {
        this.cashRecieved = cashRecieved;
    }

    public int getCashRecieved() {
        return cashRecieved;
    }

    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOrderInfoArrayList(OrderInfoArrayList orderInfoArrayList) {
        this.orderInfoArrayList = orderInfoArrayList;
    }

    public OrderInfoArrayList getOrderInfoArrayList() {
        return orderInfoArrayList;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    
    public void setDeliverdate(String deliverdate) {
        this.deliverdate = deliverdate;
    }

    public String getDeliverdate() {
        return deliverdate;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public int getTotalPrice(){
        int tempTotalPrice = 0;
        for (int i = 0; i < orderInfoArrayList.getList().size(); i++) {
            tempTotalPrice = tempTotalPrice + orderInfoArrayList.getList().get(i).getTotalPrice();
        }
        return tempTotalPrice;
    }
    
    public boolean addOrder(Order order, boolean isCustomerAdded) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        //System.err.println(order.getCustomer().getPhone());
        if(!isCustomerAdded) {
            String queryCustomer = "INSERT INTO customer(CName, Phone, adress, email, discount, note) VALUES ('"+order.getCustomer().getName()+"','"+order.getCustomer().getPhone()+"','"+order.getCustomer().getAdress()+"','"+order.getCustomer().getEmail()+"',"+order.getCustomer().getDiscount()+",'"+order.getCustomer().getNote()+"')";
            dataBaseConnection.runExecuteUpdate(queryCustomer);
        }
        String queryOrder = "INSERT INTO `order`(`orderNumber`, customerPhoneNo, `paymentStatus`, `orderDate`, `deliverDate`, cashRecieved) VALUES ("+ order.getOrderNumber()+",'"+order.getCustomer().getPhone()+"','"+order.getPaymentStatus()+"', '"+order.getOrderDate()+"', '0000-00-00', "+order.getCashRecieved()+")";
        dataBaseConnection.runExecuteUpdate(queryOrder);
        
        OrderInfo orderInfo = new OrderInfo();
        String queryOrderInfo;
        
        for (int i = 0; i < order.getOrderInfoArrayList().getList().size(); i++) {
            
            orderInfo = order.getOrderInfoArrayList().getList().get(i);
            queryOrderInfo = "INSERT INTO `orderinfo`(`id`, `orderNumber`, `dressServiceID`, `Issues`, `readyBy`, `time`, `workingStatus`, `qty`) VALUES (null,"+order.getOrderNumber()+",(SELECT `id`FROM `dressandservice` AS ds WHERE ds.dressID = (SELECT `id`FROM `dresses` WHERE dName = '"+orderInfo.getDressName()+"') AND ds.serviceID = (SELECT `id` FROM `services` WHERE sName = '"+orderInfo.getService()+"')),'"+orderInfo.getIssues()+"','"+orderInfo.getReadyBy()+"','"+orderInfo.getTime()+"', 'Clean', "+orderInfo.getQuantity()+")";
            dataBaseConnection.runExecuteUpdate(queryOrderInfo);
        }
        return true;
    }

    public void clearOrderObj() {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.deliverdate = deliverdate;
        this.paymentStatus = paymentStatus;
        this.customer = customer;
        this.orderInfoArrayList = orderInfoArrayList;
    }
    
}
