package oguzhanesgiyusufo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DistributorTest {

    private Distributor distributor;

    @Before
    public void setUp() {
        distributor = new Distributor();
    }

    @Test
    public void testAddJournal() {
        Journal journal = new Journal("Example Journal", "123-4567", 12, 19.99);

        assertTrue(distributor.addJournal(journal));
        assertNotNull(distributor.searchJournal("123-4567"));
    }

    @Test
    public void testAddSubscriber() {
        Subscriber subscriber = new Individual("John Doe", "123 Main St", "1234567812345678", 12, 2023, 123);

        assertTrue(distributor.addSubscriber(subscriber));
        assertNotNull(distributor.searchSubscriber("John Doe"));
    }

    @Test
    public void testAddSubscription() {
        Journal journal = new Journal("Example Journal", "123-4567", 12, 19.99);
        distributor.addJournal(journal);

        Subscriber subscriber = new Individual("John Doe", "123 Main St", "1234567812345678", 12, 2023, 123);
        distributor.addSubscriber(subscriber);

        Subscription subscription = new Subscription(new DateInfo(1, 1, 2022, 2023), 1, journal, subscriber);

        assertTrue(distributor.addSubscription("123-4567", subscriber, subscription));
        assertEquals(1, distributor.listAllSendingOrders(1, 2022).size());
    }

    @Test
    public void testListIncompletePayments() {
        Journal journal = new Journal("Example Journal", "123-4567", 12, 19.99);
        distributor.addJournal(journal);

        Subscriber subscriber = new Individual("John Doe", "123 Main St", "1234567812345678", 12, 2023, 123);
        distributor.addSubscriber(subscriber);

        Subscription subscription = new Subscription(new DateInfo(1, 1, 2022, 2023), 1, journal, subscriber);
        subscription.acceptPayment(10.0);

        assertTrue(distributor.addSubscription("123-4567", subscriber, subscription));
        assertEquals(1, distributor.listIncompletePayments().size());
    }
}
