package q4_PriorityQueue;

import java.util.PriorityQueue;

public class Main {
 public static void main(String[] main) {
	 PriorityQueue<Product> pq=new PriorityQueue<>((prod1,prod2)->(int)prod1.productPrice-(int)prod2.productPrice);
	 
	 //adding products to the priority queue
	 pq.add(new Product(1,"Pen",10.0));
	 pq.add(new Product(2,"Notebook",25.0));
	 pq.add(new Product(3,"bag",400.0));
	 pq.add(new Product(4,"Laptop",6000.0));
	 pq.add(new Product(5,"Pencil",5.0));
	 
	 //empty out elements
	 while(!pq.isEmpty()) {
		 Product product =pq.poll();
		 System.out.println("Processing product: "+product.productName+" ("+product.productPrice+") Rupees");
	 }
 }
}
