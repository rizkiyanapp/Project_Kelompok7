/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author NANON
 */
public class Courier extends Order implements Serializable {
    private String receiverName;
    private String receiverNumber;
    static int nCourier;
    
    public Courier(String courierId, String position, String destination, int distance, String detail) {
        super(courierId, position, destination, distance, detail);
        nCourier++;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    @Override
    public String toString() {
        return ("Courier Order \n" +
                "ID : " + getId() + "\n" +
                "From : " + getPosition() + "\n" +
                "To : " + getDestination() + " (" + receiverName + ", " + receiverNumber + ")" + "\n" +
                "Distance : "+ getDistance() + "Km \n");
    }

    public static void setnCourier(int nCourier) {
        Courier.nCourier = nCourier;
    }
}
