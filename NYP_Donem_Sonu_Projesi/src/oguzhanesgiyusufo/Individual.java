package oguzhanesgiyusufo;

public class Individual extends Subscriber {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String creditCardNr;
	private int expireMonth;
	private int expireYear;
	private int CCV;
	
	public Individual(String name, String adress, String creditCardNr, int expireMonth, int expireYear, int cCV) {
		super(name, adress);
		this.creditCardNr = creditCardNr;
		this.expireMonth = expireMonth;
		this.expireYear = expireYear;
		CCV = cCV;
	}

	@Override
	public String getBillingInformation() {
		String billinginformation;
		billinginformation = "Credit Card Number: " + creditCardNr + " Expire Month: " + expireMonth + " Expire Year"
		+ expireMonth + "CCV: " + CCV;
		return billinginformation;
	}

	public String getCreditCardNr() {
		return creditCardNr;
	}

	public void setCreditCardNr(String creditCardNr) {
		this.creditCardNr = creditCardNr;
	}

	public int getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(int expireMonth) {
		this.expireMonth = expireMonth;
	}

	public int getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(int expireYear) {
		this.expireYear = expireYear;
	}

	public int getCCV() {
		return CCV;
	}

	public void setCCV(int CCV) {
		this.CCV = CCV;
	}
}
