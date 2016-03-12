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
    private Order[] orders;
    private String idDriver;
    private int nOrder = 0; 

    public Driver(String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);       
    }
    
    public Driver(String name, String email, String number, String noIdentity) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
    }
    
    public Driver(String name, String email, String number, String noIdentity, char gender) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
        setGender(gender);
    }
    
    public void addOrder(Order o) {
        if (nOrder<10) {
            orders[nOrder++] = o;
        }
        else System.out.println("Melebihi batas maksimum");
    }
    
    public void removeOrder(int index) {
        orders[index] = null;
    }
    
    public Order getOrder(int index) {
        return orders[index];
    }
    
    public int getNOrder() {
        return nOrder;
    }
    
    public String getIdDriver() {
        return idDriver;
    }
}
