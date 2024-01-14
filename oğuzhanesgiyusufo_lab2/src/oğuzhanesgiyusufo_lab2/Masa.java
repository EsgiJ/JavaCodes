package oğuzhanesgiyusufo_lab2;


public class Masa {
	Sandalye sandalyeler[];

	public Masa() {
		this.sandalyeler = new Sandalye[3];
		for (int i = 0; i < sandalyeler.length; i++){
            sandalyeler[i] = new Sandalye(i);
        }
		
	}
	public void sandalyeEkle(Sandalye sandalye1) {
		int i = 0;
		while(i<sandalyeler.length && sandalyeler[i]!=null) {
			i++;
		}
		if(i!=sandalyeler.length) {
			sandalyeler[i] = sandalye1;
		}
	}
	public void sandalyeEkle(Sandalye sandalye1, int sandalyeNo) {
		if(sandalyeler[sandalyeNo]!= null && sandalyeNo < sandalyeler.length) {
			sandalyeler[sandalyeNo] = sandalye1; 			
		}
	}
	public void sandalyeSil(Sandalye sandalye1) {
		int i = 0;
		while(i<sandalyeler.length && sandalyeler[i]!=sandalye1) {
			i++;
		}
		if(i!=sandalyeler.length) {
			sandalyeler[i] = null;
		}
	}
	public void masaDolulukGoster() {
		int i = 0;
		for(i=0; i<sandalyeler.length;i++) {
			System.out.println("Sandalye [no="+ (i+1) + ", doluluk=" + sandalyeler[i].isDoluluk() + "]" );
		}
	}
	public Sandalye[] getSandalyeler() {
		return sandalyeler;
	}
	public void setSandalyeler(Sandalye[] sandalyeler) {
		this.sandalyeler = sandalyeler;
	}
	
}
