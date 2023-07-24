import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

    public Product(String type, double price, boolean discount, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Book", 50, false, LocalDate.of(2023, 1, 1)),
                new Product("Book", 100, true, LocalDate.of(2023, 2, 1)),
                new Product("Book", 150, false, LocalDate.of(2023, 3, 1)),
                new Product("Toy", 100, false, LocalDate.of(2022, 4, 1))
        );

        double totalCost = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getCreateDate().getYear() == LocalDate.now().getYear())
                .filter(p -> p.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total cost: " + totalCost);
    }
}
