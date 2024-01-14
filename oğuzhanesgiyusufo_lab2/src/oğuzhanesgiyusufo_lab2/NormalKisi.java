package oğuzhanesgiyusufo_lab2;

public class NormalKisi extends Kisi{

	public NormalKisi(String ad, int id, double bakiye) {
		super(ad, id, bakiye);
		// TODO Auto-generated constructor stub
	}
	public boolean odemeYap(double fiyat) {
		if(getBakiye()>=fiyat) {
			System.out.println("Basariyla odeme yapildi.");
			setBakiye(getBakiye()-fiyat);
			return true;
		}
		else {
			System.out.println("Odeme basarisiz");
			return false;
		}
	}
}
