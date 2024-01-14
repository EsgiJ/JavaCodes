package lab1_a;

public class MarketCard {
	private int cardNo;
	private double points=0;
	
	
	public MarketCard(int cardNo) {
		this.cardNo = cardNo;
	}


	public int getCardNo() {
		return cardNo;
	}


	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}


	public double getPoints() {
		return points;
	}


	public void setPoints(double points) {
		this.points = points;
	}


	public void addPoints(double points) {
		this.points += points;
		
	}


	
	
	

}
