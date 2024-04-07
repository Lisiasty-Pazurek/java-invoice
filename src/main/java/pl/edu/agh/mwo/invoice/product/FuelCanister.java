package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanister extends Product {
    BigDecimal exciseTax = BigDecimal.valueOf(5.56);
    public FuelCanister(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0"));
    }
}
