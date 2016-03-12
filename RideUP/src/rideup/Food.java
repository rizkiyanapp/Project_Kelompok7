/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rideup;

/**
 *
 * @author NANON
 */
public class Food {
    private String idFood;
    private String name;
    private long price;

    public Food(String idFood, String name, long price) {
        this.idFood = idFood;
        this.name = name;
        this.price = price;
    }

    public String getIdFood() {
        return idFood;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
