package oguzhanesgiyusufo;

import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class DistributorGUI {
	public static final int DEFAULT_WIDTH = 1920;
	public static final int DEFAULT_HEIGHT = 1080;
	private JFrame frame;
	private Distributor distributor ;
	
	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public DistributorGUI(Distributor distributor) {
		this.distributor = distributor;
		frame = new JFrame();
		initComponents();
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private void initComponents() {
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Distributor System");
	
	    JButton btnListOrders = new JButton("List Sending Orders");
	    JButton btnListIncompletePayments = new JButton("List Incomplete Payments");;
	    JButton btnAddSubscription = new JButton("Add Subscription");
	    JButton btnAcceptPayment = new JButton("Accept Payment");
	    JButton btnListJournals = new JButton("List Journals");
        JButton btnListSubscribers = new JButton("List Subscribers");
        JButton btnSaveState = new JButton("Save State");
        JButton btnLoadState = new JButton("Load State");
        JButton btnReportAnnualButton = new JButton("Report  Annual Received Payments");
        JButton btnReportExpiredButton = new JButton("Report Expired Subscriptions");
        
        JPanel buttonPanel1 = new JPanel();
        JPanel buttonPanel2 = new JPanel();
        
        buttonPanel1.setLayout(new FlowLayout());
        buttonPanel2.setLayout(new FlowLayout()); 
        
        buttonPanel1.add(btnListOrders);
        buttonPanel1.add(btnListIncompletePayments);
        buttonPanel1.add(btnAddSubscription);
        buttonPanel1.add(btnAcceptPayment);
        buttonPanel1.add(btnListJournals);
        buttonPanel2.add(btnListSubscribers);
        buttonPanel2.add(btnSaveState);
        buttonPanel2.add(btnLoadState);
        buttonPanel2.add(btnReportAnnualButton);
        buttonPanel2.add(btnReportExpiredButton);
        
        DistributorTableModel tableModel = new DistributorTableModel();

        DistributorTableModel journalsTableModel = new DistributorTableModel();
        listSubscribersTableModel listSubscribersTableModel = new listSubscribersTableModel();
        listAllSendingOrdersTableModel listAllSendingOrdersTableModel = new listAllSendingOrdersTableModel();
        listAllSendingOrdersTableModel listIncompletePaymentsTableModel = new listAllSendingOrdersTableModel();
        AnnualTableModel annualTableModel= new AnnualTableModel();
        ExpiredSubscriptionsTableModel expiredSubscriptionsTableModel = new ExpiredSubscriptionsTableModel();
 
        

        JTable table = new JTable(tableModel);
        JTable journalsTable = new JTable(journalsTableModel);
        JTable subscribersTable = new JTable(listSubscribersTableModel);
        JTable listAllSendingOrdersTable = new JTable(listAllSendingOrdersTableModel);
        JTable listIncompletePaymentsTable = new JTable(listIncompletePaymentsTableModel);
        JTable annualTable = new JTable(annualTableModel);
        JTable expiredTable = new JTable(expiredSubscriptionsTableModel);
        
        table.setDefaultRenderer(Object.class, new DistributorTableCellRenderer());

        JPanel tablePanel = new JPanel(new GridLayout(3, 2));
        tablePanel.add(new JScrollPane(listAllSendingOrdersTable));
        tablePanel.add(new JScrollPane(listIncompletePaymentsTable));
        tablePanel.add(new JScrollPane(journalsTable));
        tablePanel.add(new JScrollPane(subscribersTable));
        tablePanel.add(new JScrollPane(annualTable));
        tablePanel.add(new JScrollPane(expiredTable));
        
        btnReportAnnualButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the year range from the user
			    String inputStartYear = JOptionPane.showInputDialog("Enter start year:");
			    String inputEndYear = JOptionPane.showInputDialog("Enter end year:");
			    try {
			        int startYear = Integer.parseInt(inputStartYear);
			        int endYear = Integer.parseInt(inputEndYear);

			        if (startYear > endYear) {
			            JOptionPane.showMessageDialog(null, "Invalid year range. Start year should be less than or equal to end year.");
			            return;
			        }
			        ArrayList<Subscription> receivedAnnualSubscriptionsList = distributor.listReceivedAnnuealPaymentSubscriptionsInGivenDate(startYear, endYear);

		            annualTableModel.setRowCount(0);

		            for (Subscription subscription : receivedAnnualSubscriptionsList) {
		            	Object[] row = {subscription.getSubscriber().getName(), subscription.getDates().getStartYear(),
		            			subscription.getDates().getEndYear(), subscription.getPayments().getReceivedPayment()};
		                annualTableModel.addRow(row);
		            }
			    }catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values for start and end years.");
			    }
        }});
        
        btnReportExpiredButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the year range from the user
			    String inputEndMonth = JOptionPane.showInputDialog("Enter end month:");
			    String inputEndYear = JOptionPane.showInputDialog("Enter end year:");
			    try {
			        int endMonth = Integer.parseInt(inputEndMonth);
			        int endYear = Integer.parseInt(inputEndYear);

			        ArrayList<Subscription> receivedExpiredSubscriptionsList = distributor.listExpiredSubscriptionsAfterGivenDate(endMonth, endYear);

		            expiredSubscriptionsTableModel.setRowCount(0);

		            for (Subscription subscription : receivedExpiredSubscriptionsList) {
		            	Object[] row = {subscription.getSubscriber().getName(), subscription.getDates().getEndMonth(),
		            			subscription.getDates().getEndYear(), subscription.getPayments().getReceivedPayment()};
		                expiredSubscriptionsTableModel.addRow(row);
		            }
			    }catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values for start and end years.");
			    }
        }});
        
        btnSaveState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fileName = JOptionPane.showInputDialog("Enter file name to save state:");
                if (fileName != null && !fileName.isEmpty()) {
                    distributor.saveState(fileName);
                    System.out.println("State saved to file: " + fileName);
                } else {
                    System.out.println("Invalid file name. Please enter a valid file name.");
                }
            }
        });

        btnLoadState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog("Enter file name to load state:");
                if (fileName != null && !fileName.isEmpty()) {
                    distributor.loadState(fileName);
                    System.out.println("State loaded from file: " + fileName);
                } else {
                    System.out.println("Invalid file name. Please enter a valid file name.");
                }
            }
        });
        
        btnListJournals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                journalsTableModel.setRowCount(0);

                for (Journal journal : distributor.getJournals().values()) {
                    for (Subscription subscription : journal.getSubscriptions()) {
                        Subscriber subscriber = subscription.getSubscriber();
                        if (subscriber != null) {
                            Object[] row = {journal.getiSSN(), journal.getName(), subscriber.getName(), subscriber.getAdress()};
                            journalsTableModel.addRow(row);
                        }
                    }
                }
            }
        });

        btnListSubscribers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	listSubscribersTableModel.setRowCount(0);

                for (Subscriber subscriber : distributor.getSubscribers()) {
                	Object[] row = {subscriber.getName(), subscriber.getAdress()};
                    listSubscribersTableModel.addRow(row);
                }
            }
        });

        btnAcceptPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputSubscriberName = JOptionPane.showInputDialog("Enter subscriber's name:");
                String inputJournalISSN = JOptionPane.showInputDialog("Enter journal ISSN:");

                if (inputSubscriberName != null && inputJournalISSN != null) {
                    Subscriber subscriber = distributor.searchSubscriber(inputSubscriberName);
                    Journal journal = distributor.searchJournal(inputJournalISSN);

                    if (subscriber != null && journal != null) {
                        Subscription subscription = journal.searchSubscription(subscriber);

                        if (subscription != null) {
                            double paymentAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter payment amount:"));
                            subscription.acceptPayment(paymentAmount);
                            System.out.println("Payment accepted for subscription of " + subscriber.getName() +
                                    " to Journal: " + journal.getName());
                        } else {
                            System.out.println("Subscription not found for " + subscriber.getName() +
                                    " to Journal: " + journal.getName());
                        }
                    } else {
                        System.out.println("Invalid subscriber name or journal ISSN. Please check your input.");
                    }
                }
            }
        });
        
	    btnAddSubscription.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String inputSubscriberName = JOptionPane.showInputDialog("Enter subscriber's name:");
	            String inputJournalISSN = JOptionPane.showInputDialog("Enter journal ISSN:");
	            String inputCopyCount = JOptionPane.showInputDialog("Enter copy count:");
	            String inputMonth = JOptionPane.showInputDialog("Enter the month (1-12):");
	            String inputYear = JOptionPane.showInputDialog("Enter the year:");

	            try {
	                int copyCount = Integer.parseInt(inputCopyCount);
	                int month = Integer.parseInt(inputMonth);
	                int year = Integer.parseInt(inputYear);

	                DateInfo newDateInfo = new DateInfo(month, month, year, year + 1);

	                Journal journal = distributor.searchJournal(inputJournalISSN);
	                Subscriber subscriber = distributor.searchSubscriber(inputSubscriberName);

	                if (subscriber == null) {
	                    // Ask for subscriber type
	                    String subscriberType = JOptionPane.showInputDialog("Enter subscriber type (Individual/Corporation):");

	                    if ("Individual".equalsIgnoreCase(subscriberType)) {
	                        String inputSubscriberAdress = JOptionPane.showInputDialog("Enter individual subscriber's address:");
	                        String creditCardNr = JOptionPane.showInputDialog("Enter credit card number:");
	                        String expireMonth = JOptionPane.showInputDialog("Enter credit card expiration month:");
	                        String expireYear = JOptionPane.showInputDialog("Enter credit card expiration year:");
	                        String CCV = JOptionPane.showInputDialog("Enter CCV:");
	                        
	                        int intExpireMonth = Integer.parseInt(expireMonth);
	                        int intexpireYear = Integer.parseInt(expireYear);
	                        int intCCV = Integer.parseInt(CCV);

	                        subscriber = new Individual(inputSubscriberName, inputSubscriberAdress, creditCardNr, intExpireMonth, intexpireYear, intCCV);
	                    } else if ("Corporation".equalsIgnoreCase(subscriberType)) {
	                    	String inputSubscriberAddress = JOptionPane.showInputDialog("Enter corporation subscriber's address:");

	                        // Additional information for Corporation
	                        int bankCode = Integer.parseInt(JOptionPane.showInputDialog("Enter bank code:"));
	                        String bankName = JOptionPane.showInputDialog("Enter bank name:");
	                        int issueDay = Integer.parseInt(JOptionPane.showInputDialog("Enter issue day:"));
	                        int issueMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter issue month:"));
	                        int issueYear = Integer.parseInt(JOptionPane.showInputDialog("Enter issue year:"));
	                        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter account number:"));

	                        subscriber = new Corporation(inputSubscriberName, inputSubscriberAddress, bankCode, bankName, issueDay, issueMonth, issueYear, accountNumber);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Invalid subscriber type. Please enter Individual or Corporation.");
	                        return;
	                    }
	                }

	                distributor.addSubscription(journal.getiSSN(), subscriber, new Subscription(newDateInfo, copyCount, journal, subscriber));

	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.");
	            }
	        }
	    });

	
	    btnListOrders.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String inputMonth = JOptionPane.showInputDialog("Enter the month (1-12):");
	            String inputYear = JOptionPane.showInputDialog("Enter the year:");

	            try {
	                int month = Integer.parseInt(inputMonth);
	                int year = Integer.parseInt(inputYear);
	
	                if (month >= 1 && month <= 12) {
	                    listAllSendingOrdersTableModel.setRowCount(0); // Clear previous rows
	                	List<Subscription> sendingOrders = distributor.listAllSendingOrders(month, year);
	                	for (Subscription subscription : sendingOrders) {
	                		Object[] row = {subscription.getDates().getStartMonth(), subscription.getDates().getStartYear(), 
	                				subscription.getDates().getEndMonth(), subscription.getDates().getEndYear(), subscription.getCopies(),
	                				subscription.getJournal().getName(), subscription.getSubscriber().getName(), subscription.getSubscriber().getAdress(),
	                				subscription.getPayments().getReceivedPayment(),subscription.getRequiredPayment()};
	                		listAllSendingOrdersTableModel.addRow(row);
						}
	                	
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid month. Please enter a valid month (1-12).");
	                }
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values for month and year.");
	            }
	        }
	    });
	
	    btnListIncompletePayments.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ArrayList<Subscription> incompleteSubscriptions = distributor.listIncompletePayments();

	            listIncompletePaymentsTableModel.setRowCount(0);

	            // Populate the table with incomplete subscriptions
	            for (Subscription subscription : incompleteSubscriptions) {
	            	Object[] row = {subscription.getDates().getStartMonth(), subscription.getDates().getStartYear(), 
            				subscription.getDates().getEndMonth(), subscription.getDates().getEndYear(), subscription.getCopies(),
            				subscription.getJournal().getName(), subscription.getSubscriber().getName(), subscription.getSubscriber().getAdress(),
            				subscription.getPayments().getReceivedPayment(),subscription.getRequiredPayment()};
	                listIncompletePaymentsTableModel.addRow(row);
	            }
	        }
	    });
	
	    GroupLayout layout = new GroupLayout(frame.getContentPane());
	    frame.getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
	    	    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    	        .addGap(20, 20, 20)
	    	        .addComponent(buttonPanel1)
	    	        .addComponent(buttonPanel2)
	    	        .addComponent(tablePanel)
	    	);

	    	layout.setVerticalGroup(
	    	    layout.createSequentialGroup()
	    	        .addGap(20)
	    	        	.addComponent(buttonPanel1)
	    	        	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	    	        	.addComponent(buttonPanel2)
	    	        	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	    	        	.addComponent(tablePanel)
	    	        	.addContainerGap(20, Short.MAX_VALUE)
	    	);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	}
    @SuppressWarnings("serial")
	private class DistributorTableModel extends DefaultTableModel {
        public DistributorTableModel() {
            addColumn("Journal ISSN");
            addColumn("Journal Name");
            addColumn("Subscriber Name");
            addColumn("Address");
        }
        public void addRow(Object... rowData) {
            super.addRow(rowData);
        }
    }
    @SuppressWarnings("serial")
	private class AnnualTableModel extends DefaultTableModel {
        public AnnualTableModel() {
        	addColumn("Subscriber Name");
            addColumn("Start Year");
            addColumn("End Year");
            addColumn("Total Received Payment");
        }

        public void addRow(Object... rowData) {
            super.addRow(rowData);
        }
    }
    @SuppressWarnings("serial")
	private class ExpiredSubscriptionsTableModel extends DefaultTableModel {
        public ExpiredSubscriptionsTableModel() {
        	addColumn("Subscriber Name");
            addColumn("End Month");
            addColumn("End Year");
            addColumn("Total Received Payment");
        }

        public void addRow(Object... rowData) {
            super.addRow(rowData);
        }
    }
    @SuppressWarnings("serial")
	private class listAllSendingOrdersTableModel extends DefaultTableModel {
        public listAllSendingOrdersTableModel() {
            addColumn("Start Month");
            addColumn("Start Year");
            addColumn("End Month");
            addColumn("End Year");
            addColumn("Copy Number");
            addColumn("Journal Name");
            addColumn("Subscriber Name");
            addColumn("Subscriber Adress");
            addColumn("Received Payment");
            addColumn("Required Payment");
        }
        public void addRow(Object... rowData) {
            super.addRow(rowData);
        }
    }
    @SuppressWarnings("serial")
	private class listSubscribersTableModel extends DefaultTableModel {
        public listSubscribersTableModel() {
            addColumn("Subscribers's Name");
            addColumn("Subscribers's Adress");
        }
        public void addRow(Object... rowData) {
            super.addRow(rowData);
        }
    }
    @SuppressWarnings("serial")
	private class DistributorTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (column == 0) { // Journal ISSN
                cell.setBackground(Color.YELLOW);
            } else if (column == 1) { // Journal Name
                cell.setBackground(Color.CYAN);
            } else if (column == 2) { // Subscriber Name
                cell.setBackground(Color.GREEN);
            } else if (column == 3) { // Address
                cell.setBackground(Color.ORANGE);
            }

            return cell;
        }
    }
}