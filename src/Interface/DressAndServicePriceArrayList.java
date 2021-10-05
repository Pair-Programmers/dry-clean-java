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
public class DressAndServicePriceArrayList {
    ArrayList<DressAndServicePrice> dressAndServicePricesArrayList;

    public DressAndServicePriceArrayList () {
        dressAndServicePricesArrayList = new ArrayList<>();
    }
    
    public void addDressAndServicePrivce(DressAndServicePrice dressAndServicePrice){
        dressAndServicePricesArrayList.add(dressAndServicePrice);
    }
    
    public ArrayList<DressAndServicePrice> getList() {
        return dressAndServicePricesArrayList;
    }
}
