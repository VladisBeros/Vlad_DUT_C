package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddProduct() {
        Product product1 = new Product(12345, "Lenovo IdeaPad 1", 25000);
        Product product2 = new Product(22345, "Lenovo IdeaPad 2", 24000);

        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testRemoveProduct() {
        Product product1 = new Product(12345, "Lenovo IdeaPad 1", 25000);
        Product product2 = new Product(22345, "Lenovo IdeaPad 2", 24000);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);

        assertEquals(1, cart.getProducts().size());
        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testRequestOrder() {
        Product product1 = new Product(12345, "Lenovo IdeaPad 1", 25000);
        Product product2 = new Product(22345, "Lenovo IdeaPad 2", 24000);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.requestOrder(54321);

        assertEquals(2, cart.getProducts().size());
        assertEquals(1, cart.getOrders().size());

        Order order = cart.getOrders().get(0);
        assertEquals(54321, order.getOrderId());
        assertFalse(order.getStatus());
        assertTrue(order.getProducts().contains(product1));
        assertTrue(order.getProducts().contains(product2));
    }
}
