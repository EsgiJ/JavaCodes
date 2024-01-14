package oğuzhanesgiyusufo_lab2;

public class Abonman extends Kisi{
	private int kredi;

	public Abonman(String ad, int id, double bakiye, int kredi) {
		super(ad, id, bakiye);
		this.kredi = kredi;
	}
	public boolean odemeYap(double fiyat) {
		if(getKredi()>=5) {
			System.out.println("Krediyle odeme yapildi.");
			setKredi(getKredi()-5);
			return true;
		}
		else if(getKredi()<5 && getBakiye()>=fiyat) {
			System.out.println("Bakiyeyle odeme yapildigi icin 1 kredi kazandiniz.");
			setKredi(getKredi()+1);
			setBakiye(getBakiye()-fiyat);
			return true;
		}
		else {
			System.out.println("Odeme basarisiz.");
			return false;
		}
	}
	@Override
	public String toString() {
		return super.toString() + "Abonman [kredi=" + kredi + "]";
	}

	public int getKredi() {
		return kredi;
	}

	public void setKredi(int kredi) {
		this.kredi = kredi;
	}
	
}
