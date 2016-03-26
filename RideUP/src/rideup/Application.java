/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rideup;

import java.util.ArrayList;

/**
 *
 * @author NANON
 */
public class Application {
    ArrayList<Person> list;
    ArrayList<Food> foodList;
    
    public Application() {
        list = new ArrayList();
        foodList = new ArrayList();
    }
    
    public void addCustomer(String username, String password, String name, String email, String number) {
        
    }
    
    public void addDriver(String username, String password, String name, String email, String number) {
        
    }
    
    public void deleteCustomer(String username) {
        
    }
    
    public void deleteDriver(String username) {
       Driver nemu = searchDriver(username);
       list.remove(nemu);
    }
    
    public Customer searchCustomer(String username) {
         for (int i=0; i< list.size(); i++) {
             if ((list.get(i) instanceof Customer) && (list.get(i).getUsername().equals(username))) {
                 Customer cus = (Customer) list.get(i);
                 return cus;
             }
         }
         return null; 
    }
    
    public Driver searchDriver(String username) {
        for (int i=0; i< list.size(); i++) {
             if ((list.get(i) instanceof Driver) && (list.get(i).getUsername().equals(username))) {
                 Driver drive = (Driver) list.get(i);
                 return drive;
             }
         }
         return null; 
    }
    
    public Order searchOrder(String orderId) {
        
    }
    
    public Food searchFood(String foodId) {
        
    }
}
