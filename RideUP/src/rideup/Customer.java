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
public class Customer extends Person {
    private Order[] orders = new Order[10];
    private String idCustomer;
    private int nOrder = 0;
    
    public Customer(String idCustomer, String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);
        this.idCustomer = idCustomer;
    }
    
    public Customer(String idCustomer, String name, String email, String number, String noIdentity) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        this.idCustomer = idCustomer;
    }
    
    public Customer(String idCustomer, String name, String email, String number, String noIdentity, char gender) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        setGender(gender);
        this.idCustomer = idCustomer;
    }

    public void createOrder(int type, String orderId, String position, String destination, int distance, String detail) {
//        String orderId = "O";
//        String courierId = "BC";
//        String foodCourierId = "F";
        
        if(nOrder > 10) {
            System.out.println("Slot is Full!");
        }
        else {
            if(type == 1) {
//                orderId = orderId + idCounter;
                Order baru = new Order(type, orderId, position, destination, distance, detail);
                orders[nOrder++] = baru;
            }
            else if(type == 2) {
//                courierId += idCounter;
                Courier baru = new Courier(type, orderId, position, destination, distance, detail);
                orders[nOrder++] = baru;
            }
            else if(type == 3) {
//                foodCourierId += idCounter;
                FoodCourier baru = new FoodCourier(type, orderId, position, destination, distance, detail);
                orders[nOrder++] = baru;
            }
        }
    }
    
    public void removeOrder(String orderId) {
        int i = 0;
        int j = 0;
        
        while(orders[i] != null) {
            if(orders[i].getId() == orderId) {
                orders[i] = null;
                j = i;
            }
            else {
                i++;
            }
        }
        for(int k = j + 1; k < 11; k++) {
            orders[j] = orders[k];
            j++;
        }
    }
    
    public Order getOrders(int index) {
        return orders[index];
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public int getnOrder() {
        return nOrder;
    }

//    public void setIdCustomer(String idCustomer) {
//        this.idCustomer = idCustomer;
//    }
    
}
