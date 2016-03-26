/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rideup;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author NANON
 */
public class Console {

    private Application app;
    private Person current;
    Scanner scanInteger;
    Scanner scanString;

    public Console(Application app) {
        this.app = app;
        scanInteger = new Scanner(System.in);
        scanString = new Scanner(System.in);
    }

    public int inputInteger() {
        try {
            return scanInteger.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input must be number!");
        } finally {
            scanInteger = new Scanner(System.in);
        }
    }

    public void viewFoodList() {
        System.out.println("========== Food List ==========");
        for (int i = 0; i < app.getFoodList().size(); i++) {
            Food f = app.getFoodList().get(i);
            System.out.println(i + ". ID : " + f.getIdFood() + "  |  " + f.getName() + "  |  Rp." + f.getPrice());
        }
        System.out.println("=============================");
    }

    public void menuOrder(Customer current, long rideupPrice) {
        int input1 = 0;
        int input2 = 0;
        System.out.println("=============== RIDEUP ===============");
        System.out.println("================ order ================");
        System.out.println("1. Transportation");
        System.out.println("2. Courier");
        System.out.println("3. FoodCourier");
        System.out.println();
        while ((input1 == 0) && (input2 == 0)) {
            try {
                System.out.print("Type : ");
                input1 = inputInteger();
                System.out.print("Your Position : ");
                String position = scanString.nextLine();
                System.out.print("Destination : ");
                String destination = scanString.nextLine();
                System.out.print("Distance (Km) : ");
                input2 = inputInteger();
                System.out.print("Detail : ");
                String detail = scanString.nextLine();
                current.createOrder(input1, position, destination, input2, detail);
                current.getOrders(current.getNOrder() - 1).setPrice(rideupPrice);
                if (input1 == 2) {
                    System.out.print("Receiver Name : ");
                    String receiverName = scanString.nextLine();
                    System.out.println("Receiver Number : ");
                    String receiverNumber = scanString.nextLine();
                    Courier temp = (Courier) current.getOrders(current.getNOrder() - 1);
                    temp.setReceiverName(receiverName);
                    temp.setReceiverNumber(receiverNumber);
                } else if (input1 == 3) {
                    Food order = null;
                    viewFoodList();
                    boolean ans = false;
                    while (!ans) {
                        System.out.println("Food ID : ");
                        String foodId = scanString.nextLine();
                        order = app.searchFood(foodId);
                        if (order != null) {
                            ans = true;
                        } else {
                            System.out.println("That ID doesn't exist! Try again...");
                        }
                    }
                    int ans2 = 0;
                    while (ans2 == 0) {
                        try {
                            System.out.println("Qty : ");
                            ans2 = inputInteger();
                        } catch (Exception e) {
                            System.out.println("Error : " + e.getMessage() + " Try again...");
                        } finally {
                            scanInteger = new Scanner(System.in);
                            scanString = new Scanner(System.in);
                        }
                    }
                    FoodCourier temp = (FoodCourier) current.getOrders(current.getNOrder() - 1);
                    temp.addFood(order, ans2);
                }
                System.out.println("===== Successfull! =====");
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + " Try again...");
            } finally {
                scanInteger = new Scanner(System.in);
                scanString = new Scanner(System.in);
            }
        }
    }

    public void menuFeedback(Customer current) {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("=============== feedback ==============");
        System.out.print("Order ID : ");
        String orderId = scanString.nextLine();
        Order temp = app.searchOrderCustomer(orderId);
        if (temp != null) {
            if (temp.isTaken() == true) {
                System.out.print("Feedback : ");
                String feedback = scanString.nextLine();
                temp.setFeedback(feedback);
                System.out.println("===== Successfull! =====");
            } else {
                System.out.println("Order still available, can't write feedback!");
            }
        } else {
            System.out.println("Order never been created or wrong ID!");
        }
    }

    public void menuDeleteOrder(Customer current) {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("============= delete order ==============");
        System.out.print("Order ID : ");
        String orderId = scanString.nextLine();
        Order temp = app.searchOrderCustomer(orderId);
        if (temp != null) {
            if (temp.isTaken() == false) {
                app.getList().remove(temp);
                System.out.println("===== Successfull! =====");
            } else {
                System.out.println("Cannot be delete! Order has been taken by the Driver");
            }
        } else {
            System.out.println("Order never been created or wrong ID!");
        }
    }

    public void menuViewOrderCust(Customer current) {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("============== view order ==============");
        for (int i = 0; i < current.getNOrder(); i++) {
            System.out.print(i + ". ");
            if (current.getOrders(i) instanceof Courier) {
                Courier temp = (Courier) current.getOrders(i);
                System.out.println(temp.toString());
            } else if (current.getOrders(i) instanceof FoodCourier) {
                FoodCourier temp = (FoodCourier) current.getOrders(i);
                System.out.println(temp.toString());
            } else {
                System.out.println(current.getOrders(i).toString());
            }
            System.out.print("Status : ");
            if (current.getOrders(i).isTaken()) {
                Driver temp = app.searchDriverByOrder(current.getOrders(i));
                System.out.println("Taken by " + temp.getIdDriver());
            } else {
                System.out.println("Available");
            }
            System.out.println("Detail : " + current.getOrders(i).getDetail());
            System.out.println("FeedBack : " + current.getOrders(i).getFeedback());
            System.out.println();
        }
    }

    public void menuViewOrderDriver(Driver current) {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("============== view order ==============");
        for (int i = 0; i < current.getNOrder(); i++) {
            System.out.print(i + ". ");
            if (current.getOrders(i) instanceof Courier) {
                Courier temp = (Courier) current.getOrders(i);
                System.out.println(temp.toString());
            } else if (current.getOrders(i) instanceof FoodCourier) {
                FoodCourier temp = (FoodCourier) current.getOrders(i);
                System.out.println(temp.toString());
            } else {
                System.out.println(current.getOrders(i).toString());
            }
            System.out.println("Detail : " + current.getOrders(i).getDetail());
            System.out.println("FeedBack : " + current.getOrders(i).getFeedback());
            System.out.println();
        }
    }

    public void menuEdit(Person current) {
        int ans = 0;
        while (ans == 0) {
            System.out.println("=============== RIDEUP ===============");
            System.out.println("============== edit profile ==============");
            System.out.println("Current Profile :");
            System.out.println(current.toString());
            System.out.println();
            System.out.println("1. Name");
            System.out.println("2. No Identity");
            System.out.println("3. Gender");
            System.out.println("4. Age");
            System.out.println("5. Address");
            System.out.println("6. Exit");
            try {
                System.out.print("Ans : ");
                ans = inputInteger();
                switch (ans) {
                    case 1:
                        System.out.print("Name : ");
                        String name = scanString.nextLine();
                        current.setName(name);
                        ans = 0;
                        break;
                    case 2:
                        System.out.print("No Identity : ");
                        String noIdentity = scanString.nextLine();
                        current.setNoIdentity(noIdentity);
                        ans = 0;
                        break;
                    case 3:
                        System.out.print("Gender (M/F) : ");
                        char gender = scanString.next().charAt(0);
                        current.setGender(gender);
                        ans = 0;
                        break;
                    case 4:
                        System.out.print("Age : ");
                        int age = 0;
                        while (age == 0) {
                            try {
                                age = inputInteger();
                            } catch (Exception e) {
                                System.out.println("Error : " + e.getMessage() + " Try again...");
                            } finally {
                                scanInteger = new Scanner(System.in);
                                scanString = new Scanner(System.in);
                            }
                        }
                        current.setAge(age);
                        ans = 0;
                        break;
                    case 5:
                        System.out.println("Address : ");
                        String address = scanString.nextLine();
                        current.setAddress(address);
                        ans = 0;
                        break;
                    case 6:
                        System.out.println("Leave edit profile...");
                        break;
                    default:
                        throw new IllegalStateException("Wrong menu input!");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + " Try again...");
            } finally {
                scanInteger = new Scanner(System.in);
                scanString = new Scanner(System.in);
            }
        }
    }

    public void menuTakeOrder(Driver Order) {
        int num = 1;
        System.out.println("=============== RIDEUP ===============");
        System.out.println("============== take order ==============");
        System.out.println("Available Order : ");
        for (int i = 0; i < app.getList().size(); i++) {
            if (app.getList().get(i) instanceof Customer) {
                Customer temp = (Customer) app.getList().get(i);
                for (int j = 0; j < temp.getNOrder(); j++) {
                    if (temp.getOrders(j).isTaken() == false) {
                        if (temp.getOrders(j) instanceof Courier) {
                            Courier temp2 = (Courier) temp.getOrders(j);
                            System.out.println(num + ". Courier  |  " + temp2.toString());
                        } else if (temp.getOrders(j) instanceof FoodCourier) {
                            FoodCourier temp2 = (FoodCourier) temp.getOrders(j);
                            System.out.println(num + ". Food Courier  |  " + temp2.toString());
                        } else {
                            Order temp2 = temp.getOrders(j);
                            System.out.println(num + ". Transportation  |  " + temp2.toString());
                        }
                    }
                }
            }
        }

    }

    public void menuSignUp() {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("================ sign up ===============");
        boolean auth = false;
        while (!auth) {
            System.out.print("Username : ");
            String username = scanString.nextLine();
            for (int i = 0; i < app.getList().size(); i++) {
                if (app.getList().get(i).getUsername().equals(username)) {
                    System.out.println("Username already exist! Try again...");
                }
            }
            auth = true;
        }
        auth = false;
        while (!auth) {
            System.out.print("Password : ");
            String temp = scanString.nextLine();
            System.out.print("Retype Password :");
            String password = scanString.nextLine();
            if (temp.equals(password)) {
                System.out.println("===== Successfull! =====");
                auth = true;
            } else {
                System.out.println("Wrong password! Try again...");
            }
        }
    }

    public void menuSignIn() {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("================ sign in ================");
        boolean auth = false;
        while (!auth) {
            System.out.print("Username : ");
            String username = scanString.nextLine();
            System.out.print("Password : ");
            String password = scanString.nextLine();
            if (app.searchCustomer(username) != null) {
                System.out.println("Logging in....");
                auth = true;
                current = app.searchCustomer(username);
            } else {
                System.out.println("Wrong username or password! Try again...");
            }
        }
    }

    public void ViewAccount() {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("=============== account ================");
        for (int i = 0; i < app.getList().size(); i++) {
            System.out.print(i + ". Username : " + app.getList().get(i).getUsername() + "  |   ID : ");
            if (app.getList().get(i) instanceof Driver) {
                Driver temp = (Driver) app.getList().get(i);
                System.out.println(temp.getIdDriver());
            } else {
                Customer temp = (Customer) app.getList().get(i);
                System.out.println(temp.getIdCustomer());
            }
        }
    }

    public void mainMenu() {
        boolean status = true;

        while (status) {
            System.out.println("=============== RIDEUP ===============");
            System.out.println("======================================");
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. View Account");
            System.out.println("4. Delete Account");
            System.out.println("0. Exit Program");
            System.out.print("Ans : ");

        }
    }
}
