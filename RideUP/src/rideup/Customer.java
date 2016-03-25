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
    private final String idCustomer;
    private int nOrder = 0;
    static int nCustomer = 0;
    private String username;
    private String password;
    
    public Customer(String username, String password, String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);
        this.idCustomer = "CUS-" + nCustomer;
        this.username = username;
        this.password = password;
        nCustomer++;
    }
    
    public Customer(String username, String password, String name, String email, String number, String noIdentity) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        this.idCustomer = "CUS-" + nCustomer;
        this.username = username;
        this.password = password;
        nCustomer++;
    }
    
    public Customer(String username, String password, String name, String email, String number, String noIdentity, char gender) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setNoIdentity(noIdentity);
        setGender(gender);
        this.idCustomer = "CUS-" + nCustomer;
        this.username = username;
        this.password = password;
        nCustomer++;
    }

    public void createOrder(int type, String position, String destination, int distance, String detail) {
        String orderId = "ORD-";
        String courierId = "BCO-";
        String foodCourierId = "FCO-";
        
        if(nOrder > 10) {
            System.out.println("Slot is Full!");
        }
        else {
            if(type == 1) {
                orderId = orderId + Order.nOrder;
                Order baru = new Order(orderId, position, destination, distance, detail);
                orders[nOrder++] = baru;
            }
            else if(type == 2) {
                courierId += Courier.nCourier;
                Courier baru = new Courier(courierId, position, destination, distance, detail);
                orders[nOrder++] = baru;
            }
            else if(type == 3) {
                foodCourierId += FoodCourier.nFoodCourier;
                FoodCourier baru = new FoodCourier(foodCourierId, position, destination, distance, detail);
                orders[nOrder++] = baru;
            }
            else {
                System.out.println("Wrong type!");
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
}
