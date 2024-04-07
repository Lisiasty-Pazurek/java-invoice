package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends Product {

    BigDecimal exciseTax;

    public BottleOfWine(String name, BigDecimal price, BigDecimal excise) {
        super(name, price, new BigDecimal("0.23"));
        exciseTax = excise;
    }
}
