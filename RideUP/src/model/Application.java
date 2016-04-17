/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.FileDatabase;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NANON
 */
public class Application {

    public long rideupPrice = 2500;
    private ArrayList<Person> list;
    private ArrayList<Food> foodList;
    private ArrayList<Integer> iteratorList;
    private FileDatabase database1;
    private FileDatabase database2;
    private FileDatabase database3;

    public Application() {
        list = new ArrayList();
        foodList = new ArrayList();
        database1 = new FileDatabase();
        database2 = new FileDatabase();
        database3 = new FileDatabase();
        iteratorList = new ArrayList();
    }

    public void saveIterator() {
        if (iteratorList.isEmpty()) {
            iteratorList.add(Customer.nCustomer);
            iteratorList.add(Driver.nDriver);
            iteratorList.add(Order.nOrder);
            iteratorList.add(Courier.nCourier);
            iteratorList.add(FoodCourier.nFoodCourier);
            iteratorList.add(Food.nFood);
        } else {
            iteratorList.set(0, Customer.nCustomer);
            iteratorList.set(1, Driver.nDriver);
            iteratorList.set(2, Order.nOrder);
            iteratorList.set(3, Courier.nCourier);
            iteratorList.set(4, FoodCourier.nFoodCourier);
            iteratorList.set(5, Food.nFood);
        }
    }

    public void loadIterator() {
        Customer.setnCustomer(iteratorList.get(0));
        Driver.setnDriver(iteratorList.get(1));
        Order.setnOrder(iteratorList.get(2));
        Courier.setnCourier(iteratorList.get(3));
        FoodCourier.setnFoodCourier(iteratorList.get(4));
        Food.setnFood(iteratorList.get(5));
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

    public void deletePerson(Person p) {
        list.remove(p);
    }

    public Person searchPerson(String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return list.get(i);
            }
        }
        return null;
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
                for (int j = 0; j < temp.getNOrder(); j++) {
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
                for (int j = 0; j < temp.getNOrder(); j++) {
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

    public void loadDataAccount() throws FileNotFoundException, IOException {
        try {
            list = (ArrayList<Person>) database1.getObject("rideup.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("rideup.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            list = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error : " + ex.getMessage());
        }
    }

    public void saveDataAccount() throws FileNotFoundException, IOException {
        try {
            database1.saveObject(list, "rideup.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File not found!");
        } catch (IOException ex) {
            throw new IOException("Error : " + ex.getMessage());
        }
    }

    public void loadDataIterator() throws FileNotFoundException, IOException {
        try {
            iteratorList = (ArrayList<Integer>) database2.getObject("iterator.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("iterator.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            iteratorList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error : " + ex.getMessage());
        }
    }

    public void saveDataIterator() throws FileNotFoundException, IOException {
        try {
            database2.saveObject(iteratorList, "iterator.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File not found!");
        } catch (IOException ex) {
            throw new IOException("Error : " + ex.getMessage());
        }
    }

    public void loadDataFood() throws FileNotFoundException, IOException {
        try {
            foodList = (ArrayList<Food>) database3.getObject("foodlist.dat");
        } catch (FileNotFoundException ex) {
            createFoodList();
            File f = new File("foodlist.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            foodList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error : " + ex.getMessage());
        }
    }

    public void saveDataFood() throws FileNotFoundException, IOException {
        try {
            database3.saveObject(foodList, "foodlist.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File not found!");
        } catch (IOException ex) {
            throw new IOException("Error : " + ex.getMessage());
        }
    }

    public void saveAll() {
        try {
            saveIterator();
            saveDataFood();
            saveDataIterator();
            saveDataAccount();
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error while saving data!");
        }
    }

    public void loadAll() {
        try {
            loadDataFood();
            loadDataIterator();
            loadDataAccount();
            loadIterator();
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error while loading data!");
        }
    }

    public String[] getListAcc() {
        ArrayList<String> listAcc = new ArrayList();
        for (Person p : list) {
            listAcc.add(p.getUsername());
        }
        return (String[]) listAcc.toArray(new String[list.size()]);
    }

    public String[] getListOrderCustomer() {
        ArrayList<String> listOrder = new ArrayList();
        int iterator = 0;
        for (Person p : list) {
            if (p instanceof Customer) {
                Customer temp = (Customer) p;
                for (Order o : temp.getOrderList()) {
                    if (o instanceof Courier) {
                        Courier c = (Courier) o;
                        listOrder.add(c.getId());
                    } else if (o instanceof FoodCourier) {
                        FoodCourier fc = (FoodCourier) o;
                        listOrder.add(fc.getId());
                    } else {
                        listOrder.add(o.getId());
                    }
                    iterator++;
                }
            }
        }
        return (String[]) listOrder.toArray(new String[iterator]);
    }

    public String[] getListOrderDriver() {
        ArrayList<String> listOrder = new ArrayList();
        int iterator = 0;
        for (Person p : list) {
            if (p instanceof Driver) {
                Driver temp = (Driver) p;
                for (Order o : temp.getOrderList()) {
                    if (o instanceof Courier) {
                        Courier c = (Courier) o;
                        listOrder.add(c.getId());
                    } else if (o instanceof FoodCourier) {
                        FoodCourier fc = (FoodCourier) o;
                        listOrder.add(fc.getId());
                    } else {
                        listOrder.add(o.getId());
                    }
                    iterator++;
                }
            }
        }
        return (String[]) listOrder.toArray(new String[iterator]);
    }
}
