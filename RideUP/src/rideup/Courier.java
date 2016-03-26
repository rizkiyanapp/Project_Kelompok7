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
public class Courier extends Order {
    private String receiverName;
    private String receiverNumber;
    static int nCourier = 0;
    
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
        return ("ID : " + getId() + "  |  From : " + getPosition() + "  |  To : " + getDestination() + " (" + receiverName + ", " + receiverNumber + ")  |  " + getDistance() + "Km");
    }
}
