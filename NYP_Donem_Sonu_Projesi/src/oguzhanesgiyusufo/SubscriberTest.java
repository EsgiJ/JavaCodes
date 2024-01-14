package oguzhanesgiyusufo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubscriberTest {

    private Subscriber subscriber;

    @Before
    public void setUp() {
        subscriber = new Individual("John Doe", "123 Main St", "1234567890123456", 12, 2024, 123);
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", subscriber.getName());
    }

    @Test
    public void testSetName() {
        subscriber.setName("Jane Doe");
        assertEquals("Jane Doe", subscriber.getName());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", subscriber.getAdress());
    }

    @Test
    public void testSetAddress() {
        subscriber.setAdress("456 Oak St");
        assertEquals("456 Oak St", subscriber.getAdress());
    }

    @Test
    public void testGetBillingInformation() {
        assertNotNull(subscriber.getBillingInformation());
    }
}