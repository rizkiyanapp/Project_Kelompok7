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
public class RideUPmethod {
    // PROSEDUR MEMBUAT LIST MAKANAN YANG TERSEDIA
    public void createFoodList(Food[] foodList) {
        Food fo1 = new Food("F001", "Ayam Pedas Udin", 14000);
        foodList[0] = fo1;
        Food fo2 = new Food("F002", "Roti Bakar Asep", 10000);
        foodList[1] = fo2;
        Food fo3 = new Food("F003", "Pisang Goreng Mamat", 11000);
        foodList[2] = fo3;
        Food fo4 = new Food("F004", "Pancong Balap", 8000);
        foodList[3] = fo4;
        Food fo5 = new Food("F005", "Chicken Katsu Afro", 15000);
        foodList[4] = fo5;
        Food fo6 = new Food("F006", "Nasi Pecel Mbakyu", 15000);
        foodList[5] = fo6;
        Food fo7 = new Food("F007", "Jus Kliningan", 12000);
        foodList[6] = fo7;
        Food fo8 = new Food("F008", "Susu Murni Julia", 12000);
        foodList[7] = fo8;
        Food fo9 = new Food("F009", "Cet Time Kopo", 15000);
        foodList[8] = fo9;
        Food fo10 = new Food("F010", "Teh Asoy Geboy", 8000);
        foodList[9] = fo10;
    }
    
    // FUNGSI SEARCH CUSTOMER
    public Customer SearchCust(Customer[] list, String id) {
        int i = 0;
        while(list[i] != null) {
            if(list[i].getIdCustomer() == id) {
                return list[i];
            }
            i++;
        }
        return null;
    }
    
    // FUNGSI SEARCH DRIVER
    public Driver SearchDriver(Driver[] list, String id) {
        int i = 0;
        while(list[i] != null) {
            if(list[i].getIdDriver()== id) {
                return list[i];
            }
            i++;
        }
        return null;
    }
    
     // FUNGSI SEARCH ORDER
    public Order SearchOrder(Order[] list, String id) {
        int i = 0;
        while(list[i] != null) {
            if(list[i].getId() == id) {
                return list[i];
            }
            i++;
        }
        return null;
    }
    
    // FUNGSI SEARCH  CUSTOMER BY ORDER
    public Customer SearchCustByOrder(Customer[] list, Order[] orderList, String id) {
        if(SearchOrder(orderList, id) != null) {
            for(int i = 0; i < 5; i++) {
                int j = 0;
                while(list[i].getOrders(j) != null) {
                    if(list[i].getOrders(j).getId() == id) {
                        return list[i];
                    }
                    j++;
                }
            }
            return null;
        }
        else {
            System.out.println("Id Order tidak ditemukan!");
            return null;
        }
    }
    
    // FUNGSI SEARCH DRIVER BY ORDER
    public Driver SearchOrderByDriver(Driver[] list, Order[] orderList, String id) {
        if(SearchOrder(orderList, id) != null) {
            for(int i = 0; i < 5; i++) {
                int j = 0;
                while(list[i].getOrders(j) != null) {
                    if(list[i].getOrders(j).getId() == id) {
                        return list[i];
                    }
                    j++;
                }
            }
            return null;
        }
        else {
            System.out.println("Id Order tidak ditemukan!");
            return null;
        }
    }
    
    // PROSEDUR VIEW CUSTOMER
    public void viewCust(Customer[] list) {
        System.out.println("=============== DATA CUSTOMER ===============");
        for(int i = 0; i < 5; i++) {
            System.out.print(i+1 + ".");
            System.out.print(list[i].getIdCustomer() + "  |  " + list[i].getName() + "  |  " + list[i].getEmail() + "  |  " + list[i].getNumber() + "  |  Order : ");
            int j = 0;
            while(list[i].getOrders(j) != null) {
                System.out.print(list[i].getOrders(j).getId() + " ");
                j++;
            }
            System.out.println();
        }
    }
    
    // PROSEDUR VIEW DRIVER
    public void viewDriver(Driver[] list) {
        System.out.println("=============== DATA DRIVER ===============");
        for(int i = 0; i < 5; i++) {
            System.out.print(i+1 + ".");
            System.out.print(list[i].getIdDriver() + "  |  " + list[i].getName() + "  |  " + list[i].getEmail() + "  |  " + list[i].getNumber() + "  |  Order : ");
            int j = 0;
            while(list[i].getOrders(j) != null) {
                System.out.print(list[i].getOrders(j).getId() + " ");
                j++;
            }
            System.out.println();
        }
    }
    
    // PROSEDURE VIEW ORDER
    public void viewOrder(Order[] list) {
        System.out.println("=============== DATA ORDER ===============");
        for(int i = 0; i < 15; i++) {
            System.out.print(i+1 + ".");
            System.out.println(list[i].getId() + "  |  " + list[i].getPosition() + "  |  " + list[i].getDestination() + "  |  Dst : " + list[i].getDistance() + " Km");
        }
    }
    
    // PROSEDUR VIEW ORDER YANG MASIH AVAILABLE
    public void checkOrder(Order[] list) {
        System.out.println("=============== AVAILABLE ORDER ===============");
        int i = 0;
        int j = 1;
        while(i < 15) {
           if(list[i].isTaken() == false) {
               System.out.print(j++ + ".");
               System.out.println(list[i].getId() + "  |  " + list[i].getPosition() + "  |  " + list[i].getDestination() + "  |  Dst : " + list[i].getDistance() + " Km");
           }
           i++;
        }
    }
    
    // PROSEDUR VIEW DATA TRANSAKSI
    public void viewTransaction(Customer[] custList, Driver[] driverList, Order[] orderList) {
        System.out.println("=============== DATA TRANSAKSI ===============");
        int j = 1;
        for(int i = 0; i < 5; i++) {
            int k = 0;
            while(custList[i].getOrders(k) != null) {
                System.out.print(j++ + " .");
                System.out.print(custList[i].getIdCustomer() + "  |  Order : " + custList[i].getOrders(k).getId() + "  |  Status : ");
                if(custList[i].getOrders(k).isTaken() == true) {
                    Driver d = SearchOrderByDriver(driverList, orderList, custList[i].getOrders(k).getId());
                    System.out.println("Sudah diantar, oleh Driver : " + d.getIdDriver());
                }
                else {
                    System.out.println("Belum diantar");
                }
                System.out.println("\t Harga : Rp" + custList[i].getOrders(k).getPrice());
                k++;
            }
        }
    }
    
}
