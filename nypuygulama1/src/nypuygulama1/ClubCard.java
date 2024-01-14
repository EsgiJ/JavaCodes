package nypuygulama1;

public class ClubCard {
	private static int counter = 2023001;
	final int ID;
	double credit;
	Sports sp[] = new Sports[7];
	
	public ClubCard(double credit) {
		this.ID = counter;
		this.credit = credit;
		counter++;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		ClubCard.counter = counter;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public Sports[] getSp() {
		return sp;
	}
	public void setSp(Sports[] sp) {
		this.sp = sp;
	}
	public int getID() {
		return ID;
	}
	public void registerCourse(Sports s1) {
		int i = 0;
		while(i<sp.length && sp[i]!=null)
			i++;
		if (i>=sp.length) {
			System.out.println("Maximum course to register is " + sp.length);
		}
		else {
			sp[i] = s1;
			System.out.println("Registered to course " + sp[i].getName());
		}
	}
	public void listCourses() {
		int i = 0;
		while(i<sp.length && sp[i]!=null) {
			System.out.println((i+1) + ". "+ sp[i].getName());
			i++;
		}
		
	}
	
}
