package oguzhanesgiyusufo;

import java.io.Serializable;

public class Subscription implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DateInfo dates;
	private PaymentInfo payments;
	private int copies;
	private final Journal journal;
	private final Subscriber subscriber;
	
	public Subscription(DateInfo dates, int copies, Journal journal, Subscriber subscriber) {
		super();
		this.dates = dates;
		this.copies = copies;
		this.journal = journal;
		this.subscriber = subscriber;
		this.payments = new PaymentInfo(0.1, 0);
	}
	
	public void acceptPayment(double amount) {
		payments.increasePayment(amount);
		System.out.println("Payment accepted for " + journal.getName());
	}
	
	public boolean canSend(int issueMonth, int issueYear) {
		double totalReceivedPayment = payments.getReceivedPayment();
		double requiredPayment = copies * journal.getIssuePrice();
		
		return totalReceivedPayment>=requiredPayment && dates.getEndMonth() >= issueMonth && dates.getEndYear() >= issueYear;
	}
	
	public double getRequiredPayment() {
		return copies * journal.getIssuePrice();
	}
	public PaymentInfo getPayments() {
		return payments;
	}

	public void setPayments(PaymentInfo payments) {
		this.payments = payments;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public DateInfo getDates() {
		return dates;
	}

	public Journal getJournal() {
		return journal;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	@Override
	public String toString() {
		return "Subscription [dates=" + dates + ", payments=" + payments + ", copies=" + copies + ", journal=" + journal
				+ ", subscriber=" + subscriber + "]";
	}
}
