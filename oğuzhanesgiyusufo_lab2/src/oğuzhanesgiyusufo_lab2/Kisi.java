package oğuzhanesgiyusufo_lab2;

public abstract class Kisi {
	protected String ad;
	protected int id;
	protected double bakiye;
	public Kisi(String ad, int id, double bakiye) {
		this.ad = ad;
		this.id = id;
		this.bakiye = bakiye;
	}
	public abstract boolean odemeYap(double fiyat);
	@Override
	public String toString() {
		return "Kisi [ad=" + ad + ", id=" + id + ", bakiye=" + bakiye + "]";
	}

	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBakiye() {
		return bakiye;
	}
	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}
	
	
}
