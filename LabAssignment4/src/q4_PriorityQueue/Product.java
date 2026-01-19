package q4_PriorityQueue;

public class Product {
	public int productId;
	public String productName;
	public double productPrice;

	public Product(int id, String name, double price) {
		this.productId = id;
		this.productName = name;
		this.productPrice = price;
	}

	@Override
	public String toString() {
		return "Product name: " + productName + " Id: " + productId + " Price: " + productPrice;
	}

}
