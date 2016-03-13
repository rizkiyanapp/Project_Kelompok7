/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rideup;

/**
 *
 * @author Renes
 */
public class Driver extends Person{
    private Order[] orders = new Order[10];
    private String idDriver;
    private int nOrder = 0; 

    public Driver(String idDriver, String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);
        this.idDriver = idDriver;
    }
    
    public Driver(String idDriver, String name, String email, String number, String noIdentity) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
        this.idDriver = idDriver;
    }
    
    public Driver(String idDriver, String name, String email, String number, String noIdentity, char gender) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
        setGender(gender);
        this.idDriver = idDriver;
    }
    
    public void addOrder(Order o) {
        if (nOrder<10) {
            o.setStatus(true);
            orders[nOrder++] = o;
        }
        else System.out.println("Melebihi batas maksimum");
    }
    
    public void removeOrder(int index) {
        orders[index] = null;
    }
    
    public Order getOrders(int index) {
        return orders[index];
    }
    
    public int getNOrder() {
        return nOrder;
    }
    
    public String getIdDriver() {
        return idDriver;
    }
}
