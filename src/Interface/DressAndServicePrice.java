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
public class DressAndServicePrice {
    private String dress;
    private String service;
    private int price;

    public DressAndServicePrice() {
    }

    public DressAndServicePrice(String dress, String service, int price) {
        this.dress = dress;
        this.service = service;
        this.price = price;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public String getDress() {
        return dress;
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
    
    
    
    
    
    
    
    
}
