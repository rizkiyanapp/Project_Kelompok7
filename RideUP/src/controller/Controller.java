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
    private String currentViewMain;
    private String currentViewSub;
    private JPanel mainPanel;
    private JPanel subMainPanel;

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
        sim.addListener(this);
        sum.addListener(this);
        sum.addAdapter(this);
        tom.addListener(this);
        tom.addAdapter(this);
        tm.addListener(this);
        tm.addAdapter(this);
        vom.addListener(this);
        vom.addAdapter(this);

        subMainPanel = mm.getMenuPanel();
        subMainPanel.add(sim, "0");
        subMainPanel.add(sum, "1");
        subMainPanel.add(ram, "2");
        subMainPanel.add(dam, "3");
        currentViewSub = "0";

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
        currentViewMain = "0";

        view.getCardlayout().show(mainPanel, currentViewMain);
        view.setVisible(true);

        mm.getCardLayout().show(subMainPanel, currentViewSub);
        mm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (currentViewMain.equals("0")) {
            // MAIN MENU
            if (source.equals(mm.getBtnDelAcc())) {
                // DELETE ACCOUNT MENU
                currentViewSub = "3";
                mm.getCardLayout().show(subMainPanel, currentViewSub);
                if (source.equals(dam.getBtnDel())) {

                } else if (source.equals(dam.getBtnRefresh())) {

                }
            } else if (source.equals(mm.getBtnExit())) {
                // EXIT PROGRAM
                System.exit(0);
            } else if (source.equals(mm.getBtnRegAcc())) {
                // REGISTERED ACCOUNT MENU
                currentViewSub = "2";
                mm.getCardLayout().show(subMainPanel, currentViewSub);
            } else if (source.equals(mm.getBtnSignIn())) {
                // SIGN IN MENU
                currentViewSub = "0";
                mm.getCardLayout().show(subMainPanel, currentViewSub);
                currentViewMain = "4";
                view.getCardlayout().show(mainPanel, currentViewMain);
                if (source.equals(sim.getBtnSignIn())) {

                }
            } else if (source.equals(mm.getBtnSignUp())) {
                // SIGN UP MENU
                currentViewSub = "1";
                mm.getCardLayout().show(subMainPanel, currentViewSub);
                if (source.equals(sum.getBtnSignUp())) {

                }
            }
        } else if (currentViewMain.equals("1")) {
            // COURIER ORDER MENU
            if (source.equals(crm.getBtnBack())) {
                currentViewMain = "2";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(crm.getBtnCreateOrder())) {

            }
        } else if (currentViewMain.equals("2")) {
            // CUSTOMER MAIN MENU
            if (source.equals(cstm.getBtnCourier())) {
                currentViewMain = "1";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(cstm.getBtnDelOrder())) {
                currentViewMain = "3";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(cstm.getBtnFeedback())) {
                currentViewMain = "5";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(cstm.getBtnFoodCourier())) {
                currentViewMain = "6";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(cstm.getBtnProfile())) {
                currentViewMain = "7";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(cstm.getBtnSignOut())) {
                currentViewMain = "0";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(cstm.getBtnTransport())) {
                currentViewMain = "9";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(cstm.getBtnView())) {
                currentViewMain = "10";
                view.getCardlayout().show(mainPanel, currentViewMain);
            }
        } else if (currentViewMain.equals("3")) {
            // DELETE ORDER MENU
            if (source.equals(docm.getBtnBack())) {
                currentViewMain = "2";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(docm.getBtnConfirmDelete())) {

            }
        } else if (currentViewMain.equals("4")) {
            // DRIVER MAIN MENU
            if (source.equals(drvm.getBtnProfile())) {
                currentViewMain = "77";
                view.getCardlayout().show(mainPanel, "7");
            } else if (source.equals(drvm.getBtnSignOut())) {
                currentViewMain = "0";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(drvm.getBtnTake())) {
                currentViewMain = "8";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(drvm.getBtnView())) {
                currentViewMain = "100";
                view.getCardlayout().show(mainPanel, "10");
            }
        } else if (currentViewMain.equals("5")) {
            // FEEDBACK MENU
            if (source.equals(fbcm.getBtnBack())) {
                currentViewMain = "2";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(fbcm.getBtnFeedback())) {

            }
        } else if (currentViewMain.equals("6")) {
            // FOODCOURIER ORDER MENU
            if (source.equals(fdcm.getBtnBack())) {
                currentViewMain = "2";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(fdcm.getBtnCreateOrder())) {

            }
        } else if (currentViewMain.equals("7") || currentViewMain.equals("77")) {
            // PROFILE MENU
            if (source.equals(pm.getBtnBack())) {
                if (currentViewMain.equals("7")) {
                    currentViewMain = "2";
                    view.getCardlayout().show(mainPanel, currentViewMain);
                } else if (currentViewMain.equals("77")) {
                    currentViewMain = "4";
                    view.getCardlayout().show(mainPanel, currentViewMain);
                }
            } else if (source.equals(pm.getBtnEdit())) {

            }
        } else if (currentViewMain.equals("8")) {
            // TAKE ORDER MENU
            if (source.equals(tom.getBtnBack())) {
                currentViewMain = "4";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(tom.getBtnTakeOrder())) {

            }
        } else if (currentViewMain.equals("9")) {
            // TRANSPORTATION ORDER MENU
            if (source.equals(tm.getBtnBack())) {
                currentViewMain = "2";
                view.getCardlayout().show(mainPanel, currentViewMain);
            } else if (source.equals(tm.getBtnOrder())) {

            }
        } else if (currentViewMain.equals("10") || currentViewMain.equals("100")) {
            // VIEW ORDER MENU
            if (source.equals(vom.getBtnBack())) {
                if(currentViewMain.equals("10")) {
                currentViewMain = "2";
                view.getCardlayout().show(mainPanel, currentViewMain);                    
                } else if (currentViewMain.equals("100")) {
                currentViewMain = "4";
                view.getCardlayout().show(mainPanel, currentViewMain);                    
                }
            }
        }
    }
}
