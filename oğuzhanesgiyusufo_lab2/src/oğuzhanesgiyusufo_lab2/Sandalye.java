package oğuzhanesgiyusufo_lab2;

public class Sandalye {
	private int no;
	private boolean doluluk=false;
	private final int ucret = 15;
	public Sandalye(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Sandalye [no=" + no + ", doluluk=" + doluluk + ", ucret=" + ucret + "]";
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public boolean isDoluluk() {
		return doluluk;
	}
	public void setDoluluk(boolean doluluk) {
		this.doluluk = doluluk;
	}
	public int getUcret() {
		return ucret;
	}
	
	
	
}
