package org.example;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products;
    private boolean status;

    public Order(int orderId, List<Product> products, boolean status) {
        this.orderId = orderId;
        this.products = products;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID заказу: " + orderId + ", Продукт: " + products + ", Статус: " + status + "\n";
    }
}