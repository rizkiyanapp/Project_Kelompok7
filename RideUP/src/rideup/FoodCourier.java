package RideUp;
public class FoodCourier extends Order {
	private Food foodOrder;
	private String foodCourierld;
	private int qty;
	private long price;

	public FoodCourier (String foodCourierld, String position, String destination, int distance, String detail) {
		super(position, destination, distance, detail);
		this.foodCourierld=foodCourierld;
	}
	public void addFood(Food f, int qty) {
		this.foodOrder=f;
		this.qty=qty;
	}
	public void removeFood() {
		foodOrder=null;
	}
	public String getId() {
		return id;
	}
	public Food getFoodOrder() {
		return foodOrder;
	}
	public int getQty() {
		return qty;
	}
	public long getPrice() {
		return price;
	}
	}