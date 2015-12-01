package com.pattern.delegation;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by AjmalCholassery on 6/15/15.
 */
public class CalculateNAV {
    Function<String,BigDecimal> priceFinder;

    public CalculateNAV(Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public BigDecimal computeStockWorth(String ticker, int shares){
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    //other methods uses priceFinder can be implemented here
}
