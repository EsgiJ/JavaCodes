package oguzhanesgiyusufo;

import java.io.Serializable;

public abstract class Subscriber implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String adress;
	
	public Subscriber(String name, String adress) {
		super();
		this.name = name;
		this.adress = adress;
	}
	
	public abstract String getBillingInformation();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
}
