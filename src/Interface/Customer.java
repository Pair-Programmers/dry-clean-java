/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DataBaseConnectivity.DataBaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static net.ucanaccess.converters.Functions.string;

/**
 *
 * @author Mian Hamza Saqib
 */
public class Customer {
    private String name;
    private String phone;
    private String adress;
    private String email;
    private int discount;
    private String note;

    public Customer() {
    }

    public Customer(String name, String phone, String adress, String email, int discount, String note) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.discount = discount;
        this.note = note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public String getNote() {
        return note;
    }
    
    public Customer searchCustomer(String phone) {
        Customer customer;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.connectDataBase();
        String query = "SELECT * FROM `customer` WHERE Phone = '"+phone+"'";
        ResultSet rs = dataBaseConnection.runSelectQuery(query);
        try {
            if(rs.next()){
                return new Customer(rs.getString("CName"), rs.getString("Phone"),rs.getString("adress"),rs.getString("email"), (int)rs.getFloat("discount"), rs.getString("note"));
                
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Searching Customer : (" + e.getMessage() + ")");
        }
        return null;
    }
    
    public void clearCustomer() {
        this.name = "";
        this.phone = "";
        this.adress = "";
        this.email = "";
        this.discount = 0;
        this.note = "";
    }
}
