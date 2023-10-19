package org.example;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cart shop = new Cart();

        List<Product> products = new ArrayList<>();
        Product laptop1 = new Product(12345, "Lenovo IdeaPad 1", 25000);
        Product laptop2 = new Product(22345, "Lenovo IdeaPad 2", 24000);
        Product laptop3 = new Product(32345, "Lenovo IdeaPad 3", 23000);

        shop.addProduct(laptop1);
        shop.addProduct(laptop2);
        shop.addProduct(laptop3);

        System.out.println("Продукти у списку:");
        System.out.println(shop.getProducts().toString());

        shop.removeProduct(laptop3);
        System.out.println("Продукти у списку пiсля видалення:");
        System.out.println(shop.getProducts().toString());

        products.add(laptop1);
        products.add(laptop2);
        products.add(laptop3);
        Order orders = new Order(1001, products, true);

        shop.requestOrder(1001);

        System.out.println("Закази:");
        for (Order order : shop.getOrders()) {
            System.out.println("ID заказу: " + orders.getOrderId());
            System.out.println("Статус заказу: " + orders.getStatus());

            System.out.println("\n");

            System.out.println("Заказанi продукти:");
            for (Product product : order.getProducts()) {
                System.out.println(product);
            }
        }
    }
}