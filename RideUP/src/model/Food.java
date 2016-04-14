/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author NANON
 */
public class Food implements Serializable {
    private final String idFood;
    private String name;
    private long price;
    static int nFood;

    public Food(String name, long price) {
        nFood++;
        this.idFood = "F-0" + nFood;
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

    @Override
    public String toString() {
        return ("ID : " + idFood + "  |  Name : " + name + "  |  Price : " + price);
    }

    public static void setnFood(int nFood) {
        Food.nFood = nFood;
    }
}
