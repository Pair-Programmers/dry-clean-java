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
public class OrderInfoArrayList {
    ArrayList<OrderInfo> orderInfoArrayList;

    public OrderInfoArrayList () {
        orderInfoArrayList = new ArrayList<>();
    }
    
    public void addOrderInfo(OrderInfo orderInfo){
        orderInfoArrayList.add(orderInfo);
    }
    
    public ArrayList<OrderInfo> getList() {
        return orderInfoArrayList;
    }
}
