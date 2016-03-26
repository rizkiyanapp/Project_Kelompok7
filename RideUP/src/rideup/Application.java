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

    public long rideupPrice = 2500;
    private ArrayList<Person> list;
    private ArrayList<Food> foodList;

    public Application() {
        list = new ArrayList();
        foodList = new ArrayList();
    }

    public void createFoodList() {
        foodList.add(new Food("Ayam Pedas Udin", 14000));
        foodList.add(new Food("Roti Bakar Asep", 10000));
        foodList.add(new Food("Pisang Goreng Mamat", 11000));
        foodList.add(new Food("Pancong Balap", 8000));
        foodList.add(new Food("Chicken Katsu Afro", 15000));
        foodList.add(new Food("Nasi Pecel Mbakyu", 15000));
        foodList.add(new Food("Jus Kliningan", 12000));
        foodList.add(new Food("Susu Murni Julia", 12000));
        foodList.add(new Food("Cet Time Kopo", 15000));
        foodList.add(new Food("Teh Asoy Geboy", 8000));
    }

    public void addCustomer(String username, String password, String name, String email, String number) {
        list.add(new Customer(username, password, name, email, number));
    }

    public void addDriver(String username, String password, String name, String email, String number) {
        list.add(new Driver(username, password, name, email, number));
    }

    public void deleteCustomer(String username) {
        Person temp = searchCustomer(username);
        if (temp != null) {
            list.remove(temp);
        }
    }

    public void deleteDriver(String username) {
        Person temp = searchDriver(username);
        if (temp != null) {
            list.remove(temp);
        }
    }

    public Customer searchCustomer(String username) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) instanceof Customer) && (list.get(i).getUsername().equals(username))) {
                Customer temp = (Customer) list.get(i);
                return temp;
            }
        }
        return null;
    }

    public Driver searchDriver(String username) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) instanceof Driver) && (list.get(i).getUsername().equals(username))) {
                Driver temp = (Driver) list.get(i);
                return temp;
            }
        }
        return null;
    }

    public Order searchOrderCustomer(String orderId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Customer) {
                Customer temp = (Customer) list.get(i);
                for (int j = 0; j < 10; j++) {
                    if (temp.getOrders(j).getId().equals(orderId)) {
                        return temp.getOrders(j);
                    }
                }
            }
        }
        return null;
    }

    public Order searchOrderDriver(String orderId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Driver) {
                Driver temp = (Driver) list.get(i);
                for (int j = 0; j < 10; j++) {
                    if (temp.getOrders(j).getId().equals(orderId)) {
                        return temp.getOrders(j);
                    }
                }
            }
        }
        return null;
    }

    public Food searchFood(String foodId) {
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getIdFood().equals(foodId)) {
                return foodList.get(i);
            }
        }
        return null;
    }

    public Driver searchDriverByOrder(Order order) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Driver) {
                Driver temp = (Driver) list.get(i);
                for (int j = 0; j < temp.getNOrder(); j++) {
                    if (temp.getOrders(j).equals(order)) {
                        return temp;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }
}
