package oğuzhanesgiyusufo_lab2;


public class KitapKafe {
	Masa masalar[];

	public KitapKafe(int masaSayisi) {
		this.masalar = new Masa[masaSayisi];
		for (int i = 0; i < masalar.length; i++){
            masalar[i] = new Masa();
		}
	}
	public boolean yerAyir(Kisi kisi1){
		for(int i = 0; i<masalar.length; i++) {
			for(int j =0; j< masalar[i].sandalyeler.length; j++) {
					if(masalar[i].sandalyeler[j].isDoluluk()==false) {
						System.out.println(i+ ". masa " + j +". sandalyeye atandınız");
						kisi1.odemeYap(15);
						masalar[i].sandalyeler[j].setDoluluk(true);
						return true;
					}
				}
			}
		System.out.println("Yer bulunamadı.");
		return false;
	}
	
	public void tumMasalariGoster() {
		int i=0;
		for(i=0; i<masalar.length;i++) {
			System.out.println("Masa " + i);
			masalar[i].masaDolulukGoster();
		}
	}
	public void masaEkle(Masa masa1) {
		int i = 0;
		while(i<masalar.length && masalar[i]!=null) {
			i++;
		}
		if(i!=masalar.length) {
			masalar[i] = masa1;
		}
	}
	
}
