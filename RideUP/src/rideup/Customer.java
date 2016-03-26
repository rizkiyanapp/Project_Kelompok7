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
public class Customer extends Person {
    private ArrayList<Order> orderList = new ArrayList();
    private final String idCustomer;
    static int nCustomer = 0;
    
    public Customer(String username, String password, String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setUsername(username);
        setPassword(password);
        this.idCustomer = "CUS-" + nCustomer;
        nCustomer++;
    }
    
    public Customer(String username, String password, String name, String email, String number, String noIdentity) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        setUsername(username);
        setPassword(password);
        this.idCustomer = "CUS-" + nCustomer;
        nCustomer++;
    }
    
    public Customer(String username, String password, String name, String email, String number, String noIdentity, char gender) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        setGender(gender);
        setUsername(username);
        setPassword(password);
        this.idCustomer = "CUS-" + nCustomer;
        nCustomer++;
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
                orderId = orderId + Order.nOrder;
                Order baru = new Order(orderId, position, destination, distance, detail);
                orderList.add(baru);
            }
            else if(type == 2) {
                courierId += Courier.nCourier;
                Courier baru = new Courier(courierId, position, destination, distance, detail);
                orderList.add(baru);
            }
            else if(type == 3) {
                foodCourierId += FoodCourier.nFoodCourier;
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

    public int getnOrder() {
        return orderList.size();
    }
}
