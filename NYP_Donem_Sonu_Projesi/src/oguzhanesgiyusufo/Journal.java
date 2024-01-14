package oguzhanesgiyusufo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Journal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String iSSN;
	private int frequency;
	private double issuePrice;
	private List<Subscription> subscriptions = new ArrayList<Subscription>();
	
	public Journal(String name, String iSSN, int frequency, double issuePrice) {
		super();
		this.name = name;
		this.iSSN = iSSN;
		this.frequency = frequency;
		this.issuePrice = issuePrice;
	}

	public void addSubscription(Subscription subscription) {
		if (isValidSubscription(subscription)&&subscription!=null) {
			subscriptions.add(subscription);
			System.out.println(subscription.getSubscriber().getName() + " subscribed to " + name);
		}else {
			System.out.println("Invalid subscription. Subscription not added for " + name);
		}
	}
	
	private boolean isValidSubscription(Subscription subscription) {
		return subscription.getSubscriber()!=null && subscription.getJournal()!=null;
	}
	
	public Subscription searchSubscription(Subscriber subscriber) {
	    for (Subscription subscription : subscriptions) {
	        if (subscription.getSubscriber().equals(subscriber)) {
	            return subscription;
	        }
	    }
	    return null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getiSSN() {
		return iSSN;
	}

	public void setiSSN(String iSSN) {
		this.iSSN = iSSN;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public double getIssuePrice() {
		return issuePrice;
	}

	public void setIssuePrice(double issuePrice) {
		this.issuePrice = issuePrice;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
}
