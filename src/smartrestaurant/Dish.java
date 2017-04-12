/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartrestaurant;

/**
 *
 * @author jesusgaitan
 */
public class Dish {
    String name, pic, dsc, price;
    
    public Dish(String name, String dsc, String pic, String price){
        this.name = name;
        this.pic = pic;
        this.dsc = dsc;
        this.price = price;
    }
    
    public Dish(){
        name = "";
        dsc = "";
        pic = "";
        price = "0.0";
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.dsc;
    }
    
    public String getPicture(){
        return pic;
    }
    
    public String getPrice(){
        return price;
    }
}
