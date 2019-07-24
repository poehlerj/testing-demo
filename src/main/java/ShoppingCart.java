import java.util.HashMap;
import java.util.Map;

/**
 * @author Jonas P&ouml;hler
 * @since testingdemo 1.0
 */
public class ShoppingCart {

    private final Map<Product, Integer> products = new HashMap<>();

    public Double calculateNetPrice() {
        return products.entrySet().stream()
                .map(it -> it.getKey().getNetValue() * it.getValue())
                .reduce(Double::sum)
                .orElse(0d);
    }

    public Double calculateGrossPrice() {
        return products.entrySet().stream()
                .map(it -> it.getKey().getNetValue() * it.getValue())
                .reduce(Double::sum)
                .orElse(0d);
    }

    public void addProduct(final Product product, final Integer amount) {
        products.compute(product, (k, v) -> (v == null) ? amount : v + amount);
    }

    public void removeProduct(final Product product, final Integer amount) {
        products.compute(product, (k, v) -> (v == null) ? -amount : v + amount);
    }
}
