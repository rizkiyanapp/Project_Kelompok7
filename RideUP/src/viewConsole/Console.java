/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewConsole;

import model.Person;
import model.FoodCourier;
import model.Courier;
import model.Food;
import model.Customer;
import model.Application;
import model.Driver;
import model.Order;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author NANON
 */
public class Console {

    private Application app;
    private Customer currentCust;
    private Driver currentDriver;
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
            System.out.println(i + 1 + ". ID : " + f.getIdFood() + "  |  " + f.getName() + "  |  Rp." + f.getPrice());
        }
        System.out.println("=============================");
    }

    public void menuOrder(Customer current, long rideupPrice) {
        int input1 = 0;
        int input2 = 0;
        while ((input1 == 0) && (input2 == 0)) {
            try {
                System.out.println("=============== RIDEUP ===============");
                System.out.println("================ order ================");
                System.out.println("1. Transportation");
                System.out.println("2. Courier");
                System.out.println("3. FoodCourier");
                System.out.println("4. Back");
                System.out.println();
                System.out.print("Type : ");
                input1 = inputInteger();
                if ((input1 < 1) || (input1 > 4)) {
                    input1 = 0;
                    input2 = 0;
                    throw new IllegalStateException("Type must be range of 1 - 4!");
                } else if (input1 == 4) {
                    System.out.println("Back...");
                } else {
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
                        System.out.print("Receiver Number : ");
                        String receiverNumber = scanString.nextLine();
                        Courier temp = (Courier) current.getOrders(current.getNOrder() - 1);
                        temp.setReceiverName(receiverName);
                        temp.setReceiverNumber(receiverNumber);
                    } else if (input1 == 3) {
                        Food order = null;
                        viewFoodList();
                        boolean ans = false;
                        while (!ans) {
                            System.out.print("Food ID : ");
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
                                System.out.print("Qty : ");
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
                }
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
        System.out.println("");
        for (int i = 0; i < current.getNOrder(); i++) {
            System.out.println(i + 1 + ". ID : " + current.getOrders(i));
        }
        System.out.println();
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
                System.out.println("Cannot be delete! Order has  taken by the Driver");
            }
        } else {
            System.out.println("Order never been created or wrong ID!");
        }
    }

    public void menuViewOrderCust(Customer current) {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("============== view order ==============");
        for (int i = 0; i < current.getNOrder(); i++) {
            System.out.print(i + 1 + ". ");
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
                System.out.println("Price : Rp" + current.getOrders(i).getPrice());
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
            System.out.print(i + 1 + ". ");
            if (current.getOrders(i) instanceof Courier) {
                Courier temp = (Courier) current.getOrders(i);
                System.out.println(temp.toString());
            } else if (current.getOrders(i) instanceof FoodCourier) {
                FoodCourier temp = (FoodCourier) current.getOrders(i);
                System.out.println(temp.toString());
            } else {
                System.out.println(current.getOrders(i).toString());
            }
            System.out.println("Price : Rp" + current.getOrders(i).getPrice());
            System.out.println("Detail : " + current.getOrders(i).getDetail());
            System.out.println("FeedBack : " + current.getOrders(i).getFeedback());
            System.out.println();
        }
    }

    public void menuEdit(Person current) {
        int ans = 0;
        while (ans == 0) {
            try {
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
                System.out.print("Ans : ");
                ans = inputInteger();
                switch (ans) {
                    case 1:
                        ans = 0;
                        System.out.print("Name : ");
                        String name = scanString.nextLine();
                        current.setName(name);
                        break;
                    case 2:
                        ans = 0;
                        System.out.print("No Identity : ");
                        String noIdentity = scanString.nextLine();
                        current.setNoIdentity(noIdentity);
                        break;
                    case 3:
                        ans = 0;
                        System.out.print("Gender (M/F) : ");
                        char gender = scanString.next().charAt(0);
                        current.setGender(gender);
                        break;
                    case 4:
                        ans = 0;
                        System.out.print("Age : ");
                        String age = scanString.nextLine();
                        current.setAge(age);
                        break;
                    case 5:
                        ans = 0;
                        System.out.print("Address : ");
                        String address = scanString.nextLine();
                        current.setAddress(address);
                        break;
                    case 6:
                        System.out.println("Leave edit profile...");
                        break;
                    default:
                        ans = 0;
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

    public void menuTakeOrder(Driver current) {
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
                    num++;
                }
            }
        }
        System.out.println();
        System.out.print("Order ID : ");
        String orderId = scanString.nextLine();
        Order take = app.searchOrderCustomer(orderId);
        if (take != null) {
            current.addOrder(take);
            System.out.println("===== Successfull! =====");
        } else {
            System.out.println("Order ID cannot found or wrong order ID! Try again...");
        }
    }

    public void menuSignUp() {
        String username = null;
        String password = null;
        int type = 0;
        while (type == 0) {
            try {
                System.out.println("=============== RIDEUP ===============");
                System.out.println("================ sign up ===============");
                System.out.println("1. Customer");
                System.out.println("2. Driver");
                System.out.println("3. Back");
                System.out.print("Type : ");
                type = inputInteger();
                if ((type < 1) || (type > 3)) {
                    type = 0;
                    throw new IllegalStateException("Type must be 1 or 2 or 3!");
                } else if (type == 3) {
                    System.out.println("Back....");
                } else {
                    boolean auth = false;
                    boolean auth2 = false;
                    while (!auth) {
                        auth2 = false;
                        System.out.print("Username : ");
                        username = scanString.nextLine();
                        for (int i = 0; i < app.getList().size(); i++) {
                            if (app.getList().get(i).getUsername().equals(username)) {
                                auth2 = true;
                            }
                        }
                        if (auth2) {
                            System.out.println("Username already exist! Try again...");
                        } else {
                            auth = true;
                        }
                    }
                    auth = false;
                    while (!auth) {
                        System.out.print("Password : ");
                        String temp = scanString.nextLine();
                        System.out.print("Retype Password :");
                        password = scanString.nextLine();
                        if (temp.equals(password)) {
                            auth = true;
                        } else {
                            System.out.println("Wrong password! Try again...");
                        }
                    }
                    System.out.print("Name : ");
                    String name = scanString.nextLine();
                    System.out.print("Email : ");
                    String email = scanString.nextLine();
                    System.out.print("Number : ");
                    String number = scanString.nextLine();
                    if (type == 1) {
                        app.addCustomer(username, password, name, email, number);
                    } else if (type == 2) {
                        app.addDriver(username, password, name, email, number);
                    }
                    System.out.println("===== Successfull! =====");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + " Try again...");
            } finally {
                scanInteger = new Scanner(System.in);
                scanString = new Scanner(System.in);
            }
        }
    }

    public boolean menuSignIn() {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("================ sign in ================");
        System.out.print("Username : ");
        String username = scanString.nextLine();
        System.out.print("Password : ");
        String password = scanString.nextLine();
        Person temp = app.searchPerson(username);
        if (temp != null) {
            if (temp.getPassword().equals(password)) {
                if (temp instanceof Driver) {
                    currentDriver = (Driver) temp;
                } else {
                    currentCust = (Customer) temp;
                }
                System.out.println("Logging in....");
                return true;
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("Wrong username!");
        }
        return false;
    }

    public void ViewAccount() {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("=============== account ================");
        for (int i = 0; i < app.getList().size(); i++) {
            System.out.print(i + 1 + ". Username : " + app.getList().get(i).getUsername() + "  |  ID : ");
            if (app.getList().get(i) instanceof Driver) {
                Driver temp = (Driver) app.getList().get(i);
                System.out.println(temp.getIdDriver());
            } else {
                Customer temp = (Customer) app.getList().get(i);
                System.out.println(temp.getIdCustomer());
            }
        }
    }

    public void menuDelete() {
        System.out.println("=============== RIDEUP ===============");
        System.out.println("============ delete account ============");
        System.out.print("Username : ");
        String username = scanString.nextLine();
        Person temp = app.searchPerson(username);
        if (temp != null) {
            app.deletePerson(temp);
            System.out.println("===== Successfull =====");
        } else {
            System.out.println("That account never been registered!");
        }
    }

    public void mainMenu() {
        app.createFoodList();
        int ans = 0;
        while (ans == 0) {
            try {
                currentCust = null;
                currentDriver = null;
                System.out.println("=============== RIDEUP ===============");
                System.out.println("======================================");
                System.out.println("1. Sign In");
                System.out.println("2. Sign Up");
                System.out.println("3. View Account");
                System.out.println("4. Delete Account");
                System.out.println("5. Load Data");
                System.out.println("6. Exit Program");
                System.out.print("Ans : ");
                ans = inputInteger();
                switch (ans) {
                    case 1:
                        ans = 0;
                        if (menuSignIn() == true) {
                            if (currentCust != null) {
                                int ans2 = 0;
                                while (ans2 == 0) {
                                    try {
                                        System.out.println("=============== RIDEUP ===============");
                                        System.out.println("============== customer ===============");
                                        System.out.println("1. Order");
                                        System.out.println("2. Delete Order");
                                        System.out.println("3. View Order");
                                        System.out.println("4. Feedback");
                                        System.out.println("5. Edit Profile");
                                        System.out.println("6. Sign Out");
                                        System.out.print("Ans : ");
                                        ans2 = inputInteger();
                                        switch (ans2) {
                                            case 1:
                                                ans2 = 0;
                                                menuOrder(currentCust, app.rideupPrice);
                                                break;
                                            case 2:
                                                ans2 = 0;
                                                menuDeleteOrder(currentCust);
                                                break;
                                            case 3:
                                                ans2 = 0;
                                                menuViewOrderCust(currentCust);
                                                break;
                                            case 4:
                                                ans2 = 0;
                                                menuFeedback(currentCust);
                                                break;
                                            case 5:
                                                ans2 = 0;
                                                menuEdit(currentCust);
                                                break;
                                            case 6:
                                                currentCust = null;
                                                System.out.println("Logging out....");
                                                break;
                                            default:
                                                ans2 = 0;
                                                throw new IllegalStateException("Wrong menu input!");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error : " + e.getMessage() + " Try again...");
                                    } finally {
                                        scanInteger = new Scanner(System.in);
                                        scanString = new Scanner(System.in);
                                    }
                                }
                            } else if (currentDriver != null) {
                                int ans2 = 0;
                                while (ans2 == 0) {
                                    try {
                                        System.out.println("=============== RIDEUP ===============");
                                        System.out.println("=============== driver ================");
                                        System.out.println("1. Take Order");
                                        System.out.println("2. View Order");
                                        System.out.println("3. Edit Profile");
                                        System.out.println("4. Sign Out");
                                        System.out.print("Ans : ");
                                        ans2 = inputInteger();
                                        switch (ans2) {
                                            case 1:
                                                ans2 = 0;
                                                menuTakeOrder(currentDriver);
                                                break;
                                            case 2:
                                                ans2 = 0;
                                                menuViewOrderDriver(currentDriver);
                                                break;
                                            case 3:
                                                ans2 = 0;
                                                menuEdit(currentDriver);
                                                break;
                                            case 4:
                                                currentDriver = null;
                                                System.out.println("Logging out.....");
                                                break;
                                            default:
                                                ans2 = 0;
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
                        }
                        break;
                    case 2:
                        ans = 0;
                        menuSignUp();
                        break;
                    case 3:
                        ans = 0;
                        ViewAccount();
                        break;
                    case 4:
                        ans = 0;
                        menuDelete();
                        break;
                    case 5:
                        ans = 0;
                        System.out.println("Loading data....");
                        app.loadDataFood();
                        app.loadDataIterator();
                        app.loadDataAccount();
                        app.loadIterator();
                        break;
                    case 6:
                        System.out.println("Saving data.....");
                        app.saveIterator();
                        app.saveDataFood();
                        app.saveDataIterator();
                        app.saveDataAccount();
                        System.out.println();
                        System.out.println("========== GOODBYE :) ==========");
                        break;
                    default:
                        ans = 0;
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
}
