package oguzhanesgiyusufo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class Distributor {
	private Hashtable<String, Journal>journals;
	private Vector<Subscriber>subscribers;
	
	public Distributor() {
		super();
		journals = new Hashtable<String, Journal>();
		subscribers = new Vector<Subscriber>();
	}

	public boolean addJournal(Journal journal) {
		if (journal!=null) {
			journals.put(journal.getiSSN(), journal);
			System.out.println("Journal" + journal.getName() + "is added to journals hashtable");
			return true;			
		}else {
			System.out.println("Journal is not added to journals hashtable");
			return false;
		}
	}
	
	public Journal searchJournal(String ISSN) {
		Journal journal = journals.get(ISSN);
		if (journal == null) {
			System.out.println("Journal is null for ISSN no: " + ISSN);
		}
		return journal;
	}
	public boolean addSubscriber(Subscriber subscriber) {
		if (subscriber!=null) {
			subscribers.add(subscriber);
			return true;
		}
		return false;
	}
	public Subscriber searchSubscriber(String name) {
		for (Subscriber subscriber : subscribers) {
			if (subscriber.getName().equals(name)) {
				return subscriber;
			}
		}
		return null;
	}
	public boolean addSubscription(String ISSN, Subscriber subscriber, Subscription subscription) {
	    // Journal'ı ara
	    Journal journal = searchJournal(ISSN);

	    // Eğer Journal bulunamazsa null dön
	    if (journal == null) {
	        System.out.println("Journal is not found!");
	        return false;
	    }

	    // Subscriber'ı ara
	    if (!subscribers.contains(subscriber)) {
	        subscribers.add(subscriber);
	    }

	    // Subscription ekleyerek kontrolü gerçekleştir
	    if (journal != null && subscriber != null) {
	        journal.addSubscription(subscription);
	        return true; // Başarıyla eklendi
	    } else {
	        return false; // Ekleme başarısız (örneğin, abonelik zaten var)
	    }
	}
	
	public ArrayList<Subscription> listAllSendingOrders(int month, int year) {
	    ArrayList<Subscription> sendingOrders = new ArrayList<Subscription>();

	    for (Journal journal : journals.values()) {
	        if (journal != null) {
	            for (Subscription subscription : journal.getSubscriptions()) {
	                if (subscription.canSend(month, year)) {
	                    System.out.println("Sending order for " + subscription.getSubscriber().getName());
	                    sendingOrders.add(subscription);
	                }
	            }
	        }
	    }

	    return sendingOrders;
	}
	public void listSendingOrders(String ISSN, int month, int year) {
        Journal journal = journals.get(ISSN);
        if (journal != null) {
            for (Subscription subscription : journal.getSubscriptions()) {
                if (subscription.canSend(month, year)) {
                    System.out.println("Sending order for " + subscription.getSubscriber().getName());
                }
            }
        }
    }
	
	public ArrayList<Subscription> listIncompletePayments() {
	    ArrayList<Subscription> incompleteSubscriptions = new ArrayList<>();

	    for (Journal journal : journals.values()) {
	        if (journal != null) {
	            for (Subscription subscription : journal.getSubscriptions()) {
	                double totalReceivedPayment = subscription.getPayments().getReceivedPayment();
	                double requiredPayment = subscription.getCopies() * subscription.getJournal().getIssuePrice();

	                if (totalReceivedPayment < requiredPayment) {
	                    System.out.println("Incomplete payment for " + subscription.getJournal().getName() +
	                            " by " + subscription.getSubscriber().getName());

	                    incompleteSubscriptions.add(subscription);
	                }
	            }
	        }
	    }

	    return incompleteSubscriptions;
	}
	
	public void listSubscriptionsBySubscriberName(String subscriberName) {
		for (Journal journal : journals.values()) {
        	if (journal != null) {
        		for (Subscription subscription : journal.getSubscriptions()) {
        			if (subscription.getSubscriber().getName().equals(subscriberName)) {
                        System.out.println("Subscription found for " + subscriberName + " to Journal: " +
                                subscription.getJournal().getName());
                    }
        		}
        	}
		}
	}
	public void listSubscriptionsByISSN(String ISSN) {
		for (Journal journal : journals.values()) {
        	if (journal != null) {
        		for (Subscription subscription : journal.getSubscriptions()) {
        			if (subscription.getJournal().getiSSN().equals(ISSN)) {
                        System.out.println("Subscription found for " + ISSN + " to Journal: " +
                                subscription.getJournal().getName());
                    }
        		}
        	}
		}
	}
	public void saveState(String fileName) {
	    ObjectOutputStream writer = null;
	    try {
	        writer = new ObjectOutputStream(new FileOutputStream(fileName));

	        writer.writeObject(journals);
	        writer.writeObject(subscribers);

	        writer.reset();
	        writer.flush();

	    } catch (IOException e) {
	        e.printStackTrace(System.err);
	    } finally {
	        if (writer != null) {
	            try {
	                writer.close();
	            } catch (IOException e) {
	                e.printStackTrace(System.err);
	            }
	        }
	    }
	}

	public void loadState(String fileName) {
	    ObjectInputStream reader = null;
	    // Mevcut verileri temizle
	    journals.clear();
	    subscribers.clear();
	    try {
	        reader = new ObjectInputStream(new FileInputStream(fileName));

	        // Journals'ları oku ve ekle
	        Object journalsObj = reader.readObject();
	        if (journalsObj instanceof Hashtable<?, ?>) {
	            Hashtable<String, Journal> journalsTable = (Hashtable<String, Journal>) journalsObj;
	            journals.putAll(journalsTable);
	        }

	        // Subscribers'ı oku ve ekle
	        Object subscribersObj = reader.readObject();
	        if (subscribersObj instanceof List<?>) {
	            subscribers.addAll((List<Subscriber>) subscribersObj);
	        }

	    } catch (ClassNotFoundException | IOException e) {
	        e.printStackTrace(System.err);
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace(System.err);
	            }
	        }
	    }
	}
	
	public ArrayList<Subscription> listExpiredSubscriptionsAfterGivenDate(int month, int year) {
	    ArrayList<Subscription> expiredSubscriptions = new ArrayList<Subscription>();

	    for (Journal journal : journals.values()) {
	        if (journal != null) {
	            for (Subscription subscription : journal.getSubscriptions()) {
	                if (subscription.getDates().getEndYear() < year &&  subscription.getPayments().getReceivedPayment() <= subscription.getRequiredPayment()) {
	                    System.out.println("Subscription is expiring after " + month + "." + year);
	                    expiredSubscriptions.add(subscription);
	                }
	                else if (subscription.getDates().getEndYear()== year) {
	                	if (subscription.getDates().getEndMonth()< month) {
	                		System.out.println("Subscription is expiring after " + month + "." + year);
	                		expiredSubscriptions.add(subscription);							
						}
	                }
	            }
	        }
	    }

	    return expiredSubscriptions;
	}
	
	public ArrayList<Subscription> listReceivedAnnuealPaymentSubscriptionsInGivenDate(int startYear, int endYear) {
	    ArrayList<Subscription> receivedAnnuealPaymentSubscriptions = new ArrayList<Subscription>();

	    for (Journal journal : journals.values()) {
	        if (journal != null) {
	            for (Subscription subscription : journal.getSubscriptions()) {
	                if (subscription.getDates().getStartYear() >= startYear &&  subscription.getDates().getEndYear() <= endYear) {
	                    System.out.println("Subscription's annua payment received in " + startYear + "-" + endYear);
	                    receivedAnnuealPaymentSubscriptions.add(subscription);
	                }              
	            }
	        }
	    }

	    return receivedAnnuealPaymentSubscriptions;
	}

	public Hashtable<String, Journal> getJournals() {
		return journals;
	}

	public void setJournals(Hashtable<String, Journal> journals) {
		this.journals = journals;
	}

	public Vector<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Vector<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}
}
