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
    private String courierId;
    private String receiverName;
    private String receiverNumber;
    
    public Courier(int type, String courierId, String position, String destination, int distance, String detail) {
        super(type, position, destination, distance, detail);
        this.courierId = courierId;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public String getId() {
        return courierId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }    
}
