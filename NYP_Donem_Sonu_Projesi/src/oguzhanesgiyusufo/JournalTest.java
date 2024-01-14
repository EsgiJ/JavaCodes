package oguzhanesgiyusufo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JournalTest {

    private Journal journal;

    @Before
    public void setUp() {
        journal = new Journal("Science Journal", "123-4567", 12, 19.99);
    }

    @Test
    public void testAddValidSubscription() {
        Subscriber subscriber = new Individual("John Doe", "123 Main St", "1234567812345678", 12, 2023, 123);
        Subscription subscription = new Subscription(new DateInfo(1, 12, 2023, 2024), 1, journal, subscriber);

        journal.addSubscription(subscription);

        assertEquals(1, journal.getSubscriptions().size());
    }

    @Test
    public void testAddInvalidSubscription() {
        // Adding an invalid subscription without a subscriber
        Subscription subscription = new Subscription(new DateInfo(1, 12, 2023, 2024), 1, journal, null);

        journal.addSubscription(subscription);

        assertEquals(0, journal.getSubscriptions().size());
    }
}
