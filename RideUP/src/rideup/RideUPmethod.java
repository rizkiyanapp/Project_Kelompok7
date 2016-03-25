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
        Food fo1 = new Food("Ayam Pedas Udin", 14000);
        foodList[0] = fo1;
        Food fo2 = new Food("Roti Bakar Asep", 10000);
        foodList[1] = fo2;
        Food fo3 = new Food( "Pisang Goreng Mamat", 11000);
        foodList[2] = fo3;
        Food fo4 = new Food("Pancong Balap", 8000);
        foodList[3] = fo4;
        Food fo5 = new Food("Chicken Katsu Afro", 15000);
        foodList[4] = fo5;
        Food fo6 = new Food("Nasi Pecel Mbakyu", 15000);
        foodList[5] = fo6;
        Food fo7 = new Food("Jus Kliningan", 12000);
        foodList[6] = fo7;
        Food fo8 = new Food("Susu Murni Julia", 12000);
        foodList[7] = fo8;
        Food fo9 = new Food("Cet Time Kopo", 15000);
        foodList[8] = fo9;
        Food fo10 = new Food("Teh Asoy Geboy", 8000);
        foodList[9] = fo10;
    }
    
    // PROSEDUR MEMBUAT CUSTOMER
    
    // PROSEDUR MEMBUAT DRIVER
    
    // PROSEDUR MEMBUAT ORDER (CUSTOMER)
    
    // PROSEDUR MENGAMBIL ORDER (DIRVER)
    
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
    public Order SearchOrder(Customer[] list, String id) {
        int i = 0;
        while(list[i] != null) {
            int j = 0;
            while(list[i].getOrders(j) != null) {
                if(list[i].getOrders(j).getId() == id) {
                    return list[i].getOrders(j);
                }
                j++;
            }
            i++;
        }
        return null;
    }
    
    // FUNGSI SEARCH  CUSTOMER BY ORDER
    public Customer SearchCustByOrder(Customer[] list, String id) {
        int i = 0;
        while(list[i] != null) {
            int j = 0;
            while(list[i].getOrders(j) != null) {
                if(list[i].getOrders(j).getId() == id) {
                    return list[i];
                }
                j++;
            }
            i++;
        }
        return null;
    }
    
    // FUNGSI SEARCH DRIVER BY ORDER
    public Driver SearchDriverByOrder(Driver[] list, String id) {
        int i = 0;
        while(list[i] != null) {
            int j = 0;
            while(list[i].getOrders(j) != null) {
                if(list[i].getOrders(j).getId() == id) {
                    return list[i];
                }
                j++;
            }
            i++;
        }
        return null;
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
    
    
    // PROSEDUR VIEW ORDER YANG MASIH AVAILABLE
    
    
    // PROSEDUR VIEW DATA TRANSAKSI
    
}
