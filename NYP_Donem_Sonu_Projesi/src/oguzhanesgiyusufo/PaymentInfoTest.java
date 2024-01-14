package oguzhanesgiyusufo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentInfoTest {

    private PaymentInfo paymentInfo;

    @Before
    public void setUp() {
        paymentInfo = new PaymentInfo(0.1, 50.0);
    }

    @Test
    public void testIncreasePayment() {
        paymentInfo.increasePayment(25.0);
        assertEquals(75.0, paymentInfo.getReceivedPayment(), 0.001);
    }

    @Test
    public void testGetReceivedPayment() {
        assertEquals(50.0, paymentInfo.getReceivedPayment(), 0.001);
    }

    @Test
    public void testGetDiscountRatio() {
        assertEquals(0.1, paymentInfo.getDiscountRatio(), 0.001);
    }

    @Test
    public void testSetReceivedPayment() {
        paymentInfo.setReceivedPayment(100.0);
        assertEquals(100.0, paymentInfo.getReceivedPayment(), 0.001);
    }
}