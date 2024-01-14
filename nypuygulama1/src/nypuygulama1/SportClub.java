package nypuygulama1;

public class SportClub {

	public static void main(String[] args) {
		Sports s1 = new Sports("tennis", 10 , 25.90);
		Sports s2 = new Sports("football", 15 , 55.90);
		Sports s3 = new Sports("basketball", 20 , 45.90);
				
		Member m1 = new Member("Jane Doe", 100);
		m1.getInfo();
				
		Member m2 = new Member("John Doe", 200);
		m2.getInfo();
				
		m1.registerCourse(s1);
		m1.registerCourse(s2);
		m1.registerCourse(s3);
		m1.listCourses();
				
		System.out.println(m1);
		System.out.println(ClubCard.getCounter()); 
	}

}
