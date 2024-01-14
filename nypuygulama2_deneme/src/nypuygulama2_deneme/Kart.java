package nypuygulama2_deneme;


public abstract class Kart {
	private int id;
	private String Sahip;
	private double Bakiye;
	public Kart(int id, String sahip, double bakiye) {
		this.id = id;
		Sahip = sahip;
		Bakiye = bakiye;
	}
	@Override
	public String toString() {
		return "Kart [id=" + id + ", Sahip=" + Sahip + ", Bakiye=" + Bakiye + "]";
	}
	public abstract boolean odemeYap(double fiyat);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSahip() {
		return Sahip;
	}
	public void setSahip(String sahip) {
		Sahip = sahip;
	}
	public double getBakiye() {
		return Bakiye;
	}
	public void setBakiye(double bakiye) {
		Bakiye = bakiye;
	}
	
	
}
