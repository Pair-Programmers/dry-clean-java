/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;

/**
 *
 * @author Mian Hamza Saqib
 */
public class CustomerArrayList {
    ArrayList<Customer> customerArrayList;

    public CustomerArrayList () {
        customerArrayList = new ArrayList<>();
    }
    
    public void addOrderInfo(Customer customer){
        customerArrayList.add(customer);
    }
    
    public ArrayList<Customer> getList() {
        return customerArrayList;
    }
}
