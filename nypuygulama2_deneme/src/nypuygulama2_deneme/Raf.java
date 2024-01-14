package nypuygulama2_deneme;

public class Raf {
	Kitap kitaplar[];

	public Raf() {
		this.kitaplar = new Kitap[10];
	}

	public void KitapEkle(Kitap kitap1) {
		int i = 0;
		while(i<kitaplar.length && kitaplar[i]!=null) {
			i++;
		}
		if(i!=kitaplar.length) {
			kitaplar[i] = kitap1;
		}
	}
	public void kitapSil(int sıraNo) {
		if(sıraNo<kitaplar.length) {
			kitaplar[sıraNo] = null;
		}
	}
	public void kitapSil(Kitap kitap1) {
		int i = 0;
		while(i<kitaplar.length && kitaplar[i]!=kitap1) {
			i++;
		}
		if(i!=kitaplar.length) {
			kitaplar[i] = null;
		}
	}
	public void RafGoster() {
		int i = 0;
		for(i=0; i<kitaplar.length; i++) {
			System.out.println(kitaplar[i]);
		}
	}
	public Kitap[] getKitaplar() {
		return kitaplar;
	}

	public void setKitaplar(Kitap[] kitaplar) {
		this.kitaplar = kitaplar;
	}
	
	
}
