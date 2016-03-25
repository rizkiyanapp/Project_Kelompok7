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
        
    }
    
    public Customer searchCustomer(String username) {
        
    }
    
    public Driver searchDriver(String username) {
        
    }
    
    public Order searchOrder(String orderId) {
        
    }
    
    public Food searchFood(String foodId) {
        
    }
}
