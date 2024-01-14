package inheritanceEx;

public class SecmeliDers extends Ders {
	private int vize2;
	private int proje;
	private int vize1=10000;

	
	public SecmeliDers(String dersAdi, int vize1, int vize2, int finalNot, int proje) {
		super(dersAdi, vize1, finalNot);
		this.vize2=vize2;
		this.proje=proje;
		
	}


	@Override
	public double hesaplaNot() {
		
//		System.out.println("Ders sınıfnda hesapla not sonucu:");
//		System.out.println(super.hesaplaNot());
		
		System.out.println("Secmeli Ders sınıfında hesaplanan not:");
		return super.vize1*0.25 + vize2*0.25 + finalNot*0.30 + proje*0.2 ;
		//vize1 için super keywordunu kullanmasaydık, bu sınıftaki vize1 değeri kullanılacaktı.
	}


	
	
	
	

}
