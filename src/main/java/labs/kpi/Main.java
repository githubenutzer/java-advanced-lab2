package labs.kpi;

import labs.kpi.models.User;
import labs.kpi.models.Article;
import labs.kpi.models.Order;
import labs.kpi.validators.FieldValidator;

/**
 * Main class to demonstrate object validation using both reflection-based and manual methods.
 *
 * @author Oleksii Kyrychenko
 */
public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("customer_username", "CustomerPassword1234", 20);
            Article article = new Article("Laptop", 40000, 10);
            Order order = new Order("ORD-2024-12-00001", 1, 40000);

            System.out.println("\nValidating User using reflection...");
            long start = System.nanoTime();
            FieldValidator.validate(user);
            long end = System.nanoTime();
            System.out.println("Validation with reflection for User: " + (end - start) + " ns");

            System.out.println("\nValidating Article using reflection...");
            start = System.nanoTime();
            FieldValidator.validate(article);
            end = System.nanoTime();
            System.out.println("Validation with reflection for Article: " + (end - start) + " ns");

            System.out.println("\nValidating Order using reflection...");
            start = System.nanoTime();
            FieldValidator.validate(order);
            end = System.nanoTime();
            System.out.println("Validation with reflection for Order: " + (end - start) + " ns");

            System.out.println("\nManual validation for User...");
            start = System.nanoTime();
            if (user.getUsername() == null) {
                throw new IllegalArgumentException("Username cannot be null.");
            }
            if (user.getPassword().length() < 3 || user.getPassword().length() > 20) {
                throw new IllegalArgumentException("Password must be between 3 and 20 characters.");
            }
            if (user.getAge() < 18 || user.getAge() > 99) {
                throw new IllegalArgumentException("Age must be between 18 and 99.");
            }
            end = System.nanoTime();
            System.out.println("Validation without reflection for User: " + (end - start) + " ns");

            System.out.println("\nManual validation for Article...");
            start = System.nanoTime();
            if (article.getName() == null) {
                throw new IllegalArgumentException("Name cannot be null.");
            }
            if (article.getPrice() < 0) {
                throw new IllegalArgumentException("Price cannot be negative.");
            }
            if (article.getStock() < 0) {
                throw new IllegalArgumentException("Stock cannot be negative.");
            }
            end = System.nanoTime();
            System.out.println("Validation without reflection for Article: " + (end - start) + " ns");

            System.out.println("\nManual validation for Order...");
            start = System.nanoTime();
            if (order.getOrderId() == null) {
                throw new IllegalArgumentException("Order ID cannot be null.");
            }
            if (order.getQuantity() < 1) {
                throw new IllegalArgumentException("Quantity must be at least 1.");
            }
            if (order.getTotalAmount() < 0) {
                throw new IllegalArgumentException("Total amount cannot be negative.");
            }
            end = System.nanoTime();
            System.out.println("Validation without reflection for Order: " + (end - start) + " ns");

            System.out.println("\nAll validations completed!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}