package rideup;
public class FoodCourier extends Order{
    private Food foodOrder;
    private int qty;
    private long price;
    static int nFoodCourier = 0;
    
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
    }

    public int getQty() {
        return qty;
    }
    
    public void removeFood() {
        foodOrder = null;
    }

    public long getPrice() {
        price = getFoodOrder().getPrice() * qty;
        price = price + super.getPrice();
        return price;
    }
}
