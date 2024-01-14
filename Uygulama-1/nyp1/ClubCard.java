package nyp1;

public class ClubCard {
	
	private static int counter=2023001;
	private final int ID;
	private double credit;
	Sports sp[]=new Sports[7];
	
	public ClubCard(double credit) {
		this.credit = credit;
		this.ID = counter;
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

	public void registerCourse(Sports s) {
		int i=0;
		while(i<sp.length && sp[i]!=null)
			i++;
		
		if(i>=sp.length)
			System.out.println("you can enroll max of 7 courses");
		else {
			sp[i]=s;
			System.out.println("Registered to course: " + sp[i].getName() );
		}
		
		
	}

	public void listCourses() {
		int i=0;
		while(i<sp.length && sp[i]!=null) {
			System.out.println(i+1 +"."+ sp[i].getName());
			i++;
		}
			
		
		
	}
	
	
	
	

}
