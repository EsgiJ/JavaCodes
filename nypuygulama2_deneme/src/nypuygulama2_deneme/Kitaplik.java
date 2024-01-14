package nypuygulama2_deneme;

public class Kitaplik {
	Raf raf[];

	public Kitaplik(int n) {
		this.raf  = new Raf[n];
		for (int i = 0; i < raf.length; i++){
            raf[i] = new Raf();
        }
	}
	public void kitapEkle(Kitap kitap1, int rafNo) {
		raf[rafNo].KitapEkle(kitap1);
	}
	public void kitapSil(int rafNo, int sıraNo) {
		raf[rafNo].kitapSil(sıraNo);
	}
	public void kitapSil(int rafNo, Kitap kitap1) {
		raf[rafNo].kitapSil(kitap1);
	}
	public int kitapAra(Kitap kitapAdı) {
		int i = 0;
		int n = raf.length;
		for(i=0; i<n; i++) {
			for (Kitap kitap : raf[i].getKitaplar()) {
				if(kitap!=null && kitap.getAd().equals(kitapAdı)) {
					System.out.println("Aranan kitap " + i + ". rafta bulunuyor.");
					return i;
				}
			}
		}
		System.out.println("Aradıgınız kitap bulunumadı!");
		return -1;
	}
	public void rafGoster(int rafNo) {
		raf[rafNo].RafGoster();
	}
	public void tumRaflariGoster() {
		int i=0;
		for(i=0; i<raf.length;i++) {
			raf[i].RafGoster();
		}
	}

}
