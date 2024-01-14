package oguzhanesgiyusufo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubscriptionTest {

    private Journal journal;
    private Subscriber subscriber;
    private Subscription subscription;

    @Before
    public void setUp() {
        journal = new Journal("Science Journal", "123-4567", 12, 19.99);
        subscriber = new Individual("John Doe", "123 Main St", "1234567812345678", 12, 2023, 123);
        subscription = new Subscription(new DateInfo(1, 12, 2023, 2024), 1, journal, subscriber);
    }

    @Test
    public void testAcceptPayment() {
        subscription.acceptPayment(10.0);

        assertEquals(10.0, subscription.getPayments().getReceivedPayment(), 0.001);
    }

    @Test
    public void testCanSendWithEnoughPaymentAndValidDates() {
        subscription.acceptPayment(25.0); // Assuming enough payment

        assertTrue(subscription.canSend(1, 2024));
    }
}	
