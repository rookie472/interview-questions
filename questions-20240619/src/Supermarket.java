import java.util.HashMap;
import java.util.Map;

public class Supermarket {

    private Map<String, Product> products;
    //消费阈值
    private double discountThreshold;
    //优惠金额
    private double discountAmount;

    public Supermarket() {
        products = new HashMap<>();
        discountThreshold = 0;
        discountAmount = 0;
    }

    public Supermarket(Map<String, Product> products, double discountThreshold, double discountAmount) {
        this.products = products;
        this.discountThreshold = discountThreshold;
        this.discountAmount = discountAmount;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public double getDiscountThreshold() {
        return discountThreshold;
    }

    public void setDiscountThreshold(double discountThreshold) {
        this.discountThreshold = discountThreshold;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double calculateTotalPrice(Map<String, Double> weights) {
        double total = 0;
        for (Map.Entry<String, Double> entry : weights.entrySet()) {
            Product product = products.get(entry.getKey());
            total += product.calculatePrice(entry.getValue());
        }
        if (total > discountThreshold) {
            total -= discountAmount;
        }
        return total;
    }
}
