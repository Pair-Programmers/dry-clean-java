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
public class OrderTableListForClean {
    private int orderNumber;
    private String customerName;
    private String phone;
    private String orderDate;
    private String readyBy;
    private int noOfdresses;
    private int price;
    private String status;
    private String items;
    public OrderTableListForClean() {
    }

    public OrderTableListForClean(int orderNumber, String customerName, String phone, String orderDate, String readyBy, int noOfdresses, int price, String status, String items) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.orderDate = orderDate;
        this.readyBy = readyBy;
        this.noOfdresses = noOfdresses;
        this.price = price;
        this.status = status;
        this.items = items;
    }

    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
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

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setReadyBy(String readyBy) {
        this.readyBy = readyBy;
    }

    public String getReadyBy() {
        return readyBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
   String text = "                SHAFIQUE & SON'S               \n"
                + "                  Dry Cleaners                 \n"
                + "                                               \n"
                + "                                               \n"
                + "Order # : 767787              Date : 20-09-2019\n"
                + "Customer: Hamza Saqib                          \n"
                + "Phone   : 03239991999                        \n\n"
                + "_______________________________________________\n"
                + " NO  | Dresses            | Service    | Price \n"
                + "_______________________________________________\n"
                + " 1   | Coat               | Wash&Press |   400 \n"
                + " 2   | Kameez             | Pres Only  |   150 \n"
                + "                                               \n"
                + "                                               \n"
                + "_______________________________________________\n"
                + "                             Gross Total :  550\n"
                + "Ready By : 23-09-2019        Discount    :   50\n"
                + "Time     : 5 pm               Net Total   :  500\n"
                + "Status   : Not Paid          Recieved    : 1000\n"
                + "                             Balance     :  500\n"
                + "                                           \n\n\n"
                + "            Thank You For Visiting             \n"
                + "           Contact At : 03239991999\n\n\n\n\n\n\n"; 
    
}
