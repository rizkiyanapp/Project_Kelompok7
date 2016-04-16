/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Application;
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
    private PanelContainer view;
    private String currentView;
    private JPanel mainPanel;

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
        sum.addAdapter(this);
        tom.addListener(this);
        tom.addAdapter(this);
        tm.addListener(this);
        tm.addAdapter(this);
        vom.addListener(this);
        vom.addAdapter(this);

        mainPanel = view.getMainPanel();
        mainPanel.add(mm, "0");
        mainPanel.add(crm, "1");
        mainPanel.add(cstm, "2");
        mainPanel.add(docm, "3");
        mainPanel.add(drvm, "4");
        mainPanel.add(fbcm, "5");
        mainPanel.add(fdcm, "6");
        mainPanel.add(pm, "7");
        mainPanel.add(tom, "8");
        mainPanel.add(tm, "9");
        mainPanel.add(vom, "10");
        mainPanel.add(sim, "11");
        mainPanel.add(sum, "12");
        mainPanel.add(ram, "13");
        mainPanel.add(dam, "14");
        currentView = "0";

        view.getCardlayout().show(mainPanel, currentView);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (currentView.equals("0")) {
            // MAIN MENU
            if (source.equals(mm.getBtnDelAcc())) {
                // DELETE ACCOUNT MENU
                currentView = "14";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(mm.getBtnExit())) {
                // EXIT PROGRAM
                System.exit(0);
            } else if (source.equals(mm.getBtnRegAcc())) {
                // REGISTERED ACCOUNT MENU
                currentView = "13";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(mm.getBtnSignIn())) {
                // SIGN IN MENU
                currentView = "11";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(mm.getBtnSignUp())) {
                // SIGN UP MENU
                currentView = "12";
                view.getCardlayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("1")) {
            // COURIER ORDER MENU
            if (source.equals(crm.getBtnBack())) {
                // CUSTOMER MENU
                currentView = "2";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(crm.getBtnCreateOrder())) {

            }
        } else if (currentView.equals("2")) {
            // CUSTOMER MAIN MENU
            if (source.equals(cstm.getBtnCourier())) {
                // COURIER ORDER MENU
                currentView = "1";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnDelOrder())) {
                // DELETE ORDER MENU
                currentView = "3";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnFeedback())) {
                // FEEDBACK MENU
                currentView = "5";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnFoodCourier())) {
                // FOODCOURIER ORDER MENU
                currentView = "6";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnProfile())) {
                // PROFILE MENU
                currentView = "7";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnSignOut())) {
                // MAIN MENU
                currentView = "0";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnTransport())) {
                // TRANSPORTATION ORDER MENU
                currentView = "9";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(cstm.getBtnView())) {
                // VIEW ORDER MENU
                currentView = "10";
                view.getCardlayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("3")) {
            // DELETE ORDER MENU
            if (source.equals(docm.getBtnBack())) {
                // CUSTOMER MENU
                currentView = "2";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(docm.getBtnConfirmDelete())) {

            }
        } else if (currentView.equals("4")) {
            // DRIVER MAIN MENU
            if (source.equals(drvm.getBtnProfile())) {
                // PROFILE MENU
                currentView = "77";
                view.getCardlayout().show(mainPanel, "7");
            } else if (source.equals(drvm.getBtnSignOut())) {
                // MAIN MENU
                currentView = "0";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(drvm.getBtnTake())) {
                // TAKE ORDER MENU
                currentView = "8";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(drvm.getBtnView())) {
                // VIEW ORDER MENU
                currentView = "100";
                view.getCardlayout().show(mainPanel, "10");
            }
        } else if (currentView.equals("5")) {
            // FEEDBACK MENU
            if (source.equals(fbcm.getBtnBack())) {
                // CUSTOMER MENU
                currentView = "2";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(fbcm.getBtnFeedback())) {

            }
        } else if (currentView.equals("6")) {
            // FOODCOURIER ORDER MENU
            if (source.equals(fdcm.getBtnBack())) {
                // CUSTOMER MENU
                currentView = "2";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(fdcm.getBtnCreateOrder())) {

            }
        } else if (currentView.equals("7") || currentView.equals("77")) {
            // PROFILE MENU
            if (source.equals(pm.getBtnBack())) {
                if (currentView.equals("7")) {
                    // CUSTOMER MENU
                    currentView = "2";
                    view.getCardlayout().show(mainPanel, currentView);
                } else if (currentView.equals("77")) {
                    // DRIVER MENU
                    currentView = "4";
                    view.getCardlayout().show(mainPanel, currentView);
                }
            } else if (source.equals(pm.getBtnEdit())) {

            }
        } else if (currentView.equals("8")) {
            // TAKE ORDER MENU
            if (source.equals(tom.getBtnBack())) {
                // DRIVER MENU
                currentView = "4";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(tom.getBtnTakeOrder())) {

            }
        } else if (currentView.equals("9")) {
            // TRANSPORTATION ORDER MENU
            if (source.equals(tm.getBtnBack())) {
                // CUSTOMER MENU
                currentView = "2";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(tm.getBtnOrder())) {

            }
        } else if (currentView.equals("10") || currentView.equals("100")) {
            // VIEW ORDER MENU
            if (source.equals(vom.getBtnBack())) {
                if (currentView.equals("10")) {
                    // CUSTOMER MENU
                    currentView = "2";
                    view.getCardlayout().show(mainPanel, currentView);
                } else if (currentView.equals("100")) {
                    // DRIVER MENU
                    currentView = "4";
                    view.getCardlayout().show(mainPanel, currentView);
                }
            }
        } else if (currentView.equals("11")) {
            // SIGN IN MENU
            if (source.equals(sim.getBtnBack())) {
                currentView = "0";
                view.getCardlayout().show(mainPanel, currentView);
            } else if (source.equals(sim.getBtnSignIn())) {
                
            }
        } else if (currentView.equals("12")) {
            // SIGN UP MENU
            if (source.equals(sum.getBtnBack())) {
                currentView = "0";
                view.getCardlayout().show(mainPanel, currentView);                
            } else if (source.equals(sum.getBtnSignUp())) {
                
            }
        } else if (currentView.equals("13")) {
            // REGISTERED ACCOUNT MENU
            if (source.equals(ram.getBtnBack())) {
                currentView = "0";
                view.getCardlayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("14")) {
            // DELETE ACCOUNT MENU
            if (source.equals(dam.getBtnBack())) {
                currentView = "0";
                view.getCardlayout().show(mainPanel, currentView);                
            } else if (source.equals(dam.getBtnDel())) {
                
            } else if (source.equals(dam.getBtnRefresh())) {
                
            }
        }
    }
}
