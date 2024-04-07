package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanister extends Product {
    BigDecimal exciseTax;

    public FuelCanister(String name, BigDecimal price, BigDecimal excise) {
        super(name, price, new BigDecimal("0"));
        exciseTax = excise;
    }
}
