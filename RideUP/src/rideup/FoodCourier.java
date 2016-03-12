package rideup;
public class FoodCourier extends Order{
    private Food foodOrder;
    private String foodCourierId;
    private int qty;
    private long price;
    
    public FoodCourier(int type, String foodCourierId, String position, String destination, int distance, String detail) {
        super(type, position, destination, distance, detail);
        this.foodCourierId = foodCourierId;
    }

    public Food getFoodOrder() {
        return foodOrder;
    }

    public String getId() {
        return foodCourierId;
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
