package Q1;

public class Merchandise {
	private String itemId;
	private int quantity;
	private double price;

	public String getItemId() {
		return itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Merchandise(String itemId, int quantity, double price) {
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ItemId "+this.itemId+" quantity: "+this.quantity+" price: "+this.price;
	}

}
