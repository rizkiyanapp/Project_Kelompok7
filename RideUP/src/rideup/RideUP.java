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
public class RideUP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RideUPmethod rd = new RideUPmethod(); // AGAR DAPAT MEMAKAI FUNGSI & PROSEDUR
        final int rideupPrice = 2500; // HARGA PER KM
        int nOrder = 0; // JUMLAH SELURUH ORDER APLIKASI
        Order or; // VARIABEL REFERENCE
        FoodCourier fc; // VARIABEL REFERENCE
        Courier cr; // VARIABEL REFERENCE
        Food[] foodList = new Food[10]; // ARRAY LIST MAKANAN YANG TERSEDIA
        Customer[] custList = new Customer[5];
        Driver[] driverList = new Driver[5];
        Order[] orderList = new Order[15];
        
        rd.createFoodList(foodList);
        
        Customer c1 = new Customer("C101", "Captain America", "captmerica@gmail.com", "+628122011100");
        custList[0] = c1;
        c1.createOrder(1, "O101", "Margahayu", "Kiaracondong", 5, "-");
        c1.createOrder(2, "BC202", "Dago", "Buah Batu", 8, "-");
                
        Customer c2 = new Customer("C102", "Iron Man", "jarvis999@gmail.com", "+628122022200");
        custList[1] = c2;
        c2.createOrder(1, "O102", "Kopo", "Buah Batu", 6, "-");
        c2.createOrder(2, "BC203", "Cibiru", "Margahayu", 9, "-");
        c2.createOrder(3, "FC302", "Sukapura", "PBR", 4, "-");
        fc = (FoodCourier) c2.getOrders(2); // DOWNCASTING mengembalikan objek ke tipe FoodCourier
        fc.addFood(foodList[0], 2);

        c2.createOrder(3, "FC303", "Buah Batu", "PGA", 5, "-");
        fc = (FoodCourier) c2.getOrders(3); // DOWNCASTING mengembalikan objek ke tipe FoodCourier
        fc.addFood(foodList[2], 4);
                
        Customer c3 = new Customer("C103", "Hulk", "incrediblehulk@gmail.com", "+628122033300");
        custList[2] = c3;
        c3.createOrder(1, "O103", "Buah Batu", "Dago", 7, "-");
        c3.createOrder(2, "BC204", "Pasteur", "Buah Batu", 10, "-");
        c3.createOrder(3, "FC301", "Dayeuh Kolot", "Batununggal", 3, "-");
        fc = (FoodCourier) c3.getOrders(2); // DOWNCASTING mengembalikan objek ke tipe FoodCourier
        fc.addFood(foodList[6], 1);
        
        Customer c4 = new Customer("C104", "Black Widow", "johansen69@gmail.com", "+628122044400");
        custList[3] = c4;
        c4.createOrder(1, "O104", "Kiaracondong", "Pasteur", 8, "-");
        c4.createOrder(1, "BC205", "Dago", "Dayeuh Kolot", 11, "-");
        c4.createOrder(3, "FC304", "Buah Batu", "Permata Buah Batu", 6, "-");
        fc = (FoodCourier) c4.getOrders(2); // DOWNCASTING mengembalikan objek ke tipe FoodCourier
        fc.addFood(foodList[5], 5);
        c4.createOrder(3, "FC305", "Dayeuh Kolot", "Margahayu", 7, "-");
        fc = (FoodCourier) c4.getOrders(3); // DOWNCASTING mengembalikan objek ke tipe FoodCourier
        fc.addFood(foodList[7], 2);
        
        Customer c5 = new Customer("C105", "Thor", "asgardcolud@gmail.com", "+628122055500");
        custList[4] = c5;
        c5.createOrder(1, "O105", "Dayeuh Kolot", "Cibiru", 9, "-");
        c5.createOrder(2, "BC201", "Kiaracondong", "Margahayu", 7, "-");
        
        // PROSES PENGHITUNGAN HARGA & PEMASUKAN OBJEK ORDER KE ARRAY
        for(int i = 0; i < 5; i++) {
            int j = 0;
            while(custList[i].getOrders(j) != null) {
                custList[i].getOrders(j).setPrice(rideupPrice * custList[i].getOrders(j).getDistance());
                /*
                Harga = harga rideup * distance si objek
                */
                orderList[nOrder++] = custList[i].getOrders(j);
                j++;
            }
        }
        
        Driver d1 = new Driver("D101", "Red Skull", "hydra777@gmail.com", "+628122066600");
        driverList[0] = d1;
        d1.addOrder(rd.SearchOrder(orderList, "O103"));
        d1.addOrder(rd.SearchOrder(orderList, "BC204"));
        
        Driver d2 = new Driver("D102", "Ultron", "freeworld@gmail.com", "+628122077700");
        driverList[1] = d2;
        d2.addOrder(rd.SearchOrder(orderList, "FC301"));
        
        Driver d3 = new Driver("D103", "Magneto", "bestmutant@gmail.com", "+628122088800");
        driverList[2] = d3;
        d3.addOrder(rd.SearchOrder(orderList, "O105"));
        d3.addOrder(rd.SearchOrder(orderList, "BC201"));
        d3.addOrder(rd.SearchOrder(orderList, "FC305"));
        
        Driver d4 = new Driver("D104", "Loki", "mindcontrol@gmail.com", "+628122099900");
        driverList[3] = d4;
        d4.addOrder(rd.SearchOrder(orderList, "FC302"));
        
        Driver d5 = new Driver("D105", "Thanos", "infinityorbs@gmail.com", "+628122000000");
        driverList[4] = d5;
        d5.addOrder(rd.SearchOrder(orderList, "O102"));
        d5.addOrder(rd.SearchOrder(orderList, "BC203"));
        
        rd.viewCust(custList);
        System.out.println();
        rd.viewDriver(driverList);
        System.out.println();
        rd.viewOrder(orderList);
        System.out.println();
        rd.checkOrder(orderList);
        System.out.println();
        rd.viewTransaction(custList, driverList, orderList);
        
    }
    
}
