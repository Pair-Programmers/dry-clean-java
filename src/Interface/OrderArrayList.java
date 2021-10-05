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
public class OrderArrayList {
    ArrayList<Order> orderArrayList;

    public OrderArrayList () {
        orderArrayList = new ArrayList<>();
    }
    
    public void addOrder(Order order){
        orderArrayList.add(order);
    }
    
    public ArrayList<Order> getList() {
        return orderArrayList;
    }
}
