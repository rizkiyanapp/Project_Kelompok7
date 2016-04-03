/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rideup;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author NANON
 */
public class Customer extends Person implements Serializable {
    private ArrayList<Order> orderList = new ArrayList();
    private final String idCustomer;
    static int nCustomer;
    
    public Customer(String username, String password, String name, String email, String number) {
        nCustomer++;
        setName(name);
        setEmail(email);
        setNumber(number);
        setUsername(username);
        setPassword(password);
        this.idCustomer = "CUS-" + nCustomer;
    }
    
    public Customer(String username, String password, String name, String email, String number, String noIdentity) {
        nCustomer++;
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        setUsername(username);
        setPassword(password);
        this.idCustomer = "CUS-" + nCustomer;
    }
    
    public Customer(String username, String password, String name, String email, String number, String noIdentity, char gender) {
        nCustomer++;
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        setGender(gender);
        setUsername(username);
        setPassword(password);
        this.idCustomer = "CUS-" + nCustomer;
    }

    public void createOrder(int type, String position, String destination, int distance, String detail) {
        String orderId = "ORD-";
        String courierId = "BCO-";
        String foodCourierId = "FCO-";
        
        if(orderList.size() > 10) {
            System.out.println("Slot is Full!");
        }
        else {
            if(type == 1) {
                orderId = orderId + (Order.nOrder + 1);
                Order baru = new Order(orderId, position, destination, distance, detail);
                orderList.add(baru);
            }
            else if(type == 2) {
                courierId += (Courier.nCourier + 1);
                Courier baru = new Courier(courierId, position, destination, distance, detail);
                orderList.add(baru);
            }
            else if(type == 3) {
                foodCourierId += (FoodCourier.nFoodCourier + 1);
                FoodCourier baru = new FoodCourier(foodCourierId, position, destination, distance, detail);
                orderList.add(baru);
            }
            else {
                System.out.println("Wrong type!");
            }
        }
    }
    
    public void removeOrder(String orderId) {
        for (int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getId().equals(orderId)) {
                orderList.remove(i);
            }
        }
    }
    
    public Order getOrders(int index) {
        return orderList.get(index);
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public int getNOrder() {
        return orderList.size();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return ("Username : " + getUsername() + "\n" + 
                "ID : " + idCustomer + "\n" + 
                "Name : " + getName() + "\n" + 
                "No. Identity : " + getNoIdentity() + "\n" + 
                "Gender : " + getGender() + "\n" + 
                "Age : " + getAge() + " yo \n" + 
                "Address : " + getAddress() + "\n" + 
                "Number : " + getNumber() + "\n" + 
                "Email : " + getEmail());
    }

    public static void setnCustomer(int nCustomer) {
        Customer.nCustomer = nCustomer;
    }
}
