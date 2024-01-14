package oguzhanesgiyusufo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IndividualTest {

    private Individual individual;

    @Before
    public void setUp() {
        individual = new Individual("John Doe", "123 Main St", "1234567890123456", 12, 2024, 123);
    }

    @Test
    public void testGetCreditCardNr() {
        assertEquals("1234567890123456", individual.getCreditCardNr());
    }

    @Test
    public void testSetCreditCardNr() {
        individual.setCreditCardNr("9876543210987654");
        assertEquals("9876543210987654", individual.getCreditCardNr());
    }

    @Test
    public void testGetExpireMonth() {
        assertEquals(12, individual.getExpireMonth());
    }

    @Test
    public void testSetExpireMonth() {
        individual.setExpireMonth(6);
        assertEquals(6, individual.getExpireMonth());
    }

    @Test
    public void testGetExpireYear() {
        assertEquals(2024, individual.getExpireYear());
    }

    @Test
    public void testSetExpireYear() {
        individual.setExpireYear(2025);
        assertEquals(2025, individual.getExpireYear());
    }

    @Test
    public void testGetCCV() {
        assertEquals(123, individual.getCCV());
    }

    @Test
    public void testSetCCV() {
        individual.setCCV(456);
        assertEquals(456, individual.getCCV());
    }

    @Test
    public void testGetBillingInformation() {
        assertNotNull(individual.getBillingInformation());
    }
}
