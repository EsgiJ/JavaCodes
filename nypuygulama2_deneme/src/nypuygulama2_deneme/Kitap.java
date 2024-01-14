package nypuygulama2_deneme;

public class Kitap {
	private String ad;
	private String yazarString;
	private String ISBN;
	private double fiyat;
	private static int kitapSayisi;
	
	public Kitap(String ad, String yazarString, String iSBN) {
		this.ad = ad;
		this.yazarString = yazarString;
		ISBN = iSBN;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getYazarString() {
		return yazarString;
	}

	public void setYazarString(String yazarString) {
		this.yazarString = yazarString;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public static int getKitapSayisi() {
		return kitapSayisi;
	}

	public static void setKitapSayisi(int kitapSayisi) {
		Kitap.kitapSayisi = kitapSayisi;
	}
	
	
}
