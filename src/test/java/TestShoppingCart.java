import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jonas P&ouml;hler
 * @since testingdemo 1.0
 */
public class TestShoppingCart {

    private ShoppingCart shoppingCart;
    private Product beer;
    private Product bread;

    @BeforeEach
    public void before() {
        this.beer = new Product();
        this.beer.setName("Beer");
        this.beer.setNetValue(0.50);
        this.beer.setTaxPercentage(0.07);

        this.bread = new Product();
        this.bread.setName("Bread");
        this.bread.setNetValue(1.50);
        this.bread.setTaxPercentage(0.19);

        this.shoppingCart = new ShoppingCart();
        this.shoppingCart.addProduct(beer, 2);
        this.shoppingCart.addProduct(bread, 1);

    }

    @Test
    public void testNetSum() {
        Assertions.assertEquals(2.5, shoppingCart.calculateNetPrice());
    }

    @Test
    public void testGrossSum() {
        Assertions.assertEquals(2.855, shoppingCart.calculateGrossPrice());
    }

    @Test
    public void testRemoving() {
        shoppingCart.removeProduct(beer, 1);
        Assertions.assertEquals(2.0, shoppingCart.calculateNetPrice());
        Assertions.assertEquals(2.32, shoppingCart.calculateGrossPrice());
        // alternative
        assertThat(shoppingCart.calculateGrossPrice()).isEqualTo(2.32);
    }
}
