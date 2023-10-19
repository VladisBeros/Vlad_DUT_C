package org.example;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> produtsList;
    private List<Order> orderList;

    public Cart() {
        produtsList = new ArrayList<>();
        orderList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        produtsList.add(product);
    }

    public void removeProduct(Product product) {
        produtsList.remove(product);
    }

    public List<Product> getProducts() {
        return produtsList;
    }

    public List<Order> getOrders() {
        return orderList;
    }

    public void requestOrder(int orderId) {
        Order order = new Order(orderId, new ArrayList<>(produtsList), false);
        orderList.add(order);
    }
}