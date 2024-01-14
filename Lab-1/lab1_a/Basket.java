package lab1_a;

public class Basket {
	private int ID;
	private Item items[]=new Item[2];
	private MarketCard card;
	
	
	public Basket(int ID) {
		this.ID = ID;
	}


	public void addItem(Item it1) {
		int i=0;
		while(i<items.length && items[i]!=null)
			i++;
		
		if(i<items.length) 
			items[i] = it1;
		else
			System.out.println("You've reached the maximum amount of items in your basket");
		
	}


	public void basketInfo() {
		int count=0,i=0;
		double total=0;
		
		while(i<items.length && items[i]!=null) {
			count++;
			total += items[i].getPrice();
			i++;
			
		}
		System.out.println("Basket ID:"+ ID +"   " + "Number of items:"+count+"   "+ "Total price:"+ total);
		
		if(card!=null) {
			double points = total * 0.10;
			card.addPoints(points);
		}
		
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

	
	
	
	

}
