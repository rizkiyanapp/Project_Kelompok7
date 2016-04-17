/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Application;
import model.Customer;
import model.Driver;
import model.Person;
import view.CourierMenu;
import view.CustomerMenu;
import view.DelAccMenu;
import view.DeleteOrderCustMenu;
import view.DriverMenu;
import view.FeedbackCustMenu;
import view.FoodCourierMenu;
import view.MainMenu;
import view.PanelContainer;
import view.ProfileMenu;
import view.RegAccMenu;
import view.SignInMenu;
import view.SignUpMenu;
import view.TakeOrderMenu;
import view.TransportationMenu;
import view.ViewOrderMenu;

/**
 *
 * @author NANON
 */
public class Controller extends MouseAdapter implements ActionListener {

    private Application model;
    private Customer currentCust;
    private Driver currentDriver;
    private PanelContainer view;
    private String currentView;
    private JPanel mainPanel;

    private int type;
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String email;
    private String number;

    private CourierMenu crm;
    private CustomerMenu cstm;
    private DelAccMenu dam;
    private DeleteOrderCustMenu docm;
    private DriverMenu drvm;
    private FeedbackCustMenu fbcm;
    private FoodCourierMenu fdcm;
    private MainMenu mm;
    private ProfileMenu pm;
    private RegAccMenu ram;
    private SignInMenu sim;
    private SignUpMenu sum;
    private TakeOrderMenu tom;
    private TransportationMenu tm;
    private ViewOrderMenu vom;

    public Controller(Application model) {
        this.model = model;
        this.view = new PanelContainer();

        crm = new CourierMenu();
        cstm = new CustomerMenu();
        dam = new DelAccMenu();
        docm = new DeleteOrderCustMenu();
        drvm = new DriverMenu();
        fbcm = new FeedbackCustMenu();
        fdcm = new FoodCourierMenu();
        mm = new MainMenu();
        pm = new ProfileMenu();
        ram = new RegAccMenu();
        sim = new SignInMenu();
        sum = new SignUpMenu();
        tom = new TakeOrderMenu();
        tm = new TransportationMenu();
        vom = new ViewOrderMenu();

        crm.addListener(this);
        crm.addAdapter(this);
        cstm.addListener(this);
        dam.addListener(this);
        dam.addAdapter(this);
        docm.addListener(this);
        docm.addAdapter(this);
        drvm.addListener(this);
        fbcm.addListener(this);
        fbcm.addAdapter(this);
        fdcm.addListener(this);
        fdcm.addAdapter(this);
        mm.addListener(this);
        pm.addListener(this);
        pm.addAdapter(this);
        ram.addListener(this);
        sim.addListener(this);
        sum.addListener(this);
        tom.addListener(this);
        tom.addAdapter(this);
        tm.addListener(this);
        tm.addAdapter(this);
        vom.addListener(this);
        vom.addAdapter(this);

        mainPanel = view.getMainPanel();
        mainPanel.add(mm, "Main Menu");
        mainPanel.add(crm, "Courier Menu");
        mainPanel.add(cstm, "Customer Main Menu");
        mainPanel.add(docm, "Delete Order Menu");
        mainPanel.add(drvm, "Driver Main Menu");
        mainPanel.add(fbcm, "Feedback Menu");
        mainPanel.add(fdcm, "FoodOrder Menu");
        mainPanel.add(pm, "Profile Menu");
        mainPanel.add(tom, "Take Order Menu");
        mainPanel.add(tm, "Transportation Menu");
        mainPanel.add(vom, "View Order Menu");
        mainPanel.add(sim, "Sign In Menu");
        mainPanel.add(sum, "Sign Up Menu");
        mainPanel.add(ram, "Registered Acc Menu");
        mainPanel.add(dam, "Delete Acc Menu");
        currentView = "Main Menu";

        view.getCardlayout().show(mainPanel, currentView);
        view.setVisible(true);

        model.loadAll();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (currentView.equals("Main Menu")) {
            // MAIN MENU
            if (source.equals(mm.getBtnDelAcc())) {
                currentView = "Delete Acc Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(mm.getBtnExit())) {
                model.saveAll();
                System.exit(0);
            } else if (source.equals(mm.getBtnRegAcc())) {
                currentView = "Registered Acc Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(mm.getBtnSignIn())) {
                currentView = "Sign In Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(mm.getBtnSignUp())) {
                currentView = "Sign Up Menu";
                view.getCardlayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("Courier Menu")) {
            // COURIER ORDER MENU
            if (source.equals(crm.getBtnBack())) {
                currentView = "Customer Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(crm.getBtnCreateOrder())) {

            }
        } else if (currentView.equals("Customer Main Menu")) {
            // CUSTOMER MAIN MENU
            if (source.equals(cstm.getBtnCourier())) {
                currentView = "Courier Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnDelOrder())) {
                currentView = "Delete Order Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnFeedback())) {
                currentView = "Feedback Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnFoodCourier())) {
                currentView = "FoodOrder Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnProfile())) {
                currentView = "Profile Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnSignOut())) {
                currentCust = null;
                currentView = "Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnTransport())) {
                currentView = "Transportation Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnView())) {
                currentView = "View Order Menu";
                view.getCardlayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("Delete Order Menu")) {
            // DELETE ORDER MENU
            if (source.equals(docm.getBtnBack())) {
                currentView = "Customer Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(docm.getBtnConfirmDelete())) {

            }
        } else if (currentView.equals("Driver Main Menu")) {
            // DRIVER MAIN MENU
            if (source.equals(drvm.getBtnProfile())) {
                currentView = "Profile Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(drvm.getBtnSignOut())) {
                currentDriver = null;
                currentView = "Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(drvm.getBtnTake())) {
                currentView = "Take Order Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(drvm.getBtnView())) {
                currentView = "View Order Menu";
                view.getCardlayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("Feedback Menu")) {
            // FEEDBACK MENU
            if (source.equals(fbcm.getBtnBack())) {
                currentView = "Customer Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(fbcm.getBtnFeedback())) {

            }
        } else if (currentView.equals("FoodOrder Menu")) {
            // FOODCOURIER ORDER MENU
            if (source.equals(fdcm.getBtnBack())) {
                currentView = "Customer Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(fdcm.getBtnCreateOrder())) {

            }
        } else if (currentView.equals("Profile Menu")) {
            // PROFILE MENU
            if (source.equals(pm.getBtnBack())) {
                if (currentCust != null) {
                    currentView = "Customer Main Menu";
                    view.getCardlayout().show(mainPanel, currentView);
                } else if (currentDriver != null) {
                    currentView = "Driver Main Menu";
                    view.getCardlayout().show(mainPanel, currentView);
                }
            } else if (source.equals(pm.getBtnEdit())) {

            }
        } else if (currentView.equals("Take Order Menu")) {
            // TAKE ORDER MENU
            if (source.equals(tom.getBtnBack())) {
                currentView = "Driver Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(tom.getBtnTakeOrder())) {

            }
        } else if (currentView.equals("Transportation Menu")) {
            // TRANSPORTATION ORDER MENU
            if (source.equals(tm.getBtnBack())) {
                currentView = "Customer Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(tm.getBtnOrder())) {

            }
        } else if (currentView.equals("View Order Menu")) {
            // VIEW ORDER MENU
            if (source.equals(vom.getBtnBack())) {
                if (currentCust != null) {
                    currentView = "Customer Main Menu";
                    view.getCardlayout().show(mainPanel, currentView);
                } else if (currentDriver != null) {
                    currentView = "Driver Main Menu";
                    view.getCardlayout().show(mainPanel, currentView);
                }
            }
        } else if (currentView.equals("Sign In Menu")) {
            // SIGN IN MENU
            if (source.equals(sim.getBtnBack())) {
                currentView = "Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(sim.getBtnSignIn())) {
                username = sim.getUsername();
                password = sim.getPassword();
                Person temp = model.searchPerson(username);
                if (temp != null) {
                    if (temp.getPassword().equals(password)) {
                        if (temp instanceof Customer) {
                            currentCust = (Customer) temp;
                            currentView = "Customer Main Menu";
                            view.getCardlayout().show(mainPanel, currentView);
                        } else if (temp instanceof Driver) {
                            currentDriver = (Driver) temp;
                            currentView = "Driver Main Menu";
                            view.getCardlayout().show(mainPanel, currentView);
                        }
                        sim.reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username!");
                }
            }
        } else if (currentView.equals("Sign Up Menu")) {
            // SIGN UP MENU
            if (source.equals(sum.getBtnBack())) {
                currentView = "Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(sum.getBtnSignUp())) {
                type = sum.getType();
                username = sum.getUsername();
                password = sum.getPassword();
                confirmPassword = sum.getConfirmPass();
                name = sum.getAccountName();
                email = sum.getAccountEmail();
                number = sum.getAccountNumber();
                Person temp = model.searchPerson(username);
                if (username.equals("")) {
                    JOptionPane.showMessageDialog(null, "Username cannot empty! Try again...");
                } else if (temp != null) {
                    JOptionPane.showMessageDialog(null, "Username already exist! Try again...");
                } else if ((password.equals("")) && (confirmPassword.equals(""))) {
                    JOptionPane.showMessageDialog(null, "Password cannot empty! Try again...");
                } else if (password.equals(confirmPassword)) {
                    if ((name.equals("")) && (email.equals("")) && (number.equals(""))) {
                        JOptionPane.showMessageDialog(null, "Form cannot empty! Try again...");
                    } else if (type == 1) {
                        JOptionPane.showMessageDialog(null, "Type doesn't exist! Try again...");
                    } else if (type == 2) {
                        model.addCustomer(username, password, name, email, number);
                        JOptionPane.showMessageDialog(null, "Customer Account created!!");
                        sum.reset();
                    } else if (type == 3) {
                        model.addDriver(username, password, name, email, number);
                        JOptionPane.showMessageDialog(null, "Driver Account created!!");
                        sum.reset();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password doesn't exist! Try again...");
                }
            }
        } else if (currentView.equals("Registered Acc Menu")) {
            // REGISTERED ACCOUNT MENU
            if (source.equals(ram.getBtnBack())) {
                currentView = "Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("Delete Acc Menu")) {
            // DELETE ACCOUNT MENU
            if (source.equals(dam.getBtnBack())) {
                currentView = "Main Menu";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(dam.getBtnDel())) {

            } else if (source.equals(dam.getBtnRefresh())) {

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }
}
