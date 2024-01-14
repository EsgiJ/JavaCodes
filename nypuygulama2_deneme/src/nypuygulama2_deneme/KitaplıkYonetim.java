package nypuygulama2_deneme;

public class KitaplıkYonetim {
	Kitaplik kitaplik;

	public KitaplıkYonetim(Kitaplik kitaplik) {
		this.kitaplik = kitaplik;
	}
	
	public boolean kitapSat(Kitap kitap1, Kart kart1){
		int rafNo = kitaplik.kitapAra(kitap1);
		if(rafNo == -1) {
			System.out.println("Aradıgınız kitap bulunamadı");
			return false;
		}
		else if(kart1.odemeYap(kitap1.getFiyat())) {
			kitaplik.kitapSil(rafNo, kitap1);
			System.out.println("Satış gerçekleşti.");
			return true;
		}
		else {
			System.out.println("Bakiye yetersiz!");
			return false;
		}
	}
}
