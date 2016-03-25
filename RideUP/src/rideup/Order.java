/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rideup;

/**
 *
 * @author Renes
 */
public class Order {
    private final String orderId;
    private String position;
    private String destination;
    private int distance;
    private long price;
    private boolean status = false;
    private String detail;
    private String feedback;
    static int nOrder = 0;
      
    public Order(String orderId, String position, String destination, int distance, String detail) {
        this.orderId = orderId;
        this.position = position;
        this.destination = destination;
        this.distance = distance;
        this.detail = detail;
        nOrder++;
    }
    
    public String getId() {
        return orderId;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public void setPrice(long price) {
        this.price = price;
    }
    
    public long getPrice() {
        price = price * distance;
        return price;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean isTaken() {
        return status;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    public String getDetail() {
        return detail;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
