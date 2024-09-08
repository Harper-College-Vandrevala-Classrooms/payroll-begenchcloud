package com.csc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGrosspay {

    Grosspay grosspay;

    @BeforeEach
    void setUp() {
        grosspay = new Grosspay();
    }

    @Test
    void testZeroHoursWorked() {
        assertEquals(0, grosspay.grossPay(0), 0);
    }

    @Test
    void testFourtyHoursWorked() {
        assertEquals(671.20, grosspay.grossPay(40));
    }

    @Test
    void testFiftyHoursWorked() {
        assertEquals(922.90, grosspay.grossPay(50), 0.001);
    }
}
