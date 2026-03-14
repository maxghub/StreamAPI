import java.util.*;
import java.util.stream.*;

class Order {

    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return product + " : " + cost;
    }
}

public class StreamCollectorsExample {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        // 1️⃣ Print All Orders
        System.out.println("All Orders:");
        orders.forEach(System.out::println);

        // 2️⃣ Group by product
        Map<String, List<Order>> groupedOrders =
                orders.stream()
                        .collect(Collectors.groupingBy(Order::getProduct));

        System.out.println("\nGrouped Orders:");
        groupedOrders.forEach((product, orderList) -> {
            System.out.println(product + " -> " + orderList);
        });

        // 3️⃣ Calculate total cost per product
        Map<String, Double> totalCost =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getProduct,
                                Collectors.summingDouble(Order::getCost)
                        ));

        System.out.println("\nTotal Cost Per Product:");
        totalCost.forEach((product, cost) ->
                System.out.println(product + " = " + cost)
        );

        // 4️⃣ Sort products by total cost (descending)
        List<Map.Entry<String, Double>> sortedProducts =
                totalCost.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .collect(Collectors.toList());

        System.out.println("\nSorted Products by Total Cost:");
        sortedProducts.forEach(entry ->
                System.out.println(entry.getKey() + " : " + entry.getValue())
        );

        // 5️⃣ Top 3 expensive products
        System.out.println("\nTop 3 Most Expensive Products:");

        sortedProducts.stream()
                .limit(3)
                .forEach(entry ->
                        System.out.println(entry.getKey() + " : " + entry.getValue())
                );
    }
}