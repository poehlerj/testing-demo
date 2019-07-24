import java.util.Objects;

/**
 * @author Jonas P&ouml;hler
 * @since testingdemo 1.0
 */
public class Product {

    private String name;

    private Double netValue;

    private Double taxPercentage;

    public Double getGrossValue() {
        return getNetValue() * (1 + getTaxPercentage());
    }

    // Generated methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNetValue() {
        return netValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(netValue, product.netValue) &&
                Objects.equals(taxPercentage, product.taxPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, netValue, taxPercentage);
    }
}
