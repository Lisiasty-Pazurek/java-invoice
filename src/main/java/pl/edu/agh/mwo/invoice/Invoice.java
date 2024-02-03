package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {


    public Invoice()
    {
        products = new ArrayList<Product>();
    }
    public Invoice(ArrayList<Product> products)
    {
        this.products = products;
    }
    private Collection<Product> products;

    public void addProduct(Product product) {
        if (product == null) {throw new IllegalArgumentException("bad things happening"); }
        products.add(product);
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity <=0) {throw new IllegalArgumentException("None products added"); }
        if (product == null) {throw new IllegalArgumentException("Empty product "); }
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }

    public BigDecimal getNetPrice() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Product product : products)
        {
            subtotal = subtotal.add(product.getPrice());
        }

        return subtotal;
    }

    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        for (Product product : products)
        {
            tax = tax.add(product.getPrice().multiply(product.getTaxPercent()));
        }
        return tax;
    }

    public BigDecimal getGrossPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products)
        {
            total = total.add(product.getPriceWithTax());
        }
        return total;
    }
}
