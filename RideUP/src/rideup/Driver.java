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
    private final String idDriver;
    private int nOrder = 0; 
    static int nDriver= 0;
    private String username;
    private String password;

    public Driver(String username, String password, String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);
        this.idDriver = "DRV-" + nDriver;
        this.username = username;
        this.password = password;
        nDriver++;
    }
    
    public Driver(String username, String password, String name, String email, String number, String noIdentity) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
        this.idDriver = "DRV-" + nDriver;
        this.username = username;
        this.password = password;
        nDriver++;
    }
    
    public Driver(String username, String password, String name, String email, String number, String noIdentity, char gender) {
        setName(name);
        setEmail(email);
        setNumber(number);       
        setNoIdentity(noIdentity);
        setGender(gender);
        this.idDriver = "DRV-" + nDriver;
        this.username = username;
        this.password = password;
        nDriver++;
    }
    
    public void addOrder(Order o) {
        if (nOrder<10) {
            o.setStatus(true);
            orders[nOrder++] = o;
        }
        else System.out.println("Slot is Full!");
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
