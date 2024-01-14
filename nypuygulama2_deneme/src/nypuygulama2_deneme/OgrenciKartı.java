package nypuygulama2_deneme;

public class OgrenciKartı extends Kart {
	private double bonus;
	public OgrenciKartı(int id, String sahip, double bakiye) {
		super(id, sahip, bakiye);
	}
	public boolean odemeYap(double fiyat) {
		if(getBakiye()>=fiyat) {
			setBakiye(getBakiye()-fiyat);
			bonus += fiyat*0.2;
			return true;
		}
		else if(getBonus()>fiyat) {
			System.out.println("Bonuslar ile ödeme gerçekleşti.");
			setBonus(getBonus()-fiyat);
			return true;
		}
		else {
			return false;
		}
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
}
