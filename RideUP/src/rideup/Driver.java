/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rideup;

import java.util.ArrayList;

/**
 *
 * @author Renes
 */
public class Driver extends Person{
    private ArrayList<Order> orderList = new ArrayList();
    private final String idDriver;
    static int nDriver= 0;

    public Driver(String username, String password, String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setUsername(username);
        setPassword(password);
        this.idDriver = "DRV-" + nDriver;
        nDriver++;
    }
    
    public Driver(String username, String password, String name, String email, String number, String noIdentity) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
        setUsername(username);
        setPassword(password);
        this.idDriver = "DRV-" + nDriver;
        nDriver++;
    }
    
    public Driver(String username, String password, String name, String email, String number, String noIdentity, char gender) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
        setGender(gender);
        setUsername(username);
        setPassword(password);
        this.idDriver = "DRV-" + nDriver;
        nDriver++;
    }
    
    public void addOrder(Order o) {
        if (orderList.size() < 10) {
            o.setStatus(true);
            orderList.add(o);
        }
        else System.out.println("Slot is Full!");
    }
    
    public void removeOrder(int index) {
       orderList.remove(index);
    }
    
    public Order getOrders(int index) {
        return orderList.get(index);
    }
    
    public int getNOrder() {
        return orderList.size();
    }
    
    public String getIdDriver() {
        return idDriver;
    }
}
