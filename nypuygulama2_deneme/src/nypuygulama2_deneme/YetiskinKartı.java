package nypuygulama2_deneme;

public class YetiskinKartı extends Kart {

	public YetiskinKartı(int id, String sahip, double bakiye) {
		super(id, sahip, bakiye);
		// TODO Auto-generated constructor stub
	}
	public boolean odemeYap(double fiyat) {
		if(getBakiye()>=fiyat) {
			setBakiye(getBakiye()-fiyat);
			return true;
		}
		else {
			return false;
		}
	}
	
}
