package oguzhanesgiyusufo;

import java.io.Serializable;

public class PaymentInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double discountRatio;
	private double receivedPayment;
	
	public PaymentInfo(double discountRatio, double receivedPayment) {
		super();
		this.discountRatio = discountRatio;
		this.receivedPayment = receivedPayment;
	}
	
	public void increasePayment(double amount) {
		receivedPayment += amount;
		System.out.println("Payment increased by " + amount);
	}
	public double getReceivedPayment() {
		return receivedPayment;
	}

	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setReceivedPayment(double receivedPayment) {
		this.receivedPayment = receivedPayment;
	}
	
}