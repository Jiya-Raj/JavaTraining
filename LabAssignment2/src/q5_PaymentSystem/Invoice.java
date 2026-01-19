package q5_PaymentSystem;

public class Invoice implements Payable {
	private String invoiceId;
	private String itemDesc;
	private int quantity;
	private int pricePerUnit;

	public Invoice(String invoiceId, String itemDesc, int quantity, int pricePerUnit) {
		this.invoiceId = invoiceId;
		this.itemDesc = itemDesc;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public String getInvoiceDesc() {
		return itemDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	@Override
	public int getPayment() {
		return quantity * pricePerUnit;
	}
}
