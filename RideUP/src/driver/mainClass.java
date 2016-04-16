/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import controller.Controller;
import viewConsole.Console;
import model.Application;

/**
 *
 * @author NANON
 */
public class mainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application app = new Application();
        Console view = new Console(app);
        new Controller(app);
        
//        view.mainMenu();
    }
    
}
