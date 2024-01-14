package oguzhanesgiyusufo_lab1;

public class Basket {
	private int ID;
	private Item items[] = new Item[2];
	private MarketCard card = new MarketCard(ID);
	
	
	public Basket(int iD) {
		ID = iD;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public MarketCard getCard() {
		return card;
	}
	public void setCard(MarketCard card) {
		this.card = card;
	}
	
	public static void main(String[] args) {
		MarketCard mc = new MarketCard(110110);
		
		Basket b1 = new Basket(101);
		Basket b2 = new Basket(102);
		
		Item item1 = new Item(1000011, "milk", 30);
		Item item2 = new Item(1000012, "cheese", 100);
		Item item3 = new Item(1000013, "bread", 8);
		
		System.out.println(item1);
		
		b1.addItem(item1);
		b1.addItem(item2);
		b1.addItem(item3);
		b2.setCard(mc);
		b2.basketInfo();
		
		System.out.println(mc.getPoints());
	}

	private void basketInfo() {
		int sum = 0;
		int itemCount = 0;
		int i = 0;
		while(i<items.length && items[i]!=null) {
			sum += items[i].getPrice();
			itemCount++;
			i++;
		}
		System.out.println("Basket ID: " + ID + " Number of items: " + (itemCount+1) + " Total price: " + sum);
		card.addPoints(sum/10);
	}

	private void addItem(Item item1) {
		int i = 0;
		while(i<items.length && items[i]!=null)
			i++;
		if(i>=items.length)
			System.out.println("Sepet en fazla iki urun alabilir!");
		else {
			items[i] = item1;
			
		}
	
		
	}
	
}
