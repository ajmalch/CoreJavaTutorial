package com.pattern.delegation;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by AjmalCholassery on 6/15/15.
 */
public class CalculateNAVTest {

    @Test
    public void testComputeStockWorth(){
        final CalculateNAV calculateNAV = new CalculateNAV(ticker->new BigDecimal("6.01"));
        BigDecimal expected = new BigDecimal("601.00");

        assertEquals("Expected 601.00",0, calculateNAV.computeStockWorth("GOOG",100).compareTo(expected) );

    }
}
