package rideup;

import java.io.Serializable;

public class FoodCourier extends Order implements Serializable {
    private Food foodOrder;
    private int qty;
    private long price;
    static int nFoodCourier;
    
    public FoodCourier(String foodCourierId, String position, String destination, int distance, String detail) {
        super(foodCourierId, position, destination, distance, detail);
        nFoodCourier++;
    }

    public Food getFoodOrder() {
        return foodOrder;
    }

    public void addFood(Food f, int qty) {
        foodOrder = f;
        this.qty = qty;
        this.price = ((f.getPrice() * qty) + super.getPrice());
    }

    public int getQty() {
        return qty;
    }
    
    public void removeFood() {
        foodOrder = null;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ("ID : " + getId() + "  |  Food : " + foodOrder.getName()+ "  |  Qty : " + qty + "  |  From : " + getPosition() + "  |  To : " + getDestination() + "  |  " + getDistance() + "Km");
    }

    public static void setnFoodCourier(int nFoodCourier) {
        FoodCourier.nFoodCourier = nFoodCourier;
    }
}
