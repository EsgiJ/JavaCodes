package inheritanceEx;

public class TestDers {

	public static void main(String[] args) {
	
		Ders ders1=new Ders("İş Sağlığı", 75, 95);
		System.out.println(ders1.hesaplaNot());
		
		ZorunluDers zd1=new ZorunluDers("BBG", 80,90, 100);
		//Ders zd1 = new ZorunluDers("BBG", 80,90, 100); //şeklinde de nesne oluşturabiliriz.
		System.out.println(zd1.hesaplaNot());
		
		SecmeliDers sd1=new SecmeliDers("Mobil Prog.",50, 60, 70, 80);
		System.out.println(sd1.hesaplaNot());
		
		
		

	}

}
