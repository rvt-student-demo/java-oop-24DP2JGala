package rvt.OnlineShop_9_2;
import java.util.*;

public class ShoppingCart {
    private HashMap<String, Item> productCart;

    public ShoppingCart() {
        this.productCart = new HashMap<>();

    }

    public void add(String product, int price) {

        if (this.productCart.containsKey(product)) {
            this.productCart.get(product).increaseQuantity();
            return;

        }

        this.productCart.put(product, new Item(product, 1, price));

    }

    public int price() {
        int totalPrice = 0;
        for (Item product: this.productCart.values()) {
            totalPrice += product.price();

        }

        return totalPrice;

    }

    public void print() {
        for (Item product: this.productCart.values()) {
            System.out.println(product);

        }

    }

}