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
public class NewClass {
    int id;
        String name;
        String color;
        String company;
        String sizeOfProduct;
        int price;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setSizeOfProduct(String sizeOfProduct) {
        this.sizeOfProduct = sizeOfProduct;
    }

    public String getSizeOfProduct() {
        return sizeOfProduct;
    }
        
}
