package oguzhanesgiyusufo;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		Distributor distributor = new Distributor();

        Journal journal1 = new Journal("Sport Magazine", "ISSN1001", 12, 12.99);
        distributor.addJournal(journal1);
        
        Journal journal2 = new Journal("Science Magazine", "ISSN1002", 12, 19.99);
        distributor.addJournal(journal2);
        
        Journal journal3 = new Journal("Technology Magazine", "ISSN1003", 12, 24.99);
        distributor.addJournal(journal3);
        
        Journal journal4 = new Journal("Fashion Magazine", "ISSN1004", 12, 29.99);
        distributor.addJournal(journal4);
        
        Journal journal5 = new Journal("Travel Magazine", "ISSN1005", 12, 14.99);
        distributor.addJournal(journal5);

        Journal journal6 = new Journal("Food Magazine", "ISSN1006", 12, 17.99);
        distributor.addJournal(journal6);

        Journal journal7 = new Journal("Health Magazine", "ISSN1007", 12, 22.99);
        distributor.addJournal(journal7);

        Individual individualSubscriber1 = new Individual("Nuri Bilge Ceylan", "123 Main St",
                "1234-5678-9012-3456", 12, 2024, 314);
        distributor.addSubscriber(individualSubscriber1);
        
        Individual individualSubscriber2 = new Individual("Zeki Demirkubuz", "313 Main St",
                "1624-0888-9012-9006", 12, 2024, 314);
        distributor.addSubscriber(individualSubscriber2);

        Corporation corporateSubscriber1 = new Corporation("Riot Games", "456 Tech St",
                9876, "Riot Bank", 15, 5, 2023, 654321);
        distributor.addSubscriber(corporateSubscriber1);
        
        Corporation corporateSubscriber2 = new Corporation("IO Interactive", "873 Tech St",
                6746, "IO Bank", 15, 3, 2023, 867349);
        distributor.addSubscriber(corporateSubscriber2);
        
        Individual individualSubscriber3 = new Individual("Fatih Aksoy", "567 Side St",
                "4321-8765-0987-6543", 6, 2023, 123);
        distributor.addSubscriber(individualSubscriber3);

        Individual individualSubscriber4 = new Individual("Selin Yılmaz", "789 Beach St",
                "9876-5432-1098-7654", 9, 2023, 567);
        distributor.addSubscriber(individualSubscriber4);

        Corporation corporateSubscriber3 = new Corporation("SpaceX", "123 Rocket St",
                5432, "Space Bank", 8, 7, 2022, 987654);
        distributor.addSubscriber(corporateSubscriber3);

        Corporation corporateSubscriber4 = new Corporation("Tesla", "456 Electric St",
                8765, "Tesla Bank", 11, 4, 2022, 876543);
        distributor.addSubscriber(corporateSubscriber4);

        DateInfo subscriptionDates = new DateInfo(1, 1, 2023, 2024);
        DateInfo subscriptionDates2 = new DateInfo(3, 1, 2024, 2025);
        
        
        Subscription individualSubscription1 = new Subscription(subscriptionDates, 1, journal1, individualSubscriber1);
        Subscription corpSubscription1 = new Subscription(subscriptionDates, 1, journal2, corporateSubscriber1);
        Subscription individualSubscription2 = new Subscription(subscriptionDates, 1, journal3, individualSubscriber2);
        Subscription corpSubscription2 = new Subscription(subscriptionDates, 1, journal4, corporateSubscriber2);
        Subscription individualSubscription3 = new Subscription(subscriptionDates2, 2, journal5, individualSubscriber3);
        Subscription corpSubscription3 = new Subscription(subscriptionDates2, 3, journal6, corporateSubscriber3);
        Subscription individualSubscription4 = new Subscription(subscriptionDates2, 1, journal7, individualSubscriber4);
        Subscription corpSubscription4 = new Subscription(subscriptionDates2, 2, journal1, corporateSubscriber4);
        
        
        distributor.addSubscription(journal1.getiSSN(), individualSubscriber1, individualSubscription1);
        distributor.addSubscription(journal2.getiSSN(), corporateSubscriber1, corpSubscription1);
        distributor.addSubscription(journal3.getiSSN(), individualSubscriber2, individualSubscription2);
        distributor.addSubscription(journal4.getiSSN(), corporateSubscriber2, corpSubscription2);
        distributor.addSubscription(journal5.getiSSN(), individualSubscriber3, individualSubscription3);
        distributor.addSubscription(journal6.getiSSN(), corporateSubscriber3, corpSubscription3);
        distributor.addSubscription(journal7.getiSSN(), individualSubscriber4, individualSubscription4);
        distributor.addSubscription(journal1.getiSSN(), corporateSubscriber4, corpSubscription4);

        individualSubscription1.acceptPayment(journal1.getIssuePrice()/2);
        corpSubscription1.acceptPayment(journal2.getIssuePrice());
        individualSubscription2.acceptPayment(journal3.getIssuePrice());
        corpSubscription2.acceptPayment(journal4.getIssuePrice()/3);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Thread reportThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                    	DistributorGUI gui = new DistributorGUI(distributor);
                    	gui.getFrame().setVisible(true);
                    }
                });
                reportThread.start();
            }
        });
    }
}

