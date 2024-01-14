package nyp1;

public class Member {
	
	private String name;
	private double credit;
	ClubCard card;
	
	public Member(String name, double credit) {
		this.name = name;
		this.credit = credit;
		card = new ClubCard(credit);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public ClubCard getCard() {
		return card;
	}

	public void setCard(ClubCard card) {
		this.card = card;
	}

	public void getInfo() {
		System.out.println(name + " " + card.getID());
		
	}

	public void registerCourse(Sports s) {
		card.registerCourse(s);
		
	}

	public void listCourses() {
		card.listCourses();
		
	}

	
	//toString metodu, bir nesneyi String'e donusturmek demek degildir. Sadece nesne icerigini String olarak okumamizi saglar
	@Override
	public String toString() {
		return "Member [name=" + name + ", credit=" + credit + "]";
	}
	
	
	
	
	
	

}
