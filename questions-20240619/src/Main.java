import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //初始化超市、商品
        Supermarket supermarket = new Supermarket();
        Map<String, Product> products = new HashMap<>();
        products.put("苹果", new Product("苹果", 8.0, 1.0));
        products.put("草莓", new Product("草莓", 13.0, 1.0));
        products.put("芒果", new Product("芒果", 20.0, 1.0));

        //1.a购买2斤苹果、3斤草莓
        Map<String, Double> a = new HashMap<>();
        a.put("苹果",2.0);
        a.put("草莓",3.0);
        double result1 = supermarket.calculateTotalPrice(a);
        System.out.println(result1);//55.0

        //2.b买了3斤苹果，1.1斤草莓，2.3斤芒果
        Map<String, Double> b = new HashMap<>();
        b.put("苹果",3.0);
        b.put("草莓",1.1);
        b.put("芒果",2.3);
        double result2 = supermarket.calculateTotalPrice(b);
        System.out.println(result2);//84.3

        //超市促销，草莓八折
        Product strawberry = products.get("草莓");
        strawberry.setDiscount(0.8);
        Map<String, Double> c = new HashMap<>();
        c.put("苹果",5.0);
        c.put("草莓",2.1);
        c.put("芒果",2.3);
        double result3 = supermarket.calculateTotalPrice(c);
        System.out.println(result3);//107.84

        //继续促销，满100-10
        supermarket.setDiscountThreshold(100.0);
        supermarket.setDiscountAmount(10.0);
        Map<String, Double> d = new HashMap<>();
        d.put("苹果",5.0);
        d.put("草莓",2.1);
        d.put("芒果",2.3);
        double result4 = supermarket.calculateTotalPrice(c);
        System.out.println(result4);//97.84
    }
}