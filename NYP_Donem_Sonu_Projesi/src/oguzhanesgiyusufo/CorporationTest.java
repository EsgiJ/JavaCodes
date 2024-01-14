package oguzhanesgiyusufo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CorporationTest {

    private Subscriber corporation;

    @Before
    public void setUp() {
        corporation = new Corporation("XYZ Corp", "456 Business St", 12345, "Bank of Business", 5, 2023, 2023, 98765432);
    }

    @Test
    public void testGetBillingInformation() {
        assertEquals("Bank Code: 12345 Bank Name: Bank of Business Issue Day 5 Issue Month 5Issue Year 2023Account Number 98765432",
                corporation.getBillingInformation());
    }
}