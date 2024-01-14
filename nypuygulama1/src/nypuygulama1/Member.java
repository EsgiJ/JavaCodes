package nypuygulama1;


public class Member {
	String name;
	double credit;
	ClubCard card;
	public Member(String nameString, double credit) {
		this.name = nameString;
		this.credit = credit;
		card = new ClubCard(credit);
	}
	public String getNameString() {
		return name;
	}
	public void setNameString(String nameString) {
		this.name = nameString;
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
		System.out.println(name + " " + card.ID);
	}
	public void registerCourse(Sports s1) {
		card.registerCourse(s1);
		
	}
	public void listCourses() {
		card.listCourses();
	}
}
