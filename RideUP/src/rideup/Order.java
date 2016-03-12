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
    private String orderId;
    private String position;
    private String destination;
    private int distance;
    private long price;
    private boolean status = false;
    private String detail;
    private int type;
      
    public Order(int type, String orderId, String position, String destination, int distance, String detail) {
        this.orderId = orderId;
        this.position = position;
        this.destination = destination;
        this.distance = distance;
        this.detail = detail;
        this.type=type;
    }
    
    public Order(int type, String position, String destination, int distance, String detail) {
        this.position = position;
        this.destination = destination;
        this.distance = distance;
        this.detail = detail;
         this.type=type;
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
        return price;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean IsTaken() {
        return status;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    public String getDetail() {
        return detail;
    }
    
    public int getType() {
        return type;
    }
}
