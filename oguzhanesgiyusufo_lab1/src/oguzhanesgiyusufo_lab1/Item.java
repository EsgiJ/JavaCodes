package oguzhanesgiyusufo_lab1;

public class Item {
	private int barcodeNo;
	private String name;
	private double price;
	
	public Item(int barcodeNo, String name, double price) {
		this.barcodeNo = barcodeNo;
		this.name = name;
		this.price = price;
	}
	
	public int getBarcodeNo() {
		return barcodeNo;
	}
	public void setBarcodeNo(int barcodeNo) {
		this.barcodeNo = barcodeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return ("Item Basket ID: " + this.barcodeNo + " name: " + name + " price: " + price );
	}
	
	
	
	
}
