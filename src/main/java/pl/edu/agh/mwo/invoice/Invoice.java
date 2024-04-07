package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    private final int invoiceNumber;
    private static int invoiceCount = 0;

    public Invoice(){this.invoiceNumber = ++invoiceCount;}

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        if (products.containsKey(product))
        {
            products.compute(product, (key, value) -> value + quantity);
        }
        else products.put(product, quantity);
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }


    public String printInvoice() {
        String invoiceHeader = "Faktura nr: " + invoiceNumber +"\n";
        int amount = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet())
        {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            invoiceHeader += product.getName() + " - " + product.getPrice() + " x " + quantity + "\n";
            amount +=1;
        }
        invoiceHeader += "Liczba pozycji: " + amount + "\n";
        return invoiceHeader;
    }

    public void getProducts() {
    }
}
